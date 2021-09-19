package repository;

import entity.User;
import provider.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;


public class UserRepository {

    public void createNewUser(User user) {
        changeUser(session -> session.save(user));
    }

    public List<User> getUsers() {
        return getUserInformation(session -> session.createQuery("FROM User", User.class).list());
    }

    public User getUser(Long id) {
        return getUserInformation(session -> session.get(User.class, id));
    }

    public List<String> getUserNames() {
        return getUserInformation(session -> {
            Query query = session.createQuery("select name from User", String.class);
            return query.list();
        });
    }

    public void updateUser(User user) {
        changeUser(session -> session.update(user));
    }

    public void updateUserNameById(Long id, String name) {
        changeUser(session -> {
            Query query = session.createQuery("update User set name=:name where id=:id");
            query.setParameter("name", name);
            query.setParameter("id", id);

            query.executeUpdate();
        });
    }

    public void delete(User user) {
        changeUser(session -> session.delete(user));
    }

    public void deleteById(Long id) {
        User user = new User();
        user.setId(id);
        changeUser(session -> session.delete(user));
    }

    public void deleteByName(String name) {
        changeUser(session -> {
            Query query = session.createQuery("delete User where name=:name");
            query.setParameter("name", name);
            query.executeUpdate();
        });
    }

    private void changeUser(Consumer<Session> consumer) {
        Session session = null;
        Transaction transaction = null;
        try
        {
            session = SessionFactoryProvider.getInstance().getSessionFactory().openSession();
            transaction = session.beginTransaction();

            consumer.accept(session);

            transaction.commit();
        } catch(Exception e) {
            System.out.println(e);
            if(transaction != null){
                transaction.rollback();
            }
        }finally
        {
            if(session != null) {
                session.close();
            }
        }
    }

    private <T> T getUserInformation(Function<Session, T> function){
        try(Session session = SessionFactoryProvider.getInstance().getSessionFactory().openSession()) {
            return function.apply(session);
        }catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
