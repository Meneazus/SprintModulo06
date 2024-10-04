package cl.grupo02.sprintFinal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.grupo02.sprintFinal.model.entity.Capacitacion;
import cl.grupo02.sprintFinal.model.service.CapacitacionService;

@Controller
@RequestMapping("/capacitaciones")
public class CapacitacionController {

    @Autowired
    private CapacitacionService capacitacionService;

    // Listar capacitaciones
    @GetMapping
    public String listarCapacitaciones(Model model) {
        // Obtener capacitaciones desde la base de datos
        List<Capacitacion> capacitaciones = capacitacionService.obtenerTodasCapacitaciones();

        // Agregar la lista al modelo
        model.addAttribute("capacitaciones", capacitaciones);

        return "listarCapacitaciones"; // Asegúrate de que esta vista existe
    }

    // Mostrar formulario para crear una nueva capacitación
    @GetMapping("/nueva")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("capacitacion", new Capacitacion());
        return "crearCapacitacion";
    }

    // Procesar la creación de una nueva capacitación
    @PostMapping
    public String crearCapacitacion(@Valid @ModelAttribute("capacitacion") Capacitacion capacitacion,
                                    BindingResult result,
                                    RedirectAttributes redirectAttributes,
                                    Model model) {
        if (result.hasErrors()) {
            return "crearCapacitacion";
        }

        try {
            capacitacionService.guardarCapacitacion(capacitacion);
            redirectAttributes.addFlashAttribute("mensaje", "Capacitación creada exitosamente.");

            return "redirect:/capacitaciones";
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error al crear la capacitación: " + e.getMessage());
            return "crearCapacitacion";
        }
    }

    // Mostrar detalles de una capacitación (Opcional)
    @GetMapping("/{id}")
    public String verCapacitacion(@PathVariable("id") Integer id, Model model) {
        Optional<Capacitacion> optionalCapacitacion = capacitacionService.obtenerCapacitacionPorId(id);
        if (!optionalCapacitacion.isPresent()) {
            model.addAttribute("error", "Capacitación no encontrada.");
            return "redirect:/capacitaciones";
        }
        model.addAttribute("capacitacion", optionalCapacitacion.get());
        return "verCapacitacion"; // Crea este JSP si lo deseas
    }

    // Eliminar capacitación
    @GetMapping("/{id}/eliminar")
    public String eliminarCapacitacion(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            capacitacionService.eliminarCapacitacion(id);
            redirectAttributes.addFlashAttribute("mensaje", "Capacitación eliminada exitosamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar la capacitación: " + e.getMessage());
        }
        return "redirect:/capacitaciones";
    }

    // Editar capacitación
    @GetMapping("/{id}/editar")
    public String mostrarFormularioEdicion(@PathVariable("id") Integer id, Model model) {
        Optional<Capacitacion> optionalCapacitacion = capacitacionService.obtenerCapacitacionPorId(id);
        if (!optionalCapacitacion.isPresent()) {
            model.addAttribute("error", "Capacitación no encontrada.");
            return "redirect:/capacitaciones";
        }
        model.addAttribute("capacitacion", optionalCapacitacion.get());
        return "editarCapacitacion"; // Crea este JSP si lo deseas
    }

    @PostMapping("/{id}/editar")
    public String editarCapacitacion(@PathVariable("id") Integer id,
                                     @Valid @ModelAttribute("capacitacion") Capacitacion capacitacion,
                                     BindingResult result,
                                     RedirectAttributes redirectAttributes,
                                     Model model) {
        if (result.hasErrors()) {
            return "editarCapacitacion";
        }

        try {
            capacitacion.setIdCapacitacion(id); // Asegurarse de que el ID es correcto
            capacitacionService.guardarCapacitacion(capacitacion);
            redirectAttributes.addFlashAttribute("mensaje", "Capacitación actualizada exitosamente.");

            return "redirect:/capacitaciones";
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error al actualizar la capacitación: " + e.getMessage());
            return "editarCapacitacion";
        }
    }
}
