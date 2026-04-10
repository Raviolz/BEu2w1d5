package raviolz.ReservationManagement.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Setter
@Getter
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, unique = true)
    private String address;

    @Column(nullable = false)
    private String city;

    public Building(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
