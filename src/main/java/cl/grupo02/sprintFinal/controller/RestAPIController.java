package cl.grupo02.sprintFinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.grupo02.sprintFinal.model.entity.Capacitacion;
import cl.grupo02.sprintFinal.model.entity.Usuario;
import cl.grupo02.sprintFinal.model.service.CapacitacionService;
import cl.grupo02.sprintFinal.model.service.UsuarioService;

@RestController
public class RestAPIController {
	
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value="/api/usuarios", headers = "Accept=application/json")
	public List<Usuario> getUsuarios(){
		
		return usuarioService.obtenerTodosUsuarios();	
	}
	
	@Autowired
	private CapacitacionService capacitacionService;

	@RequestMapping(value="/api/capacitaciones", headers = "Accept=application/json")
	public List<Capacitacion> getCapacitaciones(){
		
		return capacitacionService.obtenerTodasCapacitaciones();	
	}
	
}
