package cl.grupo02.sprintFinal.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.grupo02.sprintFinal.model.entity.Revision;
import cl.grupo02.sprintFinal.repository.RevisionRepository;

@Service
public class RevisionService {

    @Autowired
    private RevisionRepository revisionRepository;

    public Revision guardarRevision(Revision revision) {
        return revisionRepository.save(revision);
    }

    // Obtener una revisión por su ID
    public Optional<Revision> obtenerRevisionPorId(int id) {
        return revisionRepository.findById(id);
    }

    // Eliminar una revisión por su ID
    public void eliminarRevision(int id) {
        revisionRepository.deleteById(id);
    }
    
//    // Obtener todas las revisiones con sus visitas y clientes
//    public List<Revision> obtenerTodasRevisiones() {
////        return revisionRepository.findAllWithVisitaAndCliente();
//    }
    
}
