package raviolz.ReservationManagement.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import raviolz.ReservationManagement.entities.Reservation;
import raviolz.ReservationManagement.entities.User;
import raviolz.ReservationManagement.entities.Workspace;
import raviolz.ReservationManagement.exceptions.AlreadyExistsException;
import raviolz.ReservationManagement.exceptions.NotFoundException;
import raviolz.ReservationManagement.exceptions.ValidationException;
import raviolz.ReservationManagement.repositories.ReservationRepository;

import java.time.LocalDate;
import java.util.List;

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

    public Reservation findResById(Long id) {
        if (id == null) {
            throw new ValidationException("Inserisci un id valido");
        }
        Reservation res = resRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Prenotazione con id " + id + " non trovata!"));
        log.info("Prenotazione {} trovata!", res.getId());
        return res;
    }

    public List<Reservation> findByDate(LocalDate date) {
        if (date == null) {
            throw new ValidationException("Devi inserire una data");
        }

        List<Reservation> reservations = resRepository.findByResDate(date);

        log.info("Trovate {} prenotazioni per la data {}", reservations.size(), date);

        return reservations;
    }

    public List<Reservation> findByUser(User user) {
        if (user == null) {
            throw new ValidationException("Devi inserire un utente");
        }

        List<Reservation> reservations = resRepository.findByUser(user);

        log.info("Trovate {} prenotazioni per l'utente {}", reservations.size(), user.getFullName());

        return reservations;
    }

    public List<Reservation> findByWorkspace(Workspace workspace) {
        if (workspace == null) {
            throw new ValidationException("Devi inserire una workspace");
        }

        List<Reservation> reservations = resRepository.findByWorkspace(workspace);

        log.info("Trovate {} prenotazioni per la workspace {}", reservations.size(), workspace.getCode());

        return reservations;
    }
}


