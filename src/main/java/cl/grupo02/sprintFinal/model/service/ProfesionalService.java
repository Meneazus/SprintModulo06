package cl.grupo02.sprintFinal.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.grupo02.sprintFinal.model.entity.Profesional;
import cl.grupo02.sprintFinal.model.entity.Usuario;
import cl.grupo02.sprintFinal.repository.ProfesionalRepository;

@Service
public class ProfesionalService {

    @Autowired
    private ProfesionalRepository profesionalRepository;
    
    @Transactional
    public Profesional guardarProfesional(Profesional profesional) {
        return profesionalRepository.save(profesional);
    }
    
    @Transactional
    public Profesional actualizarProfesional(Profesional profesional) {
        if (profesionalRepository.existsById(profesional.getIdProfesional())) {
            return profesionalRepository.save(profesional);
        } else {
            throw new IllegalArgumentException("No se puede actualizar un cliente inexistente.");
        }
    }
    
    public Profesional obtenerProfesionalPorUsuario(Usuario usuario) {
        return profesionalRepository.findByUsuario(usuario);
    }
    
    

    @Transactional(readOnly = true)
    public Optional<Profesional> obtenerProfesionalPorId(int id) {
        return profesionalRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Profesional> obtenerTodosProfesionales() {
        return profesionalRepository.findAll();
    }

    @Transactional
    public void eliminarProfesional(int id) {
        profesionalRepository.deleteById(id);
    }
}
