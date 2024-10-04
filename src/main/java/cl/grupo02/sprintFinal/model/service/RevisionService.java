package cl.grupo02.sprintFinal.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.grupo02.sprintFinal.model.entity.Revision;
import cl.grupo02.sprintFinal.repository.RevisionRepository;

import java.util.List;

@Service
public class RevisionService {

    @Autowired
    private RevisionRepository revisionRepository;

    // Obtener todas las revisiones con sus visitas y clientes
    public List<Revision> obtenerTodasRevisiones() {
        return revisionRepository.findAllWithVisitaAndCliente();
    }

    // Guardar una nueva revisión
    public Revision guardarRevision(Revision revision) {
        return revisionRepository.save(revision);
    }
    
}
