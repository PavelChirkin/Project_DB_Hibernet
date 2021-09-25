package repository;

import entity.Exam;

import entity.User;
import provider.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class ExamRepository extends AbstractRepository{

    public List<Exam> getExams() {
        return getEntityInformation(session -> session.createQuery("FROM Exam", Exam.class).list());
    }

    public void createNewExam(Exam exam) {
        changeEntity(session -> session.save(exam));
    }

    public void delete(Exam exam) {
        changeEntity(session -> session.delete(exam));
    }

    public Exam getExam(Long id) {
        return getEntityInformation(session -> session.get(Exam.class, id));
    }
}
