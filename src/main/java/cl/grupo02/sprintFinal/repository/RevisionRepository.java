package cl.grupo02.sprintFinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.grupo02.sprintFinal.model.entity.Revision;

@Repository
public interface RevisionRepository extends JpaRepository<Revision, Integer> {
//    List<Revision> findAllWithVisitaAndCliente();

    // Métodos personalizados si son necesarios
}
