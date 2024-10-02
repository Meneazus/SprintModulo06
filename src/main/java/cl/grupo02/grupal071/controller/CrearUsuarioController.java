package cl.grupo02.grupal071.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.grupo02.grupal071.model.entity.Usuario;
import cl.grupo02.grupal071.model.service.UsuarioService;



@Controller
public class CrearUsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping (value="/crearUsuario")
	 public ModelAndView crearUsuario() {
	  return new ModelAndView("crearUsuario");
	 }
	
	@PostMapping("/crearUsuario")
	public ModelAndView crearUsuario(@ModelAttribute("usuario") Usuario usuario) {
	    Usuario nuevoUsuario = usuarioService.guardarUsuario(usuario);

	    ModelAndView modelAndView = new ModelAndView("/crearUsuario");
	    
	    // Verificar si es un nuevo usuario o una actualización
	    String mensaje = (usuario.getIdUsuario() > 0) 
	        ? "Usuario actualizado con éxito" 
	        : "Usuario creado con éxito";
	    
	    modelAndView.addObject("mensaje", mensaje);
	    return modelAndView;
	}

}
