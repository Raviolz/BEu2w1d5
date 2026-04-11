package raviolz.ReservationManagement.entities.runners;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import raviolz.ReservationManagement.entities.Building;
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
        //       try {
        //           Building b1 = new Building(" ", "Via Berti 1", "Firenze");
        //         bService.saveBuilding(b1);
        //    } catch (AlreadyExistsException | ValidationException e) {
        //      log.error("Errore nel salvataggio dell edificio: {}", e.getMessage());
        // }


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

//        bService.saveBuilding(b2);
//        bService.saveBuilding(b3);
//        bService.saveBuilding(b4);
//        bService.saveBuilding(b5);
//        bService.saveBuilding(b6);
//        bService.saveBuilding(b7);
//        bService.saveBuilding(b8);
//        bService.saveBuilding(b9);
//        bService.saveBuilding(b10);


        // find building

        Building b2DB = bService.findById(2L);
        Building b3DB = bService.findById(3L);
        Building b4DB = bService.findById(4L);
        Building b5DB = bService.findById(5L);
        Building b6DB = bService.findById(6L);
        Building b7DB = bService.findById(7L);
        Building b8DB = bService.findById(8L);
        Building b9DB = bService.findById(9L);
        Building b10DB = bService.findById(10L);

        log.info("Edificio recuperato: {}", b2DB.getName()); // potevo metterlo direttamente nel metodo ma non volevo appesantirlo


        // TEST WORKSPACE
        // save

//        try {
//            Workspace ws1 = new Workspace("WS-TO-001", "Postazione openspace con vista giardini", WorkspaceType.OPENSPACE, 28, b9DB);
//            wsService.saveWorkspace(ws1);
//        } catch (AlreadyExistsException | ValidationException e) {
//            log.error("Errore nel salvataggio della postazione : {}", e.getMessage());
//        }

        //eccezioni --> duplicati e vuoti, uguale a zero

//        try {
//            Workspace ws1 = new Workspace("WS-TO-001", "Postazione openspace con vista giardini", WorkspaceType.OPENSPACE, 28, b9DB);
//            wsService.saveWorkspace(ws1);
//        } catch (AlreadyExistsException | ValidationException e) {
//            log.error("Errore nel salvataggio della postazione : {}", e.getMessage());
//        }

//        // riempio con lista


//        List<Workspace> workspaces = List.of(
//                //   new Workspace("WS-FI-001", "Ufficio privato piano terra", WorkspaceType.PRIVATE, 2, b2DB),
////                new Workspace("WS-FI-002", "Open space con 20 postazioni", WorkspaceType.OPENSPACE, 20, b2DB),
////                new Workspace("WS-FI-003", "Sala riunioni con proiettore", WorkspaceType.MEETING_ROOM, 100, b2DB),
////                new Workspace("WS-FI-004", "Ufficio privato con balcone", WorkspaceType.PRIVATE, 3, b4DB),
////                new Workspace("WS-FI-005", "Open space luminoso", WorkspaceType.OPENSPACE, 80, b5DB),
////                new Workspace("WS-MI-001", "Sala riunioni executive", WorkspaceType.MEETING_ROOM, 45, b2DB),
////                new Workspace("WS-RM-001", "Open space moderno", WorkspaceType.OPENSPACE, 10, b3DB),
////                new Workspace("WS-BO-001", "Ufficio privato silenzioso", WorkspaceType.PRIVATE, 5, b6DB),
////                new Workspace("WS-TO-001", "Sala meeting con videoconferenza", WorkspaceType.MEETING_ROOM, 40, b7DB),
//                new Workspace("WS-NA-001", "Open space panoramico", WorkspaceType.OPENSPACE, 7, b8DB)
//        );
//
//        workspaces.forEach(wsService::saveWorkspace);
    }
}
