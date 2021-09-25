package service;

import entity.Exam;
import entity.ExamAttempt;

import repository.ExamAttemptRepository;

import java.sql.Timestamp;
import java.util.Scanner;


public class ExamAttemptService {

    ExamAttemptRepository examAttemptRepository = new ExamAttemptRepository();

    public void makeExamAttempt(Exam exam, Scanner sc) {
        ExamAttemptAnswersService examAttemptAnswersService = new ExamAttemptAnswersService();
        //create ExamAttempt with answers
        long now = System.currentTimeMillis();
        Timestamp sqlTimestamp = new Timestamp(now);
        ExamAttempt examAttempt = new ExamAttempt (sqlTimestamp);
        examAttempt = examAttemptAnswersService.prepareAnswers(examAttempt, exam, sc);
        //examAttempt.setExamAttemptAnswers(examAttemptAnswersService.prepareAnswers(exam, sc));
        examAttemptRepository.createNewExamAttempt(examAttempt);
    }
}
