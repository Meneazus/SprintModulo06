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

    public Usuario findByNickname(String nickname) {
        return usuarioRepository.findByNickname(nickname);
    }
	
	// Método para actualizar un usuario existente

    @Transactional
    public Usuario actualizarUsuario(Usuario usuario) {
        if (usuarioRepository.existsById(usuario.getIdUsuario())) {
            return usuarioRepository.save(usuario);
        } else {
            throw new IllegalArgumentException("No se puede actualizar un usuario inexistente.");
        }
    }

	// Método para guardar un nuevo usuario (creación)
    @Transactional
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

	// Obtener un usuario por su ID
    public Optional<Usuario> obtenerUsuarioPorId(int id) {
        return usuarioRepository.findById(id);
    }

	// Obtener todos los usuarios
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }

   	// Eliminar un usuario por su ID
	public void eliminarUsuario(int id) {
		if (usuarioRepository.existsById(id)) {
			usuarioRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("No se puede eliminar un usuario inexistente.");
		}
	}

	// Obtener usuarios por su tipo (cliente, profesional, administrativo) public
	  public List<Usuario> obtenerUsuariosPorTipo(String tipoUsuario) { return
	  usuarioRepository.findByTipoUsuario(tipoUsuario); }
	 
}
