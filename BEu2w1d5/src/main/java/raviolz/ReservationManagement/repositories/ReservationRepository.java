package raviolz.ReservationManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import raviolz.ReservationManagement.entities.Reservation;
import raviolz.ReservationManagement.entities.User;
import raviolz.ReservationManagement.entities.Workspace;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    boolean existsByWorkspaceAndResDate(Workspace workspace, LocalDate reservationDate);

    boolean existsByUserAndResDate(User user, LocalDate reservationDate);

    List<Reservation> findByResDate(LocalDate resDate);

    List<Reservation> findByUser(User user);

    List<Reservation> findByWorkspace(Workspace workspace);
}
