package com.Pagina.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Pagina.models.Role;
import com.Pagina.repositories.RoleRepository;

@Service
public class RoleService {

		@Autowired
		RoleRepository rr;
		
		public List<Role> findByNombre(String nombre) {
			return rr.findByNombre(nombre);
		}
}
