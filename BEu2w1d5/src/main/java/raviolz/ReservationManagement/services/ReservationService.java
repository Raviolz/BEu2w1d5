package raviolz.ReservationManagement.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import raviolz.ReservationManagement.entities.Reservation;
import raviolz.ReservationManagement.exceptions.AlreadyExistsException;
import raviolz.ReservationManagement.exceptions.ValidationException;
import raviolz.ReservationManagement.repositories.ReservationRepository;

@Slf4j
@Service
public class ReservationService {

    private final ReservationRepository resRepository;

    public ReservationService(ReservationRepository resRepository) {
        this.resRepository = resRepository;
    }

    public void saveReservation(Reservation newReservation) {
        if (newReservation.getResDate() == null) {
            throw new ValidationException("La data della prenotazione è obbligatoria");
        }

        if (newReservation.getWorkspace() == null) {
            throw new ValidationException("Indica postazione scelta");
        }

        if (newReservation.getUser() == null) {
            throw new ValidationException("Prenotiamo per chi?");
        }

        if (resRepository.existsByWorkspaceAndResDate(
                newReservation.getWorkspace(),
                newReservation.getResDate())) {
            throw new AlreadyExistsException("Postazione gia occupata in questa data");
        }

        if (resRepository.existsByUserAndResDate(
                newReservation.getUser(),
                newReservation.getResDate())) {
            throw new AlreadyExistsException("L' utente e' gia occupato altrove in questa data");
        }

        resRepository.save(newReservation);
        log.info("Abbiamo prenotato la postazione con codice {} a {} a nome di {} per il giorno {}", newReservation.getWorkspace().getCode(), newReservation.getWorkspace().getBuilding().getCity(), newReservation.getUser().getFullName(), newReservation.getResDate());
    }
}
