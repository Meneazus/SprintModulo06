package cl.grupo02.grupal071.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.grupo02.grupal071.model.entity.Pago;
import cl.grupo02.grupal071.model.repository.PagoRepository;

@Service
public class PagoService {

	@Autowired
	private PagoRepository pagoRepository;
	
	public Pago guardarPago(Pago pago) {
		return pagoRepository.save(pago);
	}
	
    // Obtener un pago por su ID
    public Optional<Pago> obtenerPagoPorId(int id) {
        return pagoRepository.findById(id);
    }
    
    // Obtener todos los Pagos
    public List<Pago> obtenerTodosPagos() {
        return pagoRepository.findAll();
    }
	
    // Eliminar un pago por su ID
    public void eliminarPago(int id) {
        pagoRepository.deleteById(id);
    }
	
}
