package cl.grupo02.sprintFinal.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.grupo02.sprintFinal.model.entity.Visita;
import cl.grupo02.sprintFinal.repository.VisitaRepository;

import javax.transaction.Transactional;

@Service
public class VisitaService {

    @Autowired
    private VisitaRepository visitaRepository;

    // Guardar o Actualizar
    public Visita guardarVisita(Visita visita) {
        return visitaRepository.save(visita);
    }

    // Obtener una visita por su ID
    public Optional<Visita> obtenerVisitaPorId(int id) {
        return visitaRepository.findById(id);
    }

    // Obtener todas las visitas con sus revisiones
    @Transactional
    public List<Visita> obtenerTodasVisitas() {
        return visitaRepository.findAllWithClienteAndRevisiones();
    }

    // Eliminar una visita por su ID
    public void eliminarVisita(int id) {
        visitaRepository.deleteById(id);
    }
}
