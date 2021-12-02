package com.Pagina.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Pagina.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	Usuario findByEmail(String email);
	Usuario findByNombre(String nombre);
	
	List<Usuario> findAll();
}
