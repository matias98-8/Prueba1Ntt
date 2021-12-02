package com.Pagina.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Pagina.models.Usuario;
import com.Pagina.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	//este modificar
	@RequestMapping("")
	public String usuario(@ModelAttribute("usuario") Usuario usuario, Model model) {

		model.addAttribute("listaUsuarios", usuarioService.obtenerListaUsuarios());
		return "usuario/usuario.jsp";
	}

	// capturar la informacion del formulario
	
	@RequestMapping("/login")
	public String login(Principal principal, Model model,HttpSession session) {
		String nombre= principal.getName();
	
		Usuario usuario = usuarioService.finByNombre(nombre);
		model.addAttribute("nombre_usuario", usuario.getNombre());
		
		return "home.jsp";
	
	}

	
	/*@RequestMapping("/login")
	public String login(@RequestParam("email") String email,
			@RequestParam("password") String password,
			HttpSession session
			) 
	{
		System.out.println(email + " " + password);

		boolean resultado = usuarioService.loginUsuario(email, password);
		if (resultado) {
			Usuario usuario = usuarioService.findByEmail(email);
			session.setAttribute("usuario_id", usuario.getId());
			session.setAttribute("nombre_usuario", usuario.getNombre());
			return "redirect:/home";
		} else {
			return "redirect:/login";
		}
	}*/

	@RequestMapping("/registrarjsp")
	public String registrarjsp(@ModelAttribute("usuario") Usuario usuario) {
		return "usuario/registro.jsp";
	}

	@RequestMapping("/registrar")
	public String registrar(@Valid @ModelAttribute("usuario") Usuario usuario) {
	
		Usuario usuario2 = usuarioService.findByEmail(usuario.getEmail());
		if(usuario2 != null) {
		System.out.println("Usuario ya existe");
		}else {
			usuarioService.persistirUsuarioRol(usuario);
		}
		return "redirect:/login";
	}

	@RequestMapping("/eliminar")
	public String eliminarUsuario(@RequestParam("id") Long id) {

		Usuario usuario = usuarioService.buscarUsuarioId(id);

		if (usuario != null) {
			usuarioService.eliminarUsuarioObjeto(usuario);
		}

		return "redirect:/usuario";
	}

	@RequestMapping("/{id}/editar")
	public String edit(@PathVariable("id") Long id, Model model) {
		System.out.println("editar");
		Usuario usuario = usuarioService.buscarUsuarioId(id);
		if (usuario != null) {
			model.addAttribute("usuario", usuario);
			return "/usuario/editar.jsp";
		}

		return "redirect:/usuario";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result) {
		System.out.println("Update");
		if (result.hasErrors()) {
			return "/usuario/editar.jsp";
		} else {
			usuarioService.updateUsuario(usuario);
			return "redirect:/usuario";
		}
	}

}
