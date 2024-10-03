package cl.grupo02.sprintFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.grupo02.sprintFinal.model.entity.Usuario;



public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {

}
