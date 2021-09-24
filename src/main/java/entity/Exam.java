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
@Table(name = "exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(nullable = false)
    private String name;
    @JoinColumn(name = "exam_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Question> questions;

    public Exam(String name) {
        this.name = name;
    }
}
