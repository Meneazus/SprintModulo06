package cl.grupo02.sprintFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.grupo02.sprintFinal.model.entity.Profesional;
import cl.grupo02.sprintFinal.model.entity.Usuario;


@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional, Integer> {
    Profesional findByUsuario(Usuario usuario);

}
