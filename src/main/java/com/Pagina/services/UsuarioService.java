package com.Pagina.services;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Pagina.models.Usuario;
import com.Pagina.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public void insertarUsuario(@Valid Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public List<Usuario> obtenerListaUsuarios() {
		
		return  usuarioRepository.findAll();
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
		if(usuarioRepository.existsById(usuario.getId())){
			usuarioRepository.save(usuario);
		}		
	}
	
	


}
