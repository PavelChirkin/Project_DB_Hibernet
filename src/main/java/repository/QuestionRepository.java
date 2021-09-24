package repository;

import entity.Exam;
import entity.Question;

import java.util.Scanner;

public class QuestionRepository extends AbstractRepository{

    public void createNewQuestion(Exam exam, Scanner sc) {
        System.out.println("===Input new exam question===");
        String body = sc.nextLine();
        System.out.println("===Input answer variant A===");
        String choiceA = sc.nextLine();
        System.out.println("===Input answer variant B===");
        String choiceB = sc.nextLine();
        System.out.println("===Input answer variant C===");
        String choiceC = sc.nextLine();
        System.out.println("===Input correct answer variant label===");
        String correctChoice =  sc.nextLine();
        //Question question = new Question(null, body, choiceA, choiceA, choiceA, correctChoice, exam);
        //changeEntity(session -> session.save(question));
    }
}
