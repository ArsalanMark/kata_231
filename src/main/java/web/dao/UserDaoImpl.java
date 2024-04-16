package web.dao;

import org.hibernate.Session;
import web.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        System.out.println("UserDao" + user);
        if (user.getId() == 0) {
        entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    public void update(User user) {
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> userList() {
        List<User> users = entityManager.createQuery("select u from User u", User.class).getResultList();
        return users;
    }
}
