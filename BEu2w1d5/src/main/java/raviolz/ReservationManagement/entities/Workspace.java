package raviolz.ReservationManagement.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;


    //@NotBlank --> annotazione trovata per non fare tutti i controlli a mano nel costruttore prima avere il no del DB
    //@Size non so se si possono davvero usare... ho fatto nel costruttore solo i controlli non segnati in Column
    //@NotNull ... ecc
    @Column(nullable = false, unique = true, length = 15)
    private String code;

    @Column(length = 200)
    private String description;


    @Enumerated(EnumType.STRING)
    @Column(name = "workspace_type", nullable = false)
    private WorkspaceType workspaceType;

    @Column(nullable = false)
    private int maxCapacity;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Building building;


    public Workspace(String code, String description, WorkspaceType workspaceType, int maxCapacity, Building building) {
        this.code = code;
        this.description = description;
        this.workspaceType = workspaceType;
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Posto inutile");
        }
        this.maxCapacity = maxCapacity;
        this.building = building;
    }


    public void setMaxCapacity(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Inutile tenerlo disponibile se non utilizzabile");
        }
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return "Workspace{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", workspaceType=" + workspaceType +
                ", maxCapacity=" + maxCapacity +
                ", building=" + building +
                '}';
    }
}
