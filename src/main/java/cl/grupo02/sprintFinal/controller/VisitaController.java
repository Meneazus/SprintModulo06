package cl.grupo02.sprintFinal.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.grupo02.sprintFinal.model.entity.Cliente;
import cl.grupo02.sprintFinal.model.entity.Visita;
import cl.grupo02.sprintFinal.model.service.ClienteService;
import cl.grupo02.sprintFinal.model.service.VisitaService;

import javax.validation.Valid;

@Controller
public class VisitaController {

    @Autowired
    private VisitaService visitaService;

    @Autowired
    private ClienteService clienteService;

    private static final Logger logger = LogManager.getLogger(VisitaController.class);

    // Mostrar lista de visitas (obtenidas desde la base de datos)
    @GetMapping("/obtenerVisita")
    public String listarVisitas(Model model) {
        // Obtener visitas con sus revisiones y clientes
        List<Visita> visitasLocales = visitaService.obtenerTodasVisitas();

        model.addAttribute("visitasLocales", visitasLocales);

        return "obtenerVisita"; // Asegúrate de que el nombre de la vista coincide
    }

    // Mostrar formulario para crear una visita
    @GetMapping("/crearVisita")
    public String mostrarCrearVisita(Model model) {
        logger.info("Solicitud GET: /crearVisita");

        Visita visita = new Visita();
        model.addAttribute("visita", visita); // Añadir un nuevo objeto visita al modelo

        // Obtener la lista de clientes para el dropdown
        List<Cliente> clientes = clienteService.obtenerTodosClientes();
        model.addAttribute("clientes", clientes);

        return "crearVisita"; // Retorna la vista del formulario para crear una visita
    }

    // Procesar la creación de una nueva visita
    @PostMapping("/crearVisita")
    public String crearVisita(@Valid Visita visita, 
                             BindingResult bindingResult, 
                             @RequestParam("idCliente") int idCliente, 
                             Model model, 
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            // Retornar a la vista de creación con los errores de validación
            List<Cliente> clientes = clienteService.obtenerTodosClientes();
            model.addAttribute("clientes", clientes);
            return "crearVisita";
        }

        // Obtener el Cliente basado en idCliente
        Cliente cliente = clienteService.obtenerClientePorId(idCliente);
        if (cliente == null) {
            // Manejar el caso donde el cliente no existe
            bindingResult.rejectValue("cliente", "error.visita", "Cliente no encontrado.");
            List<Cliente> clientes = clienteService.obtenerTodosClientes();
            model.addAttribute("clientes", clientes);
            return "crearVisita";
        }

        // Asociar el Cliente a la Visita
        visita.setCliente(cliente);

        try {
            // Guardar la visita en la base de datos
            Visita nuevaVisita = visitaService.guardarVisita(visita);
            logger.info("Visita guardada con éxito: " + nuevaVisita.getIdVisita());

            // Configurar un mensaje de éxito
            String mensaje = "Visita creada exitosamente.";

            // Añadir el mensaje como Flash Attribute
            redirectAttributes.addFlashAttribute("mensaje", mensaje);

            // Redirigir a la vista que lista las visitas
            return "redirect:/obtenerVisita";
        } catch (Exception e) {
            logger.error("Error al guardar la visita: ", e);
            // Configurar un mensaje de error
            String error = "Ha ocurrido un error al guardar la visita. Por favor, inténtalo de nuevo.";

            // Añadir el mensaje como Flash Attribute
            redirectAttributes.addFlashAttribute("error", error);

            // Retornar a la vista de creación
            return "redirect:/crearVisita";
        }
    }
}
