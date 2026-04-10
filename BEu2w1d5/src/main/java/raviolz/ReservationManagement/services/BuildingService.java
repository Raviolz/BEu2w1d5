package raviolz.ReservationManagement.services;


import org.springframework.stereotype.Service;
import raviolz.ReservationManagement.repositories.BuildingRepository;

@Service
public class BuildingService {

    private final BuildingRepository bRepository;

    public BuildingService(BuildingRepository bRepository) {
        this.bRepository = bRepository;
    }
}
