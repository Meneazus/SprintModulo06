package cl.grupo02.sprintFinal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.grupo02.sprintFinal.model.entity.Usuario;
import cl.grupo02.sprintFinal.model.service.UsuarioService;


@Controller
public class ListarUsuariosController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listarUsuarios")
    public String listarUsuarios(@RequestParam(required = false) String tipoUsuario, Model model) {
        List<Usuario> usuarios = new ArrayList<>();  // Lista vacía por defecto
        if (tipoUsuario != null && !tipoUsuario.isEmpty()) {
            // Solo cargamos los usuarios si se selecciona un tipo de usuario
            usuarios = usuarioService.obtenerUsuariosPorTipo(tipoUsuario);
        }
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("tipoUsuario", tipoUsuario);  // Para recordar la selección
        return "listarUsuarios";  // Nombre del JSP
    }
}
