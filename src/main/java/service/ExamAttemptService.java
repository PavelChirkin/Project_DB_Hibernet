package service;

import entity.Exam;
import entity.ExamAttempt;

import entity.User;
import repository.ExamAttemptRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class ExamAttemptService {

    ExamAttemptRepository examAttemptRepository = new ExamAttemptRepository();

    public void makeExamAttempt(User user, Exam exam, Scanner sc) {
        ExamAttemptAnswersService examAttemptAnswersService = new ExamAttemptAnswersService();
        //create ExamAttempt with answers
        long now = System.currentTimeMillis();
        Timestamp sqlTimestamp = new Timestamp(now);
        ExamAttempt examAttempt = new ExamAttempt (sqlTimestamp, exam, user);
        examAttempt = examAttemptAnswersService.prepareAnswers(examAttempt, exam, sc);
        //examAttempt.setExamAttemptAnswers(examAttemptAnswersService.prepareAnswers(exam, sc));
        examAttemptRepository.createNewExamAttempt(examAttempt);
    }
    public void checkExamResults(User user) {
        //List<Long> examAttemptId = examAttemptRepository.getUserExamAttempts(user.getId());
        Set<ExamAttempt> examAttempts = user.getExamAttempts();
        System.out.println("examAttempt size: " + examAttempts.size());
        for (ExamAttempt ex : examAttempts) {
            System.out.println("Exam: " + ex.getExam().getName() + " " +
                    " has taken at " + ex.getTimestamp() +
                    " with evaluation rate " + ex.getEvaluationRate());
        }

    }
}

