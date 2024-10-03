package cl.grupo02.sprintFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.grupo02.sprintFinal.model.entity.Usuario;
import cl.grupo02.sprintFinal.model.service.UsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    // Método para cargar el formulario de edición de usuario
    @GetMapping("/editarUsuario")
    public String editarUsuario(@RequestParam("id") int id, Model model) {
        // Obtener el usuario por su ID
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con ID: " + id));
        
        // Agregar el usuario al modelo
        model.addAttribute("usuario", usuario);
        
        // Agregar el tipo de usuario para usarlo en el JSP
        model.addAttribute("tipoUsuario", usuario.getTipoUsuario().toLowerCase());

        return "editarUsuario";
    }
  
    
    // Método para actualizar un usuario
    @PostMapping("/actualizarUsuario")
    public String actualizarUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {
        System.out.println("ID del Usuario recibido: " + usuario.getIdUsuario());  // Debug: Verificar el valor recibido

        // Verifica que el ID no es 0
        if (usuario.getIdUsuario() == 0) {
            throw new IllegalArgumentException("No se puede actualizar un usuario con un ID inválido.");
        }

        // Guardar los cambios realizados en el usuario
        usuarioService.guardarUsuario(usuario);

        // Redirigir al listado de usuarios después de la actualización
        return "redirect:/listarUsuarios";
    }


    
    // Método para manejar la creación de nuevos usuarios (opcional)
    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {
        usuarioService.guardarUsuario(usuario);
        return "redirect:/listarUsuarios";
    }
    

}

