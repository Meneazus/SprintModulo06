package cl.grupo02.grupal071.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.grupo02.grupal071.model.entity.Capacitacion;
import cl.grupo02.grupal071.model.service.CapacitacionService;



@Controller
public class CapacitacionController {

	@Autowired
	private CapacitacionService capacitacionService;
	
	private static final Logger logger = LogManager.getLogger(CapacitacionController.class);

	// Mostrar lista de capacitaciones
    @GetMapping("/obtenerCapacitacion")
    public String listarCapacitaciones(Model model) {
        List<Capacitacion> capacitaciones = capacitacionService.obtenerTodasCapacitaciones();
        model.addAttribute("capacitaciones", capacitaciones);
        return "obtenerCapacitacion";  // Retorna la vista 'lista.jsp' en la carpeta 'capacitaciones'
    }

	@GetMapping(path = { "/crearCapacitacion" })
	public String mostrarCrearCapacitacion(HttpServletRequest request) {
		logger.info("Solicitud GET: {}", request.getRequestURI());
		return "crearCapacitacion";
	}

	@PostMapping(path = {"/crearCapacitacion"})
	public ModelAndView crearCapacitacion(@ModelAttribute("capacitacion") Capacitacion capacitacion) {
		// Guarda o actualiza la capacitación en la base de datos
		Capacitacion nuevaCapacitacion = capacitacionService.guardarCapacitacion(capacitacion);

		// Crear el objeto ModelAndView para configurar la respuesta y vista
		ModelAndView modelAndView = new ModelAndView("crearCapacitacion");

		// Configura un mensaje según si es una creación o actualización
		String mensaje;
		if (capacitacionService.isNew(capacitacion)) {
		    mensaje = "Capacitación creada exitosamente.";
		} else {
		    mensaje = "Capacitación actualizada exitosamente.";
		}
		modelAndView.addObject("mensaje", mensaje); // Añadir el mensaje al modelo
		modelAndView.addObject("capacitacion", nuevaCapacitacion); // Mantener los datos en el modelo

        return new ModelAndView ("redirect:/api/capacitaciones");
	}
}
