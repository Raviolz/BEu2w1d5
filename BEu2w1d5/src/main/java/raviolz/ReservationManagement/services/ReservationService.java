package raviolz.ReservationManagement.services;

import org.springframework.stereotype.Service;
import raviolz.ReservationManagement.repositories.ReservationRepository;

@Service
public class ReservationService {

    private final ReservationRepository resRepository;

    public ReservationService(ReservationRepository resRepository) {
        this.resRepository = resRepository;
    }
}
