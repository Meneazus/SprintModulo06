package cl.grupo02.sprintFinal.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Importación correcta

import cl.grupo02.sprintFinal.model.entity.Cliente;
import cl.grupo02.sprintFinal.model.entity.FormularioUsuario;
import cl.grupo02.sprintFinal.model.entity.Usuario;
import cl.grupo02.sprintFinal.repository.ClienteRepository;
import cl.grupo02.sprintFinal.repository.UsuarioRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Transactional
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    
    public Cliente obtenerClientePorUsuario(Usuario usuario) {
        return clienteRepository.findByUsuario(usuario);
    }
    
    @Transactional
    public Cliente actualizarCliente(Cliente cliente) {
        if (clienteRepository.existsById(cliente.getIdCliente())) {
            return clienteRepository.save(cliente);
        } else {
            throw new IllegalArgumentException("No se puede actualizar un cliente inexistente.");
        }
    }
    


    @Transactional(readOnly = true)
    public Optional<Cliente> obtenerClientePorId(int id) {
        return clienteRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Cliente> obtenerTodosClientes() {
        return clienteRepository.findAll();
    }


    @Transactional
    public void eliminarCliente(int id) {
        clienteRepository.deleteById(id);
    }
    
    
    public void crearCliente(FormularioUsuario form) {
        // Crear y guardar el Usuario
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(form.getNombreUsuario());
        usuario.setApellidoUsuario(form.getApellidoUsuario());
        usuario.setNickname(form.getNickname());
        usuario.setContrasena(form.getContrasena());
        usuario.setRunUsuario(form.getRunUsuario());
        usuario.setCorreoUsuario(form.getCorreoUsuario());
        usuario.setTelefonoUsuario(form.getTelefonoUsuario());
        usuario.setTipoUsuario("cliente");
        usuario = usuarioRepository.save(usuario);

        // Crear y guardar el Cliente
        Cliente cliente = new Cliente();
        cliente.setUsuario(usuario);
        cliente.setNombreEmpresa(form.getNombreEmpresa());
        cliente.setRutEmpresa(form.getRutEmpresa());
        cliente.setTelefonoEmpresa(form.getTelefonoEmpresa());
        cliente.setCorreoEmpresa(form.getCorreoEmpresa());
        cliente.setDireccionEmpresa(form.getDireccionEmpresa());
        cliente.setComunaEmpresa(form.getComunaEmpresa());
        clienteRepository.save(cliente);
    }
}
