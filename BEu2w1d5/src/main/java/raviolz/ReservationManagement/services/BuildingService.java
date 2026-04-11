package raviolz.ReservationManagement.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import raviolz.ReservationManagement.entities.Building;
import raviolz.ReservationManagement.exceptions.AlreadyExistsException;
import raviolz.ReservationManagement.exceptions.NotFoundException;
import raviolz.ReservationManagement.exceptions.ValidationException;
import raviolz.ReservationManagement.repositories.BuildingRepository;

@Slf4j
@Service
public class BuildingService {

    private final BuildingRepository bRepository;

    public BuildingService(BuildingRepository bRepository) {
        this.bRepository = bRepository;
    }

    public void saveBuilding(Building newBuilding) {
        if (newBuilding.getName() == null || newBuilding.getName().isBlank()) {
            throw new ValidationException("Devi inserire il nome dell edificio");
        }

        if (newBuilding.getAddress() == null || newBuilding.getAddress().isBlank()) {
            throw new ValidationException("L'indirizzo è obbligatorio");
        }

        if (newBuilding.getCity() == null || newBuilding.getCity().isBlank()) {
            throw new ValidationException("Inserisci il nome della citta'");
        }

        if (bRepository.existsByAddress(newBuilding.getAddress())) {
            throw new AlreadyExistsException("Edificio gia' salvato già presente nel DB");
        }

        bRepository.save(newBuilding);
        log.info("L'edificio {} è stato salvato correttamente!", newBuilding.getName());
    }


    public Building findBuilding(Long id) {
        if (id == null) {
            throw new ValidationException("Inserisci un id valido");
        }
        return bRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Edificio con id" + id + " non trovato"));
    }
}



