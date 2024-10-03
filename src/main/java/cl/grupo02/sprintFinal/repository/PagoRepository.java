package cl.grupo02.sprintFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.grupo02.sprintFinal.model.entity.Pago;


@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
    // Métodos básicos para utilizar el CRUD de JPA.
}
