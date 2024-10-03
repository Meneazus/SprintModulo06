package cl.grupo02.grupal071.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.grupo02.grupal071.model.entity.Pago;
import cl.grupo02.grupal071.model.service.PagoService;

@Controller
public class PagoController {

	@Autowired
	private PagoService pagoService;

	@GetMapping(path = { "/crearPago" })
	public String paginaInicio(Model model) {
		// Obtener la lista de pagos o RUT de empresas
		List<Pago> pagos = pagoService.obtenerTodosPagos();
		model.addAttribute("pagos", pagos); // Agregar la lista de pagos al modelo

		// Mostrar página
		return "crearPago"; // Retorna la vista 'crearPago.jsp'
	}

	@PostMapping("/crearPago")
	public ModelAndView crearPago(@ModelAttribute("pago") Pago pago) {
		Pago nuevoPago = pagoService.guardarPago(pago);

		ModelAndView modelAndView = new ModelAndView("/crearPago");
		modelAndView.addObject("pago", nuevoPago);

		// Verificar si es un nuevo pago o una actualización
		String mensaje = (pago.getIdPago() > 0) ? "Pago actualizado con éxito" : "Pago creado con éxito";

		modelAndView.addObject("mensaje", mensaje);
		return modelAndView;
	}

	// Mostrar lista de pagos
	@GetMapping("/listarPagos")
	public String listarPagos(Model model) {
		List<Pago> pagos = pagoService.obtenerTodosPagos();
		model.addAttribute("pagos", pagos);
		return "listarPagos"; // Retorna la vista 'listarPagos.jsp'
	}
}
