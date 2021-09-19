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
@Table(name = "exam_attempt_answers")
public class ExamAttemptAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(nullable = false, length = 50)
    private Data date;
    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "examAttempt_id")
    // private ExamAttempt examAttempt;
    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "question_id")
    // private Question question;

}