package raviolz.ReservationManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import raviolz.ReservationManagement.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
