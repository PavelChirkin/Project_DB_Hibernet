package service;

import entity.Exam;
import entity.ExamAttempt;
import entity.ExamAttemptAnswer;
import entity.Question;
import repository.ExamAttemptAnswerRepository;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ExamAttemptAnswersService {

        ExamAttemptAnswerRepository examAttemptAnswerRepository = new ExamAttemptAnswerRepository();

    public ExamAttempt prepareAnswers(ExamAttempt examAttempt, Exam exam, Scanner sc) {
        Set<ExamAttemptAnswer> answersToQuestions = new HashSet<>();
        Set<Question> questions = exam.getQuestions();
        int counter = 0;
        for (Question q : questions) {
            System.out.println("====Question====");
            System.out.print(q.getBody());
            System.out.println("====Possible answers to question====");
            System.out.println("A: " + q.getChoiceA());
            System.out.println("B: " + q.getChoiceB());
            System.out.println("C: " + q.getChoiceC());
            System.out.println("====Input correct choice====");
            String selectedAnswer = sc.nextLine();
            if(selectedAnswer.equals(q.getCorrectChoice())) {
                counter++;
            }
            ExamAttemptAnswer examAttemptAnswer = new ExamAttemptAnswer(selectedAnswer, examAttempt, q);
            answersToQuestions.add(examAttemptAnswer);
        }
        //calculate evaluation rate
        double evaluationRate = (counter * 10) / questions.size();
        examAttempt.setExamAttemptAnswers(answersToQuestions);
        examAttempt.setEvaluationRate(evaluationRate);

        return examAttempt;
    }
}
