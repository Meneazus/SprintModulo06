package cl.grupo02.sprintFinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cl.grupo02.sprintFinal.model.entity.Usuario;
import cl.grupo02.sprintFinal.model.service.UsuarioService;


@Controller
public class ListarUsuariosController {

	@Autowired
	private UsuarioService usuarioService;

	// Mostrar lista de usuarios
    @GetMapping("/listarUsuarios")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.obtenerTodosUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "listarUsuarios";  // Retorna la vista 'lista.jsp' en la carpeta 'usuarios'
    }

}
