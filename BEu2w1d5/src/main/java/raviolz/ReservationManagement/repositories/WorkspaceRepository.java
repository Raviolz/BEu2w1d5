package raviolz.ReservationManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import raviolz.ReservationManagement.entities.Workspace;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
}
