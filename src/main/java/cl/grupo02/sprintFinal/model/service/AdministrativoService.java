package cl.grupo02.sprintFinal.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.grupo02.sprintFinal.model.entity.Administrativo;
import cl.grupo02.sprintFinal.repository.AdministrativoRepository;


@Service
public class AdministrativoService {

	@Autowired
    private AdministrativoRepository AdministrativoRepository;
	
    // Guardar o Actualizar
    public Administrativo guardarAdministrativo(Administrativo administrativo) {
        return AdministrativoRepository.save(administrativo);
    }
    
    // Obtener una capacitación por su ID
    public Optional<Administrativo> obtenerAdministrativonPorId(int id) {
        return AdministrativoRepository.findById(id);
    }
    
    // Obtener todas las capacitaciones
    public List<Administrativo> obtenerTodosAdministrativos() {
        return AdministrativoRepository.findAll();
    }
	
    // Eliminar una capacitación por su ID
    public void eliminarAdministrativo(int id) {
        AdministrativoRepository.deleteById(id);
    }
	
}