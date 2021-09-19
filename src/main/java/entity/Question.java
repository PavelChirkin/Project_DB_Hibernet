package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


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
    private String name;
    private Integer number;
    private String body;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private char correctChoice;
    private Integer examId;
    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "exam_id")
    // private Exam exam;

}
