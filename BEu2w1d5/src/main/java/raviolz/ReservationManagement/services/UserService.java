package raviolz.ReservationManagement.services;

import org.springframework.stereotype.Service;
import raviolz.ReservationManagement.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository uRepository;

    public UserService(UserRepository userRepository) {
        this.uRepository = userRepository;
    }
}
