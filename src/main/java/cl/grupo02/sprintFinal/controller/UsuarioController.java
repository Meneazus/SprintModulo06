package cl.grupo02.sprintFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

import cl.grupo02.sprintFinal.model.entity.*;
import cl.grupo02.sprintFinal.model.service.UsuarioService;
import cl.grupo02.sprintFinal.repository.UsuarioRepository.ValidacionActualizar;
import cl.grupo02.sprintFinal.repository.UsuarioRepository.ValidacionCrear;
import cl.grupo02.sprintFinal.model.service.AdministrativoService;
import cl.grupo02.sprintFinal.model.service.ClienteService;
import cl.grupo02.sprintFinal.model.service.ProfesionalService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProfesionalService profesionalService;

    @Autowired
    private AdministrativoService administrativoService;

    // Listar usuarios
    @GetMapping
    public String listarUsuarios(@RequestParam(required = false) String tipoUsuario, Model model) {
        List<Usuario> usuarios;
        if (tipoUsuario != null && !tipoUsuario.isEmpty()) {
            // Filtrar usuarios por tipo
            usuarios = usuarioService.obtenerUsuariosPorTipo(tipoUsuario);
        } else {
            // Obtener todos los usuarios
            usuarios = usuarioService.obtenerTodosUsuarios();
        }
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("tipoUsuario", tipoUsuario);  // Para recordar la selección en la vista
        return "listarUsuarios";
    }

    // Mostrar formulario para crear un usuario
    @GetMapping("/crear")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("formularioUsuario", new FormularioUsuario());
        return "crearUsuario";
    }

    // Procesar la creación de un nuevo usuario
    @PostMapping("/crear")
    public String crearUsuario(@Validated(ValidacionCrear.class) @ModelAttribute("formularioUsuario") FormularioUsuario form,
                               BindingResult result,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        if (result.hasErrors()) {
            return "crearUsuario";
        }

        try {
            // 1. Crear y guardar el Usuario
            Usuario usuario = new Usuario();
            mapearCamposComunes(usuario, form);
            usuarioService.guardarUsuario(usuario);

            // 2. Crear y guardar la entidad específica
            switch (form.getTipoUsuario()) {

                case "cliente":

                    Cliente cliente = new Cliente();
                    cliente.setUsuario(usuario);
                    // Mapear campos específicos de Cliente
                    cliente.setNombreEmpresa(form.getNombreEmpresa());
                    cliente.setRutEmpresa(form.getRutEmpresa());
                    cliente.setTelefonoEmpresa(form.getTelefonoEmpresa());
                    cliente.setCorreoEmpresa(form.getCorreoEmpresa());
                    cliente.setDireccionEmpresa(form.getDireccionEmpresa());
                    cliente.setComunaEmpresa(form.getComunaEmpresa());

                    clienteService.guardarCliente(cliente);

                    break;

                case "profesional":

                    Profesional profesional = new Profesional();
                    profesional.setUsuario(usuario);
                    // Mapear campos específicos de Profesional
                    profesional.setTituloProfesional(form.getTituloProfesional());
                    profesional.setFechaIngresoProfesional(form.getFechaIngresoProfesional());

                    profesionalService.guardarProfesional(profesional);
                    break;

                case "administrativo":

                    Administrativo administrativo = new Administrativo();
                    administrativo.setUsuario(usuario);
                    // Mapear campos específicos de Administrativo
                    administrativo.setAreaAdministrativo(form.getAreaAdministrativo());
                    administrativo.setExperienciaPrevia(form.getExperienciaPrevia());

                    administrativoService.guardarAdministrativo(administrativo);

                    break;
                default:
                    throw new IllegalArgumentException("Tipo de usuario inválido");
            }

            redirectAttributes.addFlashAttribute("mensaje", "Usuario creado exitosamente.");
            return "redirect:/usuarios";
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error al crear el usuario: " + e.getMessage());
            return "crearUsuario";
        }
    }

    // Mostrar formulario de edición de usuario
    @GetMapping("/{id}/editar")
    public String mostrarFormularioEdicion(@PathVariable("id") Integer id, Model model) {
        Optional<Usuario> optionalUsuario = usuarioService.obtenerUsuarioPorId(id);
        if (!optionalUsuario.isPresent()) {
            model.addAttribute("error", "Usuario no encontrado.");
            return "redirect:/usuarios";
        }
        Usuario usuario = optionalUsuario.get();

        // Obtener la entidad hija correspondiente
        FormularioUsuario formularioUsuario = mapearUsuarioAFormulario(usuario);
        model.addAttribute("formularioUsuario", formularioUsuario);
        return "editarUsuario";
    }

    // Procesar actualización de usuario
    @PostMapping("/{id}/editar")
    public String procesarActualizacionUsuario(@PathVariable("id") Integer id,
                                               @Validated(ValidacionActualizar.class) @ModelAttribute("formularioUsuario") FormularioUsuario form,
                                               BindingResult result,
                                               RedirectAttributes redirectAttributes,
                                               Model model) {
        System.out.println("Entrando a procesarActualizacionUsuario con ID: " + id);

        if (result.hasErrors()) {
            System.out.println("Errores de validación: " + result.getAllErrors());
            return "editarUsuario";
        }

        try {
            Optional<Usuario> optionalUsuario = usuarioService.obtenerUsuarioPorId(id);
            if (!optionalUsuario.isPresent()) {
                model.addAttribute("error", "Usuario no encontrado.");
                return "editarUsuario";
            }
            Usuario usuario = optionalUsuario.get();

            // Mapear formulario a usuario y actualizar
            mapearFormularioAUsuario(form, usuario);
            usuarioService.actualizarUsuario(usuario);

            redirectAttributes.addFlashAttribute("mensaje", "Usuario actualizado exitosamente.");
            return "redirect:/usuarios";
        } catch (Exception e) {
            model.addAttribute("error", "Error actualizando el usuario: " + e.getMessage());
            return "editarUsuario";
        }
    }

    // Métodos auxiliares

    private void mapearCamposComunes(Usuario usuario, FormularioUsuario form) {
        usuario.setNombreUsuario(form.getNombreUsuario());
        usuario.setApellidoUsuario(form.getApellidoUsuario());
        usuario.setNickname(form.getNickname());
        if (form.getContrasena() != null && !form.getContrasena().isEmpty()) {
            usuario.setContrasena(passwordEncoder.encode(form.getContrasena()));
        }
        usuario.setRunUsuario(form.getRunUsuario());
        usuario.setCorreoUsuario(form.getCorreoUsuario());
        usuario.setTelefonoUsuario(form.getTelefonoUsuario());
        usuario.setTipoUsuario(form.getTipoUsuario());
    }

    private FormularioUsuario mapearUsuarioAFormulario(Usuario usuario) {
        FormularioUsuario form = new FormularioUsuario();
        form.setIdUsuario(usuario.getIdUsuario());
        form.setNombreUsuario(usuario.getNombreUsuario());
        form.setApellidoUsuario(usuario.getApellidoUsuario());
        form.setNickname(usuario.getNickname());
        form.setRunUsuario(usuario.getRunUsuario());
        form.setCorreoUsuario(usuario.getCorreoUsuario());
        form.setTelefonoUsuario(usuario.getTelefonoUsuario());
        form.setTipoUsuario(usuario.getTipoUsuario());

        // Mapear campos específicos según el tipo de usuario
        switch (usuario.getTipoUsuario()) {
            case "cliente":
                Cliente cliente = clienteService.obtenerClientePorUsuario(usuario);
                if (cliente != null) {
                    form.setNombreEmpresa(cliente.getNombreEmpresa());
                    form.setRutEmpresa(cliente.getRutEmpresa());
                    form.setTelefonoEmpresa(cliente.getTelefonoEmpresa());
                    form.setCorreoEmpresa(cliente.getCorreoEmpresa());
                    form.setDireccionEmpresa(cliente.getDireccionEmpresa());
                    form.setComunaEmpresa(cliente.getComunaEmpresa());
                }
                break;

            case "profesional":

                Profesional profesional = profesionalService.obtenerProfesionalPorUsuario(usuario);
                if (profesional != null) {
                    form.setTituloProfesional(profesional.getTituloProfesional());
                    form.setFechaIngresoProfesional(profesional.getFechaIngresoProfesional());
                }

                break;

            case "administrativo":

                Administrativo administrativo = administrativoService.obtenerAdministrativoPorUsuario(usuario);
                if (administrativo != null) {
                    form.setAreaAdministrativo(administrativo.getAreaAdministrativo());
                    form.setExperienciaPrevia(administrativo.getExperienciaPrevia());
                }
                break;
        }
        return form;
    }

    private void mapearFormularioAUsuario(FormularioUsuario form, Usuario usuario) {
        usuario.setNombreUsuario(form.getNombreUsuario());
        usuario.setApellidoUsuario(form.getApellidoUsuario());
        usuario.setNickname(form.getNickname());
        usuario.setRunUsuario(form.getRunUsuario());
        usuario.setCorreoUsuario(form.getCorreoUsuario());
        usuario.setTelefonoUsuario(form.getTelefonoUsuario());
        // No actualizar la contraseña si está vacía
        if (form.getContrasena() != null && !form.getContrasena().isEmpty()) {
            usuario.setContrasena(passwordEncoder.encode(form.getContrasena()));
        }
        // Actualizar campos específicos según el tipo de usuario
        switch (usuario.getTipoUsuario()) {
            case "cliente":
                Cliente cliente = clienteService.obtenerClientePorUsuario(usuario);
                if (cliente != null) {
                    cliente.setNombreEmpresa(form.getNombreEmpresa());
                    cliente.setRutEmpresa(form.getRutEmpresa());
                    cliente.setTelefonoEmpresa(form.getTelefonoEmpresa());
                    cliente.setCorreoEmpresa(form.getCorreoEmpresa());
                    cliente.setDireccionEmpresa(form.getDireccionEmpresa());
                    cliente.setComunaEmpresa(form.getComunaEmpresa());

                    clienteService.actualizarCliente(cliente);
                }
                break;
            case "profesional":
                Profesional profesional = profesionalService.obtenerProfesionalPorUsuario(usuario);
                if (profesional != null) {
                    profesional.setTituloProfesional(form.getTituloProfesional());
                    profesional.setFechaIngresoProfesional(form.getFechaIngresoProfesional());

                    profesionalService.actualizarProfesional(profesional);
                }
                break;
            case "administrativo":

                Administrativo administrativo = administrativoService.obtenerAdministrativoPorUsuario(usuario);
                if (administrativo != null) {
                    administrativo.setAreaAdministrativo(form.getAreaAdministrativo());
                    administrativo.setExperienciaPrevia(form.getExperienciaPrevia());

                    administrativoService.actualizarAdministrativo(administrativo);
                }
                break;
        }
    }

    // Eliminar usuario
    @GetMapping("/{id}/eliminar")
    public String eliminarUsuario(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            usuarioService.eliminarUsuario(id);
            redirectAttributes.addFlashAttribute("mensaje", "Usuario eliminado exitosamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar el usuario: " + e.getMessage());
        }
        return "redirect:/usuarios";
    }
}
