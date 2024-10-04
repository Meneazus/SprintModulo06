package cl.grupo02.sprintFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.grupo02.sprintFinal.model.entity.Administrativo;
import cl.grupo02.sprintFinal.model.entity.Usuario;


@Repository
public interface AdministrativoRepository extends JpaRepository<Administrativo, Integer> {
    Administrativo findByUsuario(Usuario usuario);


}
