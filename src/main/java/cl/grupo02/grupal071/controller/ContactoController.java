package cl.grupo02.grupal071.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ContactoController {

	@GetMapping(path = { "/contacto" })
	public String mostrarContacto(HttpServletRequest request) {

		// Mostrar página
		return "contacto";
	}

	@RequestMapping(path = {"/contacto"})
	public ModelAndView crearContacto(@RequestParam("email") String email, @RequestParam("nombre") String nombre,
			@RequestParam("asunto") String asunto, @RequestParam("mensaje") String mensaje) {
	    ModelAndView modelAndView = new ModelAndView("contacto");

	    // Imprimir los datos recibidos por consola
	    System.out.println("===== Datos del Formulario de Contacto =====");
	    System.out.println("Correo Electrónico: " + email);
	    System.out.println("Nombre: " + nombre);
	    System.out.println("Asunto: " + asunto);
	    System.out.println("Mensaje: " + mensaje);
	    System.out.println("==========================================");

	    // Mensaje fijo de confirmación para la vista
	    modelAndView.addObject("mensaje", "Formulario de contacto enviado correctamente.");

	    return modelAndView;
	}
}



