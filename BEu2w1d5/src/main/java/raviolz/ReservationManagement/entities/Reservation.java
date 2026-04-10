package raviolz.ReservationManagement.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Entity
@Setter
@Getter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(name = "res_date", nullable = false)
    private LocalDate resDate;

    @ManyToOne
    @JoinColumn(name = "workspace_id", nullable = false)
    private Workspace workspace;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Reservation(LocalDate resDate, Workspace workspace, User user) {
        if (resDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Troppo tardi!");
        }
        this.resDate = resDate;
        this.workspace = workspace;
        this.user = user;
    }

    public void setResDate(LocalDate resDate) {
        if (resDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Non puoi cambiare data con giorno passato");
        }
    }


    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", resDate=" + resDate +
                ", workspace=" + workspace +
                ", user=" + user +
                '}';
    }

}