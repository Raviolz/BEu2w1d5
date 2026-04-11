package raviolz.ReservationManagement.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import raviolz.ReservationManagement.entities.Workspace;
import raviolz.ReservationManagement.entities.WorkspaceType;
import raviolz.ReservationManagement.exceptions.AlreadyExistsException;
import raviolz.ReservationManagement.exceptions.NotFoundException;
import raviolz.ReservationManagement.exceptions.ValidationException;
import raviolz.ReservationManagement.repositories.WorkspaceRepository;

import java.util.List;

@Service
@Slf4j
public class WorkspaceService {

    private final WorkspaceRepository wsRepository;


    public WorkspaceService(WorkspaceRepository wsRepository) {
        this.wsRepository = wsRepository;
    }

    public void saveWorkspace(Workspace newWorkspace) {
        if (newWorkspace.getCode() == null || newWorkspace.getCode().isBlank()) {
            throw new ValidationException("Codice obbligatorio");
        }

        if (newWorkspace.getWorkspaceType() == null) {
            throw new ValidationException("Tipo obbligatorio");
        }

        if (newWorkspace.getMaxCapacity() <= 0) {
            throw new ValidationException("Inutile salvarlo");
        }

        if (newWorkspace.getBuilding() == null) {
            throw new ValidationException("E' obbligatorio indicare l edificio a cui appartiene ");
        }

        if (wsRepository.existsByCode(newWorkspace.getCode())) {
            throw new AlreadyExistsException("Questa postazione " + newWorkspace.getCode() + " e' gia salvata nel DB");
        }

        wsRepository.save(newWorkspace);
        log.info("La workspace {} è stata salvata correttamente!", newWorkspace.getCode());
    }

    public Workspace findWorkspace(Long id) {
        if (id == null) {
            throw new ValidationException("Devi inserire un id corretto");
        }
        Workspace ws = wsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Postazione con id " + id + "non trovata"));
        log.info("Postazione nel palazzo {} con id {} trovato", ws.getBuilding().getName(), ws.getId());
        return ws;
    }

    public List<Workspace> findByTypeAndCity(WorkspaceType type, String city) {
        if (type == null) {
            throw new ValidationException("Il tipo di postazione e' obbligatorio");
        }
        if (city == null || city.isBlank()) {
            throw new ValidationException("Inserisci una citta' in cui abbiamo delle postazioni");
        }

        List<Workspace> result = wsRepository.findByTypeAndCity(type, city);
        log.info("Trovate {} postazionie di tipo {} nella città {}", result.size(), type, city);
        return result;
    }
}
