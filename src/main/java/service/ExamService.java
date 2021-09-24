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
        System.out.println("===Input new exam number===");
        int number = Integer.parseInt(sc.nextLine());
        System.out.println("===Input new exam name===");
        String name = sc.nextLine();
        Exam exam = new Exam (number, name);
        exam.setQuestions(questionService.prepareQuestions(sc));
        examRepository.createNewExam(exam);
    }

    public Exam getExam(Scanner sc) {
        examRepository.getExams().forEach(System.out::println);
        System.out.println("===Input exam number You want take===");
        int number = Integer.parseInt(sc.nextLine());
        return examRepository.getExam(number);
    }
}