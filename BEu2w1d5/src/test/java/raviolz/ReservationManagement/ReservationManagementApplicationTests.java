package raviolz.ReservationManagement;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import raviolz.ReservationManagement.entities.Building;
import raviolz.ReservationManagement.entities.User;
import raviolz.ReservationManagement.entities.Workspace;
import raviolz.ReservationManagement.entities.WorkspaceType;
import raviolz.ReservationManagement.exceptions.ValidationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ReservationManagementApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void userShouldBeCreatedCorrectly() {
        User user = new User("OrnellaV", "Ornella Vanoni", "ornella@gmail.com");

        assertEquals("OrnellaV", user.getUsername());
        assertEquals("Ornella Vanoni", user.getFullName());
        assertEquals("ornella@gmail.com", user.getEmail());
    }

    @ParameterizedTest
    @ValueSource(strings = {"luigiemail.com", "luigi.com", "test", "@", " "})
        // solo chiocciola passa perche' ho un controllo nella classe
    void userWithInvalidEmailsShouldThrowException(String invalidEmail) { // pero' boh dovrei controllare troppe cose 🤔 .. cerchero' poi come fare
        assertThrows(ValidationException.class, () -> {
            new User("LuigiConEmail", "Luigi Test", invalidEmail);
        });
    }


    @Test
    void workspaceWithZeroCShouldThrowException() {
        Building b = new Building("Posto Test", "Via Appia 1", "Roma");

        assertThrows(ValidationException.class, () -> {
            new Workspace("WS-TEST-001", "Open space", WorkspaceType.OPENSPACE, 0, b);
        });
    }
}
