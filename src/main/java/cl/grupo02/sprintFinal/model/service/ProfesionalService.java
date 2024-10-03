package cl.grupo02.sprintFinal.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.grupo02.sprintFinal.model.entity.Profesional;
import cl.grupo02.sprintFinal.repository.ProfesionalRepository;

@Service
public class ProfesionalService {

	@Autowired
    private ProfesionalRepository ProfesionalRepository;
	
    // Guardar o Actualizar
    public Profesional guardarProfesional(Profesional profesional) {
        return ProfesionalRepository.save(profesional);
    }
    
    // Obtener una capacitación por su ID
    public Optional<Profesional> obtenerProfesionalnPorId(int id) {
        return ProfesionalRepository.findById(id);
    }
    
    // Obtener todas las capacitaciones
    public List<Profesional> obtenerTodosProfesionals() {
        return ProfesionalRepository.findAll();
    }
	
    // Eliminar una capacitación por su ID
    public void eliminarProfesional(int id) {
        ProfesionalRepository.deleteById(id);
    }
	
}