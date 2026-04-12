package raviolz.ReservationManagement.entities.runners;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import raviolz.ReservationManagement.entities.Building;
import raviolz.ReservationManagement.entities.User;
import raviolz.ReservationManagement.entities.Workspace;
import raviolz.ReservationManagement.exceptions.AlreadyExistsException;
import raviolz.ReservationManagement.exceptions.NotFoundException;
import raviolz.ReservationManagement.exceptions.ValidationException;
import raviolz.ReservationManagement.services.BuildingService;
import raviolz.ReservationManagement.services.ReservationService;
import raviolz.ReservationManagement.services.UserService;
import raviolz.ReservationManagement.services.WorkspaceService;

@Slf4j
@Component
public class RunnerTest implements CommandLineRunner {


    private final UserService uService;
    private final WorkspaceService wsService;
    private final BuildingService bService;
    private final ReservationService rService;

    public RunnerTest(UserService uService, WorkspaceService wsService, BuildingService bService, ReservationService rService) {
        this.uService = uService;
        this.wsService = wsService;
        this.bService = bService;
        this.rService = rService;
    }


    @Override
    public void run(String... args) throws Exception {

// TEST UTENTE
        //salva
//        try {
//            User u1 = new User("PieroBalos", "Pietro Baldelli", "pierobalos@gmail.com");
//            uService.saveUser(u1);
//
//            log.info("Utente" + u1.getUsername() + " salvato con successo!"); //  gia nel service.. doppio log 1 salvataggio giusto
//
//        } catch (AlreadyExistsException | ValidationException e) {
//            log.error("Errore salvataggio utente: {}", e.getMessage());
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
//        uService.saveUser(new User("LucaRossi", "Luca Rossi", "luca.rossi@gmail.com"));
//        uService.saveUser(new User("GiuliaVerdi", "Giulia Verdi", "giulia.verdi@gmail.com"));
//        uService.saveUser(new User("MarcoBianchi", "Marco Bianchi", "marco.bianchi@gmail.com"));
//        uService.saveUser(new User("AnnaNeri", "Anna Neri", "anna.neri@gmail.com"));
//        uService.saveUser(new User("FrancescoGallo", "Francesco Gallo", "francesco.gallo@gmail.com"));
//        uService.saveUser(new User("SaraRomano", "Sara Romano", "sara.romano@gmail.com"));
//        uService.saveUser(new User("MatteoGreco", "Matteo Greco", "matteo.greco@gmail.com"));
//        uService.saveUser(new User("ElenaFerrari", "Elena Ferrari", "elena.ferrari@gmail.com"));
//        uService.saveUser(new User("DavideConti", "Davide Conti", "davide.conti@gmail.com"));

        // find user

        User u1DB = uService.findUser(1L);
        User u2DB = uService.findUser(2L);
        User u3DB = uService.findUser(3L);
        User u4DB = uService.findUser(4L);
        User u5DB = uService.findUser(5L);
        User u6DB = uService.findUser(6L);
        User u7DB = uService.findUser(7L);
        //  User u8DB = uService.findUser(8L);
        User u9DB = uService.findUser(9L);
        User u10DB = uService.findUser(10L);

        // test exception

//        try {
//            User u101DB = uService.findUser(101L);
//        } catch (NotFoundException ex) {
//            log.error(ex.getMessage());
//        }


        // update user ed eccezioni

//        try {
//            User updatedUser = uService.updateUser(
//                    2L,
//                    "Luchino",
//                    "Luca Updated",
//                    "luchino.updated@gmail.com"
//            );
//
//            log.info("Utente aggiornato con successo: id={}, username={}, fullName={}, email={}",
//                    updatedUser.getId(),
//                    updatedUser.getUsername(),
//                    updatedUser.getFullName(),
//                    updatedUser.getEmail());
//
//        } catch (ValidationException | NotFoundException | AlreadyExistsException ex) {
//            log.error("Errore durante l aggiornamento utente: {}", ex.getMessage());
//        }

        // test secondo update

        try {
            User updatedUser = uService.updateUserQ(
                    2L,
                    "PieroBalos",
                    "Luca Updated2",
                    "luchino.updated2@gmail.com"
            );

            log.info("Utente aggiornato con successo: id={}, username={}, fullName={}, email={}",
                    updatedUser.getId(),
                    updatedUser.getUsername(),
                    updatedUser.getFullName(),
                    updatedUser.getEmail());

        } catch (ValidationException | NotFoundException | AlreadyExistsException ex) {
            log.error("Errore durante l aggiornamento utente: {}", ex.getMessage());
        }


        // delete con eccezioni

//        try {
//            uService.deleteUser(u8DB.getId());
//        } catch (ValidationException | NotFoundException ex) {
//            log.error("Errore: {}", ex.getMessage());
//        }
        // TEST BUILDING

        //salva

//        try {
//            Building b1 = new Building("Fortezza del Basso", "Via Berti 1", "Firenze");
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
        Building b11 = new Building("Palazzo Strozzi", "Piazza degli Strozzi 1", "Firenze");
        Building b12 = new Building("Maggio Musicale", "Parta al Prato 20", "Firenze");
//
//        bService.saveBuilding(b2);
//        bService.saveBuilding(b3);
//        bService.saveBuilding(b4);
//        bService.saveBuilding(b5);
//        bService.saveBuilding(b6);
//        bService.saveBuilding(b7);
//        bService.saveBuilding(b8);
//        bService.saveBuilding(b9);
//        bService.saveBuilding(b10);
//        bService.saveBuilding(b11);
//        bService.saveBuilding(b12);


        // find building
        Building b1DB = bService.findBuilding(1L);
        Building b2DB = bService.findBuilding(2L);
        Building b3DB = bService.findBuilding(3L);
        Building b4DB = bService.findBuilding(4L);
        Building b5DB = bService.findBuilding(5L);
        Building b6DB = bService.findBuilding(6L);
        Building b7DB = bService.findBuilding(7L);
        Building b8DB = bService.findBuilding(8L);
        Building b9DB = bService.findBuilding(9L);
        Building b10DB = bService.findBuilding(10L);
        Building b11DB = bService.findBuilding(11L);
        Building b12DB = bService.findBuilding(12L);

        //   log.info("Edificio recuperato: {}", b2DB.getName()); // potevo metterlo direttamente nel metodo.. l ho negli altri

        // test exception

//        try {
//            Building b101DB = bService.findBuilding(101L);
//        } catch (NotFoundException ex) {
//            log.error(ex.getMessage());
//        }

        // TEST WORKSPACE
        // save

//        try {
//            Workspace ws1 = new Workspace("WS-TO-001", "Postazione openspace con vista giardini", WorkspaceType.OPENSPACE, 28, b5DB);
//            wsService.saveWorkspace(ws1);
//        } catch (AlreadyExistsException | ValidationException e) {
//            log.error("Errore nel salvataggio della postazione : {}", e.getMessage());
//        }

        //eccezioni --> duplicati e vuoti, uguale a zero

//        try {
//            Workspace ws1 = new Workspace("WS-TO-001", "Postazione openspace con vista giardini", WorkspaceType.OPENSPACE, 28, b5DB);
//            wsService.saveWorkspace(ws1);
//        } catch (AlreadyExistsException | ValidationException e) {
//            log.error("Errore nel salvataggio della postazione : {}", e.getMessage());
//        }

//        // riempio con lista


//        List<Workspace> workspaces = List.of(
//                new Workspace("WS-FI-001", "Ufficio privato piano terra", WorkspaceType.OPENSPACE, 2, b1DB),
//                new Workspace("WS-FI-002", "Open space con 20 postazioni", WorkspaceType.OPENSPACE, 20, b12DB),
//                new Workspace("WS-FI-003", "Sala riunioni con proiettore", WorkspaceType.MEETING_ROOM, 100, b11DB),
//                new Workspace("WS-FI-004", "Ufficio privato con balcone", WorkspaceType.PRIVATE, 3, b11DB),
//                new Workspace("WS-FI-005", "Open space luminoso", WorkspaceType.OPENSPACE, 80, b1DB),
//                new Workspace("WS-MI-001", "Sala riunioni executive", WorkspaceType.MEETING_ROOM, 45, b2DB),
//                new Workspace("WS-RM-001", "Open space moderno", WorkspaceType.OPENSPACE, 10, b3DB),
//                new Workspace("WS-BO-001", "Ufficio privato silenzioso", WorkspaceType.PRIVATE, 5, b4DB),
//                new Workspace("WS-TO-002", "Sala meeting con videoconferenza", WorkspaceType.MEETING_ROOM, 40, b5DB),
//                new Workspace("WS-NA-001", "Open space panoramico", WorkspaceType.OPENSPACE, 7, b6DB)
        //    );
//
//        workspaces.forEach(wsService::saveWorkspace);
//
        Workspace ws1DB = wsService.findWorkspace(1L);
        Workspace ws2DB = wsService.findWorkspace(2L);
        Workspace ws3DB = wsService.findWorkspace(3L);
        Workspace ws4DB = wsService.findWorkspace(4L);
        Workspace ws5DB = wsService.findWorkspace(5L);
        Workspace ws6DB = wsService.findWorkspace(6L);
        Workspace ws7DB = wsService.findWorkspace(7L);
        Workspace ws8DB = wsService.findWorkspace(8L);
        Workspace ws9DB = wsService.findWorkspace(9L);
        Workspace ws10DB = wsService.findWorkspace(10L);


        // RESERVATION TEST

        // save
//        try {
//            Reservation r1 = new Reservation(
//                    LocalDate.now().plusDays(4),
//                    ws8DB,
//                    u1DB
//            );
//            rService.saveReservation(r1);
//
//        } catch (ValidationException | AlreadyExistsException | NotFoundException ex) {
//            log.error("Errore durante la creazione della prenotazione: {}", ex.getMessage());
//        }


        // eccezioni save test per tutto

//        try {
//            Reservation r1001 = new Reservation(
//                    LocalDate.now().minusDays(4),
//                    ws8DB,
//                    u2DB
//            );
//            rService.saveReservation(r1001);
//
//        } catch (ValidationException | AlreadyExistsException | NotFoundException ex) {
//            log.error("Errore durante la creazione della prenotazione: {}", ex.getMessage());
//        }

// riempio
//        rService.saveReservation(new Reservation(LocalDate.now().plusDays(3), ws8DB, u3DB));
//        rService.saveReservation(new Reservation(LocalDate.of(2026, 5, 4), ws8DB, u3DB));
//        rService.saveReservation(new Reservation(LocalDate.of(2026, 4, 19), ws1DB, u4DB));
//        rService.saveReservation(new Reservation(LocalDate.of(2026, 5, 1), ws2DB, u5DB));
//        rService.saveReservation(new Reservation(LocalDate.of(2026, 5, 1), ws8DB, u3DB));
//        rService.saveReservation(new Reservation(LocalDate.of(2026, 7, 3), ws6DB, u3DB));
//        rService.saveReservation(new Reservation(LocalDate.of(2026, 11, 22), ws6DB, u9DB));
//        rService.saveReservation(new Reservation(LocalDate.of(2026, 9, 28), ws5DB, u9DB));
//        rService.saveReservation(new Reservation(LocalDate.of(2026, 6, 14), ws4DB, u10DB));


        // find reservation  piu eccezioni (non riscrivo cambio e basta per non arrivare a millemila righe)
//        try {
//            Reservation r1DB = rService.findResById(1L);
//        } catch (ValidationException | NotFoundException ex) {
//            log.error("Errore: {}", ex.getMessage());
//        }


        // find per data

//        try {
//            List<Reservation> rx1del5 = rService.findByDate(LocalDate.of(2026, 5, 1));
//            rx1del5.forEach(res -> log.info("Prenotazione con id : {}, a nome: {}, postazione: {}, in data: {}",
//                    res.getId(),
//                    res.getUser().getFullName(),
//                    res.getWorkspace().getCode(),
//                    res.getResDate()));                        //forse un po eccessivo per troppe prenotazioni
//        } catch (ValidationException | NotFoundException ex) {
//            log.error("Errore: {}", ex.getMessage());
//        }
        // find per posto

//        try {
//            List<Reservation> rxFIOpenspace = rService.findByWorkspace(ws6DB);
//            rxFIOpenspace.forEach(res -> log.info("Prenotazione con id : {}, a nome: {}, in data: {}",
//                    res.getId(),
//                    res.getUser().getFullName(),
//                    res.getResDate()));
//        } catch (ValidationException | NotFoundException ex) {
//            log.error("Errore: {}", ex.getMessage());
//        }


        // find per persona

//        List<Reservation> rxGiulia = rService.findByUser(u3DB);
//        try {
//            rxGiulia.forEach(res -> log.info("Prenotazione con id : {}, postazione: {}, in data: {}",
//                    res.getId(),
//                    res.getWorkspace().getCode(),
//                    res.getResDate()));
//        } catch (ValidationException | NotFoundException ex) {
//            log.error("Errore: {}", ex.getMessage());
//        }

        // CERCA POSTAZIONI PER CITTA' E TIPO POSTAZIONE


//        try {
//            List<Workspace> wsFiPrivate = wsService.findByTypeAndCity(WorkspaceType.OPENSPACE, "Firenze");
//
//            wsFiPrivate.forEach(ws -> log.info(
//                    "Workspace -> id: {}, code: {}, edificio: {}, città: {}",
//                    ws.getId(),
//                    ws.getCode(),
//                    ws.getBuilding().getName(),
//                    ws.getBuilding().getCity()
//            ));
//        } catch (ValidationException ex) {
//            log.error("Errore: {}", ex.getMessage());
//        }

    }


}
