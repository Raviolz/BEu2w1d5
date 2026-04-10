package raviolz.ReservationManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import raviolz.ReservationManagement.entities.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

    boolean existsByAddress(String address);
}
