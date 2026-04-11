package raviolz.ReservationManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import raviolz.ReservationManagement.entities.Workspace;
import raviolz.ReservationManagement.entities.WorkspaceType;

import java.util.List;


@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {

    boolean existsByCode(String code);

    @Query("SELECT w FROM Workspace w WHERE w.workspaceType = :type AND w.building.city = :city")
    List<Workspace> findByTypeAndCity(WorkspaceType type, String city);
}
