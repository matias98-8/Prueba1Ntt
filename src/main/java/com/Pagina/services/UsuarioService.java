package com.Pagina.services;

import java.util.List;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Pagina.models.Usuario;
import com.Pagina.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	// buscar por email
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	// insertar usuario
	public Usuario registroUsuario(Usuario usuario) {

		// hashear el password
		String password_hashed = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
		// sobre escribir la password
		usuario.setPassword(password_hashed);
		return usuarioRepository.save(usuario);
	}

	public void insertarUsuario(@Valid Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public List<Usuario> obtenerListaUsuarios() {

		return usuarioRepository.findAll();
	}

	public Usuario buscarUsuarioId(Long id) {

		return usuarioRepository.findById(id).get();
	}

	public void eliminarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

	public void eliminarUsuarioObjeto(Usuario usuario) {
		usuarioRepository.delete(usuario);

	}

	public void updateUsuario(@Valid Usuario usuario) {
		if (usuarioRepository.existsById(usuario.getId())) {
			usuarioRepository.save(usuario);
		}
	}

	public boolean loginUsuario(String email, String password) {

		Usuario usuario = usuarioRepository.findByEmail(email);

		if (usuario == null) {
			return false;
		} else {
			// if(password.equals(usuario.getPassword())) {
			if (BCrypt.checkpw(password, usuario.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}

}
