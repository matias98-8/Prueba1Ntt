package com.Pagina.controllers;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Pagina.models.Usuario;
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
	
	@RequestMapping("/login")
	public String login() {
		return "usuario/login.jsp";
	}
	
	@RequestMapping("/registro")
	public String registro(@ModelAttribute("usuario") Usuario usuario) {
		return "usuario/registro.jsp";
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session,Model model) {
		//obteniendo las variables de session
		String nombre =(String) session.getAttribute("nombre_usuario");
		Long usuarioId =(Long) session.getAttribute("usuario_id");
		
		model.addAttribute("nombre_usuario", nombre);
		model.addAttribute("usuario_id",usuarioId);
		
		return "home.jsp";
	}
	
	
	
	

}
