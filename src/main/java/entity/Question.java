package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(nullable = false, length = 50)
    private Integer number;
    private String body;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String correctChoice;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "exam_id")
    private Exam exam;

    public Question(Integer number, String body, String choiceA, String choiceB, String choiceC,
                    String correctChoice)
    {
        this.number = number;
        this.body = body;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.correctChoice = correctChoice;
    }

}
