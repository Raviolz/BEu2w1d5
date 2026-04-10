package raviolz.ReservationManagement.entities.runners;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import raviolz.ReservationManagement.entities.User;
import raviolz.ReservationManagement.exceptions.AlreadyExistsException;
import raviolz.ReservationManagement.exceptions.ValidationException;
import raviolz.ReservationManagement.services.UserService;

@Slf4j
@Component
public class RunnerTest implements CommandLineRunner {


    private final UserService uService;

    public RunnerTest(UserService uService) {
        this.uService = uService;
    }


    @Override
    public void run(String... args) throws Exception {

// TEST UTENTE
        //salva
//        try {
//            User u1 = new User("PieroBalos", "Pietro Baldelli", "pierobalos@gmail.com");
//            uService.saveUser(u1);
//
//            log.info("Utente" + u1.getUsername() + " salvato con successo!");
//
//        } catch (AlreadyExistsException | ValidationException e) {
//            log.error("Errore salvataggio utente: {}" , e.getMessage());
//        }

        //eccezioni --> duplicati, vuoti  e mail senza chioccola

        try {
            User u1 = new User("PieroBalos", "Pietro Balos", "pierobalosgmail.com");
            uService.saveUser(u1);

            log.info("Utente" + u1.getUsername() + " salvato con successo!");

        } catch (AlreadyExistsException | ValidationException e) {
            log.error("Errore salvataggio utente: {}", e.getMessage());
        }

    }
}
