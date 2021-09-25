package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(nullable = false, length = 50)
    private String name;
    private String surname;
    private char userType;
    private String userName;
    private String password;
    @JoinColumn(name = "user_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ExamAttempt> examAttempts;

    public User (String name,String surname, char userType, String userName, String password) {
        this.name = name;
        this.surname = surname;
        this.userType = userType;
        this.userName = userName;
        this.password = password;
    }
}
