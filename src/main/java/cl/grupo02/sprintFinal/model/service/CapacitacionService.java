package cl.grupo02.sprintFinal.model.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.grupo02.sprintFinal.model.entity.Capacitacion;
import cl.grupo02.sprintFinal.repository.CapacitacionRepository;

@Service
public class CapacitacionService {

    @Autowired
    private CapacitacionRepository capacitacionRepository;

    @Autowired
    private RestTemplate restTemplate;

    // Guardar o Actualizar
    @Transactional
    public Capacitacion guardarCapacitacion(Capacitacion capacitacion) {
        return capacitacionRepository.save(capacitacion);
    }

    // Obtener una capacitación por su ID
    public Optional<Capacitacion> obtenerCapacitacionPorId(int id) {
        return capacitacionRepository.findById(id);
    }

    // Obtener todas las capacitaciones
    public List<Capacitacion> obtenerTodasCapacitaciones() {
        return capacitacionRepository.findAll();
    }

    // Eliminar una capacitación por su ID
    public void eliminarCapacitacion(int id) {
        capacitacionRepository.deleteById(id);
    }

    // Verificar si la capacitación es nueva
    public boolean isNew(Capacitacion capacitacion) {
        // Si el ID es 0 o no se encuentra en la base de datos, es nueva
        if (capacitacion.getIdCapacitacion() == 0) {
            return true;
        }
        return capacitacionRepository.existsById(capacitacion.getIdCapacitacion());
    }

    // Obtener capacitaciones desde una API externa (Opcional)
    public List<Capacitacion> obtenerCapacitacionesExternas() {
        String url = "http://localhost:8080/grupal08/api/capacitaciones";
        Capacitacion[] capacitaciones = restTemplate.getForObject(url, Capacitacion[].class);
        return Arrays.asList(capacitaciones);
    }
}
