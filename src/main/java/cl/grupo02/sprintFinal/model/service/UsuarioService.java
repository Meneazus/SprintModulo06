package cl.grupo02.sprintFinal.model.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.grupo02.sprintFinal.model.entity.Usuario;
import cl.grupo02.sprintFinal.repository.UsuarioRepository;



@Service
public class UsuarioService {

	@Autowired
    private UsuarioRepository usuarioRepository;
	
    // Guardar o Actualizar
	@Transactional
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    // Obtener una capacitación por su ID
    public Optional<Usuario> obtenerUsuarionPorId(int id) {
        return usuarioRepository.findById(id);
    }
    
    // Obtener todas las capacitaciones
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }
	
    // Eliminar una capacitación por su ID
    public void eliminarUsuario(int id) {
        usuarioRepository.deleteById(id);
    }
	
}