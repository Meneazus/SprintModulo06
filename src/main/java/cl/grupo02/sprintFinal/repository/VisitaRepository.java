package cl.grupo02.sprintFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import cl.grupo02.sprintFinal.model.entity.Visita;

import java.util.List;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, Integer> {

	
	  @Query("SELECT v FROM Visita v JOIN FETCH v.cliente LEFT JOIN FETCH v.revisiones"
	  ) List<Visita> findAllWithClienteAndRevisiones();
	 
}
