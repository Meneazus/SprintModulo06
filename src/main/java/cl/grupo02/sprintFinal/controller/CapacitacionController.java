package cl.grupo02.sprintFinal.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import cl.grupo02.sprintFinal.model.entity.Capacitacion;
import cl.grupo02.sprintFinal.model.service.CapacitacionService;


@Controller
public class CapacitacionController {

    @Autowired
    private CapacitacionService capacitacionService;

    @Autowired
    private RestTemplate restTemplate; // Inyección de RestTemplate

    private static final Logger logger = LogManager.getLogger(CapacitacionController.class);

    // Mostrar lista de capacitaciones (obtenidas desde la base de datos y la API)
    @GetMapping("/obtenerCapacitacion")
    public String listarCapacitaciones(Model model) {
        // Obtener capacitaciones locales desde la base de datos
        // List<Capacitacion> capacitacionesLocales = capacitacionService.obtenerTodasCapacitaciones();

        // Consumir la API para obtener capacitaciones adicionales
        String apiUrl = "http://localhost:8080/sprintFinal/api/capacitaciones"; // URL de tu API
        ResponseEntity<Capacitacion[]> responseEntity = restTemplate.getForEntity(apiUrl, Capacitacion[].class);
        List<Capacitacion> capacitacionesApi = Arrays.asList(responseEntity.getBody());

        // Agregar ambas listas al modelo
        // model.addAttribute("capacitacionesLocales", capacitacionesLocales);
        model.addAttribute("capacitacionesApi", capacitacionesApi);

        return "obtenerCapacitacion"; // Retorna la vista 'obtenerCapacitacion.jsp'
    }

    // Mostrar formulario para crear una capacitación
    @GetMapping(path = { "/crearCapacitacion" })
    public String mostrarCrearCapacitacion(HttpServletRequest request, Model model) {
        logger.info("Solicitud GET: {}", request.getRequestURI());
        model.addAttribute("capacitacion", new Capacitacion()); // Añadir un nuevo objeto capacitación al modelo
        return "crearCapacitacion"; // Retorna la vista del formulario para crear una capacitación
    }

    // Procesar la creación de una nueva capacitación
    @PostMapping(path = { "/crearCapacitacion" })
    public ModelAndView crearCapacitacion(@ModelAttribute("capacitacion") Capacitacion capacitacion) {
        // Guardar la capacitación en la base de datos
        Capacitacion nuevaCapacitacion = capacitacionService.guardarCapacitacion(capacitacion);

        // Crear el objeto ModelAndView para configurar la respuesta y vista
        ModelAndView modelAndView = new ModelAndView("crearCapacitacion");

        // Configurar un mensaje de éxito
        String mensaje = capacitacionService.isNew(capacitacion) ? "Capacitación creada exitosamente."
                : "Capacitación actualizada exitosamente.";

        modelAndView.addObject("mensaje", mensaje); // Añadir el mensaje al modelo
        modelAndView.addObject("capacitacion", nuevaCapacitacion); // Mantener los datos en el modelo

        // Consumir la API desde RestTemplate después de crear la capacitación
        String apiUrl = "http://localhost:8080/sprintFinal/api/capacitaciones";
        ResponseEntity<Capacitacion[]> responseEntity = restTemplate.getForEntity(apiUrl, Capacitacion[].class);
        List<Capacitacion> capacitacionesApi = Arrays.asList(responseEntity.getBody());

        // Añadir la lista de capacitaciones obtenida de la API al modelo
        modelAndView.addObject("capacitacionesApi", capacitacionesApi);

        // Redirigir a la vista que lista las capacitaciones
        
        return new ModelAndView("redirect:/obtenerCapacitacion");
    }
}
