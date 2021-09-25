package repository;

import entity.ExamAttempt;
import entity.User;
import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class ExamAttemptRepository extends AbstractRepository{


    public void createNewExamAttempt(ExamAttempt examAttempt) {
        changeEntity(session -> session.save(examAttempt));
    }

    public List<Long> getUserExamAttempts(Long UserId) {
        return getEntityInformation(session -> {
            Query query = session.createQuery("select id from ExamAttempt where user_id=:id", Long.class);
            query.setParameter("id", UserId);
            return query.list();
        });
    }
    public ExamAttempt getExamAttempt(Long id) {
        return getEntityInformation(session -> session.get(ExamAttempt.class, id));
    }
}
