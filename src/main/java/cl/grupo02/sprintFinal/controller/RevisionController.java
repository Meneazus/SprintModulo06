package cl.grupo02.sprintFinal.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.grupo02.sprintFinal.model.entity.Revision;
import cl.grupo02.sprintFinal.model.entity.Visita;
import cl.grupo02.sprintFinal.model.service.RevisionService;
import cl.grupo02.sprintFinal.model.service.VisitaService;

import javax.validation.Valid;

@Controller
public class RevisionController {

    @Autowired
    private RevisionService revisionService;

    @Autowired
    private VisitaService visitaService;

    private static final Logger logger = LogManager.getLogger(RevisionController.class);

    // Mostrar formulario para crear una revisión
    @GetMapping("/crearRevision")
    public String mostrarCrearRevision(@RequestParam("idVisita") int idVisita, Model model, RedirectAttributes redirectAttributes) {
        Optional<Visita> visitaOpt = visitaService.obtenerVisitaPorId(idVisita);
        if (visitaOpt.isPresent()) {
            Revision revision = new Revision();
            revision.setVisita(visitaOpt.get());
            model.addAttribute("revision", revision);
            return "crearRevision";
        } else {
            // Manejar el caso donde la visita no existe
            String error = "Visita no encontrada.";
            redirectAttributes.addFlashAttribute("error", error);
            return "redirect:/obtenerVisita";
        }
    }

    // Procesar la creación de una nueva revisión
    @PostMapping("/crearRevision")
    public String crearRevision(@Valid @ModelAttribute("revision") Revision revision, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            // Retornar a la vista de creación con los errores de validación
            return "crearRevision";
        }

        revisionService.guardarRevision(revision);
        String mensaje = "Revisión creada exitosamente.";
        redirectAttributes.addFlashAttribute("mensaje", mensaje);
        return "redirect:/listarRevisiones";
    }

    // Mostrar lista de revisiones
//    @GetMapping("/listarRevisiones")
//    public String listarRevisiones(Model model) {
//        List<Revision> revisiones = revisionService.obtenerTodasRevisiones();
//        model.addAttribute("revisiones", revisiones);
//        return "listarRevisiones";
//    }
}
