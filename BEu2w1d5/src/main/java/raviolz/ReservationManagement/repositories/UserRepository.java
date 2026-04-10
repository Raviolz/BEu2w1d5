package raviolz.ReservationManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import raviolz.ReservationManagement.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
