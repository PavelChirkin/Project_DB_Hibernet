package service;

import entity.Question;
import entity.User;
import repository.QuestionRepository;

import java.util.*;

public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService() {
        questionRepository = new QuestionRepository();
    }
    public Set<Question> prepareQuestions(Scanner sc) {
        Set<Question> questions = new HashSet<>();
            boolean prolong = false;
        do {
            System.out.println("==Please insert question number==");
            int number = Integer.parseInt(sc.nextLine());
            System.out.println("==Please insert question body==");
            String qBody = sc.nextLine();
            System.out.println("==Please insert answer variant A==");
            String choiceA = sc.nextLine();
            System.out.println("==Please insert answer variant B==");
            String choiceB = sc.nextLine();
            System.out.println("==Please insert answer variant C==");
            String choiceC = sc.nextLine();
            System.out.println("==Please insert correct variant choice==");
            String correctChoice = sc.nextLine();
            Question question = new Question(number, qBody, choiceA, choiceB, choiceC, correctChoice);
            questions.add(question);

            System.out.println(" ___________________________________");
            System.out.println("|   1 - add one more question       |");
            System.out.println("|   2 - Exit                        |");
            System.out.println("|___________________________________|");
            String select1 = sc.nextLine();
            switch (select1) {
                case "1" -> {
                    prolong = true;
                }
                case "2" -> {
                    prolong = false;
                }
                default -> System.out.println("Please select menu item");
            }
        }while(prolong);
        return questions;
    }
}
