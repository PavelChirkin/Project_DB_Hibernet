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

    public Exam getExam(Scanner sc) {
        examRepository.getExams().forEach(System.out::println);
        System.out.println("===Input exam Id You want take===");
        Long Id = Long.parseLong(sc.nextLine());
        return examRepository.getExam(Id);
        //return Id;
    }
}