package cl.grupo02.grupal071.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.grupo02.grupal071.model.entity.Usuario;



public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {

}
