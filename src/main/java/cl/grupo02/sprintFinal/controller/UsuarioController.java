package cl.grupo02.sprintFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import cl.grupo02.sprintFinal.model.entity.Usuario;
import cl.grupo02.sprintFinal.model.service.UsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Método para manejar la actualización de un usuario
    @PostMapping("/actualizarUsuario")
    public String actualizarUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {
        System.out.println("ID del Usuario recibido: " + usuario.getIdUsuario()); // Debug: Verificar el valor recibido
        
        // Verifica que el ID no sea 0 (porque es int)
        if (usuario.getIdUsuario() != 0) {
            // Llamar al método de actualización
            usuarioService.actualizarUsuario(usuario);
        } else {
            throw new IllegalArgumentException("No se puede actualizar un usuario con un ID inválido.");
        }

        // Redirigir al listado de usuarios después de la actualización
        return "redirect:/listarUsuarios";
    }

    // Método para manejar la creación de nuevos usuarios (opcional, si lo necesitas)
    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {
        // Asegúrate de que el ID sea 0 para crear un nuevo usuario
        if (usuario.getIdUsuario() == 0) {
            usuarioService.guardarUsuario(usuario);
        } else {
            throw new IllegalArgumentException("No se puede crear un usuario con ID existente.");
        }
        return "redirect:/listarUsuarios";
    }
}


