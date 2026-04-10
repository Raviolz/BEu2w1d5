package raviolz.ReservationManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import raviolz.ReservationManagement.entities.Building;

public interface BuildingRepository extends JpaRepository<Building, Long> {
}
