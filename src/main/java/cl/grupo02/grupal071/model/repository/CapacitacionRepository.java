package cl.grupo02.grupal071.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.grupo02.grupal071.model.entity.Capacitacion;






@Repository
public interface CapacitacionRepository extends JpaRepository<Capacitacion, Integer> {
    // Métodos básicos para utilizar el CRUD de JPA.
}