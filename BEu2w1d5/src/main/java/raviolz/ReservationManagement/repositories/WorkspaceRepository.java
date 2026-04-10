package raviolz.ReservationManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import raviolz.ReservationManagement.entities.Workspace;


@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {

    boolean existsByCode(String code);
}
