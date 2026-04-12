package raviolz.ReservationManagement.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import raviolz.ReservationManagement.entities.User;
import raviolz.ReservationManagement.exceptions.AlreadyExistsException;
import raviolz.ReservationManagement.exceptions.NotFoundException;
import raviolz.ReservationManagement.exceptions.ValidationException;
import raviolz.ReservationManagement.repositories.UserRepository;

@Slf4j

@Service
public class UserService {

    private final UserRepository uRepository;

    public UserService(UserRepository userRepository) {
        this.uRepository = userRepository;
    }


    public void saveUser(User newUser) {
        if (newUser.getUsername() == null || newUser.getUsername().isBlank()) {
            throw new ValidationException("Username obbligatorio");
        }

        if (newUser.getFullName() == null || newUser.getFullName().isBlank()) {
            throw new ValidationException("Nome obbligatorio");
        }

        if (newUser.getEmail() == null || !newUser.getEmail().contains("@")) { // ho il controllo di la non so se sembra un duplicato ma quello e'sull oggetto e questo
            throw new ValidationException("Email non valida"); // e'in entrata DB quindi boh
        }

        if (uRepository.existsByUsername(newUser.getUsername())) {
            throw new AlreadyExistsException("Username già in uso");
        }

        if (uRepository.existsByEmail(newUser.getEmail())) {
            throw new AlreadyExistsException("Email già in uso");
        }

        uRepository.save(newUser);
        log.info("Utente{}salvato con successo!", newUser.getUsername());
    }


    public User findUser(Long id) {
        if (id == null) {
            throw new ValidationException("Devi inserire un id valido");
        }
        User user = uRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Utente con id " + id + " non trovato"));
        log.info("Utente {} con id {} trovato", user.getFullName(), user.getId());
        return user;
    }

    public User updateUser(Long id, String username, String fullName, String email) {
        User user = uRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Utente con id " + id + " non trovato"));

        if (username == null || username.isBlank()) {
            throw new ValidationException("Username obbligatorio");
        }

        if (fullName == null || fullName.isBlank()) {
            throw new ValidationException("Nome obbligatorio");
        }

        if (email == null || !email.contains("@")) {
            throw new ValidationException("Email non valida");
        }

        // duplicati
        if (!user.getUsername().equals(username) && // se uguale a quello in uso
                uRepository.existsByUsername(username)) { // se esiste nel DB
            throw new AlreadyExistsException("Username già in uso");
        }

        if (!user.getEmail().equals(email) &&
                uRepository.existsByEmail(email)) {
            throw new AlreadyExistsException("Email già in uso");
        }

        user.setUsername(username);
        user.setFullName(fullName);
        user.setEmail(email);

        return uRepository.save(user);
    }

}



