package com.Pagina.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Pagina.services.UsuarioService;


@Controller
public class HomeController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("")
	//http://localhost:8080/
	// metodo inicial
	public String index() {

		return "index.jsp";
	}

}
