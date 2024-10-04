package cl.grupo02.sprintFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.grupo02.sprintFinal.model.entity.Cliente;
import cl.grupo02.sprintFinal.model.entity.Usuario;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByUsuario(Usuario usuario);
    Cliente findByRutEmpresa(String rutEmpresa);

}


