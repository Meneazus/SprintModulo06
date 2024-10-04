package cl.grupo02.sprintFinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.grupo02.sprintFinal.model.entity.Cliente;
import cl.grupo02.sprintFinal.model.entity.Pago;
import cl.grupo02.sprintFinal.model.service.ClienteService;
import cl.grupo02.sprintFinal.model.service.PagoService;



@Controller
public class PagoController {

	@Autowired
	private PagoService pagoService;
	
	@Autowired
	private ClienteService clienteService;

    @GetMapping(path = { "/crearPago" })
    public String mostrarPagos(Model model) {
        // Obtener la lista de clientes para mostrar los rutEmpresa
        List<Cliente> clientes = clienteService.obtenerTodosClientes();
        model.addAttribute("clientes", clientes); // Agregar la lista de clientes al modelo

        // Mostrar página
        return "crearPago"; // Retorna la vista 'crearPago.jsp'
    }

    @PostMapping("/crearPago")
    public ModelAndView crearPago(@ModelAttribute("pago") Pago pago) {
        // Guardar el pago (no es necesario asignarlo a una variable si no lo usas después)
        pagoService.guardarPago(pago);

        // Crear el ModelAndView y asignar la vista a 'crearPago'
        ModelAndView modelAndView = new ModelAndView("crearPago");

        // Cargar nuevamente la lista de clientes
        List<Cliente> clientes = clienteService.obtenerTodosClientes();
        modelAndView.addObject("clientes", clientes);

        // Verificar si es un nuevo pago o una actualización
        String mensaje = (pago.getIdPago() == 0) ? "Pago actualizado con éxito" : "Pago creado con éxito";
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
