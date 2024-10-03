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
	    
	    if ("cliente".equals(form.getTipoUsuario())) {
	        Cliente cliente = new Cliente();
	        
			/*
			 * Acá se pinta los campos en "cliente". JPA los asigna automaticamente a la clase padre (usuarios).
			 */	
	        
	        // Datos correspondientes a la Entidad Usuarios (Tabla Usuarios)
	        cliente.setNombreUsuario(form.getNombreUsuario());
	        cliente.setApellidoUsuario(form.getApellidoUsuario());
	        cliente.setNickname(form.getNickname());
	        cliente.setContrasena(form.getContrasena());
	        cliente.setRunUsuario(form.getRunUsuario());
	        cliente.setCorreoUsuario(form.getCorreoUsuario());
	        cliente.setTelefonoUsuario(form.getTelefonoUsuario());
	        cliente.setTipoUsuario(form.getTipoUsuario());
	        
	        // Datos correspondientes a la Entidad Cliente (Tabla Clientes)
	        cliente.setNombreEmpresa(form.getNombreEmpresa());
	        cliente.setRutEmpresa(form.getRutEmpresa());
	        cliente.setTelefonoEmpresa(form.getTelefonoEmpresa());
	        cliente.setCorreoEmpresa(form.getCorreoEmpresa());
	        cliente.setDireccionEmpresa(form.getDireccionEmpresa());
	        cliente.setComunaEmpresa(form.getComunaEmpresa());
	        	        
	        clienteService.guardarCliente(cliente);
	               
	    } else if ("administrativo".equals(form.getTipoUsuario())) {
	        Administrativo administrativo = new Administrativo();
	        
	        // Datos correspondientes a la Entidad Usuarios (Tabla Usuarios)
	        administrativo.setNombreUsuario(form.getNombreUsuario());
	        administrativo.setApellidoUsuario(form.getApellidoUsuario());
	        administrativo.setNickname(form.getNickname());
	        administrativo.setContrasena(form.getContrasena());
	        administrativo.setRunUsuario(form.getRunUsuario());
	        administrativo.setCorreoUsuario(form.getCorreoUsuario());
	        administrativo.setTelefonoUsuario(form.getTelefonoUsuario());
	        administrativo.setTipoUsuario(form.getTipoUsuario());
	        
	        // Datos correspondientes a la Entidad Administrativo (Tabla Administrativos)
	        administrativo.setAreaAdministrativo(form.getAreaAdministrativo());
	        administrativo.setExperienciaPrevia(form.getExperienciaPrevia());
	        
	        administrativoService.guardarAdministrativo(administrativo);
	        	        
	    } else if ("profesional".equals(form.getTipoUsuario())) {
	        Profesional profesional = new Profesional();
	        
	        // Datos correspondientes a la Entidad Usuarios (Tabla Usuarios)
	        profesional.setNombreUsuario(form.getNombreUsuario());
	        profesional.setApellidoUsuario(form.getApellidoUsuario());
	        profesional.setNickname(form.getNickname());
	        profesional.setContrasena(form.getContrasena());
	        profesional.setRunUsuario(form.getRunUsuario());
	        profesional.setCorreoUsuario(form.getCorreoUsuario());
	        profesional.setTelefonoUsuario(form.getTelefonoUsuario());
	        profesional.setTipoUsuario(form.getTipoUsuario());
	        
	        // Datos correspondientes a la Entidad Profesional (Tabla Profesionales)
	        profesional.setTituloProfesional(form.getTituloProfesional());
	        profesional.setFechaIngresoProfesional(form.getFechaIngresoProfesional());
	        
	        profesionalService.guardarProfesional(profesional);
	        
	    }

	    return "redirect:/crearUsuario";
	}


}
