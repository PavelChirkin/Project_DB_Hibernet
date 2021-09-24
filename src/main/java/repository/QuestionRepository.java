package repository;

import entity.Exam;
import entity.Question;

import java.util.Scanner;

public class QuestionRepository extends AbstractRepository{

    public void createNewQuestion(Exam exam, Scanner sc) {

    }
    public void updateQuestion(Question question) {
        changeEntity(session -> session.update(question));
    }

    public void deleteQuestion(Question question) {
        changeEntity(session -> session.delete(question));
    }
}
