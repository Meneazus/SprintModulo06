package cl.grupo02.sprintFinal.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.grupo02.sprintFinal.model.entity.Administrativo;
import cl.grupo02.sprintFinal.model.entity.Profesional;
import cl.grupo02.sprintFinal.model.entity.Usuario;
import cl.grupo02.sprintFinal.repository.AdministrativoRepository;

@Service
public class AdministrativoService {

    @Autowired
    private AdministrativoRepository administrativoRepository;
    
    // Guardar o actualizar un administrativo
    @Transactional
    public Administrativo guardarAdministrativo(Administrativo administrativo) {
        return administrativoRepository.save(administrativo);
    }
    
    @Transactional
    public Administrativo actualizarAdministrativo(Administrativo administrativo) {
        if (administrativoRepository.existsById(administrativo.getIdAdministrativo())) {
            return administrativoRepository.save(administrativo);
        } else {
            throw new IllegalArgumentException("No se puede actualizar un cliente inexistente.");
        }
    }
    
    public Administrativo obtenerAdministrativoPorUsuario(Usuario usuario) {
        return administrativoRepository.findByUsuario(usuario);
    }
        

    // Obtener un administrativo por su ID
    @Transactional(readOnly = true)
    public Optional<Administrativo> obtenerAdministrativoPorId(int id) {
        return administrativoRepository.findById(id);
    }

    // Obtener todos los administrativos
    @Transactional(readOnly = true)
    public List<Administrativo> obtenerTodosAdministrativos() {
        return administrativoRepository.findAll();
    }

    // Eliminar un administrativo por su ID
    @Transactional
    public void eliminarAdministrativo(int id) {
        administrativoRepository.deleteById(id);
    }
}
