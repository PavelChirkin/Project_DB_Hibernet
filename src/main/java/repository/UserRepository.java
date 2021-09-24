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


public class UserRepository extends AbstractRepository{

    public void createNewUser(User user) {
        changeEntity(session -> session.save(user));
    }

    public List<User> getUsers() {
        return getEntityInformation(session -> session.createQuery("FROM User", User.class).list());
    }

    public User getUser(Long id) {
        return getEntityInformation(session -> session.get(User.class, id));
    }

    public List<String> getUserNames() {
        return getEntityInformation(session -> {
            Query query = session.createQuery("select userName from User", String.class);
            return query.list();
        });
    }

    public void updateUser(User user) {
        changeEntity(session -> session.update(user));
    }

    public void updateUserNameById(Long id, String name) {
        changeEntity(session -> {
            Query query = session.createQuery("update User set name=:name where id=:id");
            query.setParameter("name", name);
            query.setParameter("id", id);

            query.executeUpdate();
        });
    }

    public void delete(User user) {
        changeEntity(session -> session.delete(user));
    }

    public void deleteById(Long id) {
        User user = new User();
        user.setId(id);
        changeEntity(session -> session.delete(user));
    }

    public void deleteByName(String name) {
        changeEntity(session -> {
            Query query = session.createQuery("delete User where name=:name");
            query.setParameter("name", name);
            query.executeUpdate();
        });
    }


}
