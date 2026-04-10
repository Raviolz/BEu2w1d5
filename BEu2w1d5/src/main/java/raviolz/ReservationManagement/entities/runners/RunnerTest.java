package raviolz.ReservationManagement.entities.runners;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import raviolz.ReservationManagement.entities.Building;
import raviolz.ReservationManagement.exceptions.AlreadyExistsException;
import raviolz.ReservationManagement.exceptions.ValidationException;
import raviolz.ReservationManagement.services.BuildingService;
import raviolz.ReservationManagement.services.UserService;
import raviolz.ReservationManagement.services.WorkspaceService;

@Slf4j
@Component
public class RunnerTest implements CommandLineRunner {


    private final UserService uService;
    private final WorkspaceService wsService;
    private final BuildingService bService;

    public RunnerTest(UserService uService, WorkspaceService wsService, BuildingService bService) {
        this.uService = uService;
        this.wsService = wsService;
        this.bService = bService;

    }


    @Override
    public void run(String... args) throws Exception {

// TEST UTENTE
        //salva
//        try {
//            User u1 = new User("PieroBalos", "Pietro Baldelli", "pierobalos@gmail.com");
//            uService.saveUser(u1);
//
//            log.info("Utente" + u1.getUsername() + " salvato con successo!"); // gia nel service.. doppio log 1 salvataggio giusto
//
//        } catch (AlreadyExistsException | ValidationException e) {
//            log.error("Errore salvataggio utente: {}" , e.getMessage());
//        }

        //eccezioni --> duplicati, vuoti e mail senza chioccola

//        try {
//            User u1 = new User("PieroBalos", "Pietro Balos", "pierobalosgmail.com");
//            uService.saveUser(u1);
//
//
//        } catch (AlreadyExistsException | ValidationException e) {
//            log.error("Errore salvataggio utente: {}", e.getMessage());
//        }


        // TEST BUILDING

        //salva

//        try {
//            Building b1 = new Building("Palazzo Strozzi", "Via Berti 1", "Firenze");
//            bService.saveBuilding(b1);
//        } catch (AlreadyExistsException | ValidationException e) {
//            log.error("Errore nel salvataggio dell edificio: {}", e.getMessage());
//        }

        //eccezioni --> duplicati e vuoti
        try {
            Building b1 = new Building(" ", "Via Berti 1", "Firenze");
            bService.saveBuilding(b1);
        } catch (AlreadyExistsException | ValidationException e) {
            log.error("Errore nel salvataggio dell edificio: {}", e.getMessage());
        }


        // riempio
        Building b2 = new Building("Tech Hub Milano", "Via Torino 45", "Milano");
        Building b3 = new Building("Innovation Center Roma", "Via Appia Nuova 120", "Roma");
        Building b4 = new Building("Coworking Bologna", "Via Indipendenza 33", "Bologna");
        Building b5 = new Building("Business Point Torino", "Corso Francia 88", "Torino");
        Building b6 = new Building("Workspace Napoli", "Via Toledo 210", "Napoli");
        Building b7 = new Building("Centro Direzionale Genova", "Via XX Settembre 15", "Genova");
        Building b8 = new Building("Polo Tecnologico Pisa", "Via Matteotti 9", "Pisa");
        Building b9 = new Building("Hub Verona", "Via Mazzini 27", "Verona");
        Building b10 = new Building("Business Center Bari", "Via Sparano 52", "Bari");

        bService.saveBuilding(b2);
        bService.saveBuilding(b3);
        bService.saveBuilding(b4);
        bService.saveBuilding(b5);
        bService.saveBuilding(b6);
        bService.saveBuilding(b7);
        bService.saveBuilding(b8);
        bService.saveBuilding(b9);
        bService.saveBuilding(b10);

// TODO: FARE IL FIND PRIMA DI ASSOCIARE IL BUILDING
        // TEST WORKSPACE
        // save

//        try {
//            Workspace ws1 = new Workspace("WS-TO-001", "Postazione openspace con vista giardini", WorkspaceType.OPENSPACE, 28, b1 );
//            wsService.saveWorkspace(ws1);
//        } catch (AlreadyExistsException | ValidationException e) {
//            log.error("Errore nel salvataggio della postazioone : {}", e.getMessage());
//        }

        //eccezioni --> duplicati e vuoti, uguale a zero

//        try {
//            Workspace ws1 = new Workspace("WS-TO-001", "Postazione openspace con vista giardini", WorkspaceType.OPENSPACE, 28, );
//            wsService.saveWorkspace(ws1);
//        } catch (AlreadyExistsException | ValidationException e) {
//            log.error("Errore nel salvataggio della postazioone : {}", e.getMessage());
//        }

//        // riempio
//        Workspace w1 = new Workspace("WS-FI-001", "Ufficio privato piano terra", WorkspaceType.PRIVATE, 2, b2);
//        Workspace w2 = new Workspace("WS-FI-002", "Open space con 20 postazioni", WorkspaceType.OPENSPACE, 20, b2);
//        Workspace w3 = new Workspace("WS-FI-003", "Sala riunioni con proiettore", WorkspaceType.MEETING_ROOM, 100, b2);
//        Workspace w4 = new Workspace("WS-FI-004", "Ufficio privato con balcone", WorkspaceType.PRIVATE, 3, b4);
//        Workspace w5 = new Workspace("WS-FI-005", "Open space luminoso", WorkspaceType.OPENSPACE, 80, b5);
//
//        Workspace w6 = new Workspace("WS-MI-001", "Sala riunioni executive", WorkspaceType.MEETING_ROOM, 45, b2);
//        Workspace w7 = new Workspace("WS-RM-001", "Open space moderno", WorkspaceType.OPENSPACE, 10, b3);
//        Workspace w8 = new Workspace("WS-BO-001", "Ufficio privato silenzioso", WorkspaceType.PRIVATE, 5, b6);
//        Workspace w9 = new Workspace("WS-TO-001", "Sala meeting con videoconferenza", WorkspaceType.MEETING_ROOM, 40, b7);
//        Workspace w10 = new Workspace("WS-NA-001", "Open space panoramico", WorkspaceType.OPENSPACE,  7, b8);
//
    }
}
