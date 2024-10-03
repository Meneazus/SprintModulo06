package cl.grupo02.sprintFinal.model.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.grupo02.sprintFinal.model.entity.Administrativo;
import cl.grupo02.sprintFinal.model.entity.Cliente;
import cl.grupo02.sprintFinal.model.entity.Profesional;
import cl.grupo02.sprintFinal.model.entity.Usuario;
import cl.grupo02.sprintFinal.repository.UsuarioRepository;



@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método para actualizar un usuario existente
    @Transactional
    public Usuario actualizarUsuario(Usuario usuario) {
        if (usuario.getIdUsuario() != 0) {
            if (usuario instanceof Cliente) {
                return usuarioRepository.save((Cliente) usuario);
            } else if (usuario instanceof Profesional) {
                return usuarioRepository.save((Profesional) usuario);
            } else if (usuario instanceof Administrativo) {
                return usuarioRepository.save((Administrativo) usuario);
            } else {
                return usuarioRepository.save(usuario);
            }
        } else {
            throw new IllegalArgumentException("El ID del usuario es inválido.");
        }
    }

    // Método para guardar un nuevo usuario (creación)
    @Transactional
    public Usuario guardarUsuario(Usuario usuario) {
        if (usuario.getIdUsuario() == 0) {
            return usuarioRepository.save(usuario);
        } else {
            throw new IllegalArgumentException("No se puede crear un usuario con ID existente.");
        }
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
        usuarioRepository.deleteById(id);
    }

    // Obtener usuarios por su tipo (cliente, profesional, administrativo)
    public List<Usuario> obtenerUsuariosPorTipo(String tipoUsuario) {
        return usuarioRepository.findByTipoUsuario(tipoUsuario);
    }
}
