package cl.grupo02.sprintFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.grupo02.sprintFinal.model.entity.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	List<Usuario> findByTipoUsuario(String tipoUsuario);
    // Métodos personalizados si es necesario
	
	public interface ValidacionCrear {}
	public interface ValidacionActualizar {}

}

