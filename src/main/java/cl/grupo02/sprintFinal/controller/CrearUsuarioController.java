package cl.grupo02.sprintFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.grupo02.sprintFinal.model.entity.Administrativo;
import cl.grupo02.sprintFinal.model.entity.Cliente;
import cl.grupo02.sprintFinal.model.entity.FormularioUsuario;
import cl.grupo02.sprintFinal.model.entity.Profesional;
import cl.grupo02.sprintFinal.model.entity.Usuario;
import cl.grupo02.sprintFinal.model.service.AdministrativoService;
import cl.grupo02.sprintFinal.model.service.ClienteService;
import cl.grupo02.sprintFinal.model.service.ProfesionalService;
import cl.grupo02.sprintFinal.model.service.UsuarioService;



@Controller
public class CrearUsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private AdministrativoService administrativoService;
	@Autowired
	private ProfesionalService profesionalService;
	
	@RequestMapping (value="/crearUsuario")
	 public ModelAndView crearUsuario() {
	  return new ModelAndView("crearUsuario");
	 }
	
	@PostMapping("/crearUsuario")
	public String crearUsuario(@ModelAttribute FormularioUsuario form) {
	    ModelAndView modelAndView = new ModelAndView();
	    
	    if ("cliente".equals(form.getTipoUsuario())) {
	        Cliente cliente = new Cliente();
	        
	        cliente.setNombreUsuario(form.getNombreUsuario());
	        cliente.setApellidoUsuario(form.getApellidoUsuario());
	        cliente.setNickname(form.getNickname());
	        cliente.setContrasena(form.getContrasena());
	        cliente.setRunUsuario(form.getRunUsuario());
	        cliente.setCorreoUsuario(form.getCorreoUsuario());
	        cliente.setTelefonoUsuario(form.getTelefonoUsuario());
	        cliente.setTipoUsuario(form.getTipoUsuario());
	        
	        cliente.setNombreEmpresa(form.getNombreEmpresa());
	        cliente.setRutEmpresa(form.getRutEmpresa());
	        cliente.setTelefonoEmpresa(form.getTelefonoEmpresa());
	        cliente.setCorreoEmpresa(form.getCorreoEmpresa());
	        cliente.setDireccionEmpresa(form.getDireccionEmpresa());
	        cliente.setComunaEmpresa(form.getComunaEmpresa());
	        	        
	        clienteService.guardarCliente(cliente);
	        
	        modelAndView.addObject("mensaje", "Cliente creado exitosamente.");
	        modelAndView.setViewName("detalleCliente");
	        
	    } else if ("administrativo".equals(form.getTipoUsuario())) {
	        Administrativo administrativo = new Administrativo();
	        
	        administrativo.setAreaAdministrativo(form.getAreaAdministrativo());
	        administrativo.setExperienciaPrevia(form.getExperienciaPrevia());
	        
	        administrativoService.guardarAdministrativo(administrativo);
	        
	        
	        modelAndView.addObject("mensaje", "Administrativo creado exitosamente.");
	        modelAndView.setViewName("detalleAdministrativo");
	        
	    } else if ("profesional".equals(form.getTipoUsuario())) {
	        Profesional profesional = new Profesional();
	        
	        
	        profesional.setTituloProfesional(form.getTituloProfesional());
	        profesional.setFechaIngresoProfesional(form.getFechaIngresoProfesional());
	        
	        profesionalService.guardarProfesional(profesional);
	        
	        modelAndView.addObject("mensaje", "Profesional creado exitosamente.");
	        modelAndView.setViewName("detalleProfesional");
	    }

	    return "redirect:/usuarios";
	}


}
