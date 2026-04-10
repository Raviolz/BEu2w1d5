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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(name = "user_name", nullable = false, unique = true, length = 15)
    private String username;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;


    public User(String username, String fullName, String email) {
        this.username = username;
        this.fullName = fullName;
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Devi inserire un email");
        }
        this.email = email;
    }


    public void setEmail(String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email non valida");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
