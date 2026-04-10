package raviolz.ReservationManagement.services;

import org.springframework.stereotype.Service;
import raviolz.ReservationManagement.repositories.WorkspaceRepository;

@Service
public class WorkspaceService {

    private final WorkspaceRepository wsRepository;


    public WorkspaceService(WorkspaceRepository wsRepository) {
        this.wsRepository = wsRepository;
    }
}
