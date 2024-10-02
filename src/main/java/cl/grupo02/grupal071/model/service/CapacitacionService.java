package cl.grupo02.grupal071.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.grupo02.grupal071.model.entity.Capacitacion;
import cl.grupo02.grupal071.model.repository.CapacitacionRepository;

@Service
public class CapacitacionService {

	@Autowired
	private CapacitacionRepository capacitacionRepository;

	// Guardar o Actualizar
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

}
