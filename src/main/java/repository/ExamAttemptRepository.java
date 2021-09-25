package repository;

import entity.ExamAttempt;

public class ExamAttemptRepository extends AbstractRepository{


    public void createNewExamAttempt(ExamAttempt examAttempt) {
        changeEntity(session -> session.save(examAttempt));
    }
}
