package cl.grupo02.sprintFinal.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.grupo02.sprintFinal.model.entity.Cliente;
import cl.grupo02.sprintFinal.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
    private ClienteRepository ClienteRepository;
	
    // Guardar o Actualizar
    public Cliente guardarCliente(Cliente cliente) {
        return ClienteRepository.save(cliente);
    }
    
    // Obtener una capacitación por su ID
    public Optional<Cliente> obtenerClientenPorId(int id) {
        return ClienteRepository.findById(id);
    }
    
    // Obtener todas las capacitaciones
    public List<Cliente> obtenerTodosClientes() {
        return ClienteRepository.findAll();
    }
	
    // Eliminar una capacitación por su ID
    public void eliminarCliente(int id) {
        ClienteRepository.deleteById(id);
    }
	
}