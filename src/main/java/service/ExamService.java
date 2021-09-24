package service;

import entity.Exam;
import repository.ExamRepository;

import java.util.Scanner;

public class ExamService {

    private final ExamRepository examRepository;
    public ExamService() {
        examRepository = new ExamRepository();
    }
    QuestionService questionService = new QuestionService();

    public void createNewExam(Scanner sc) {
        System.out.println("===Input new exam name===");
        String name = sc.nextLine();
        Exam exam = new Exam (name);
        exam.setQuestions(questionService.prepareQuestions(sc));
        examRepository.createNewExam(exam);
    }
}