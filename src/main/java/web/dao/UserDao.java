package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void update(User user);
    void delete(int id);
    User getUser(int id);
    List<User> userList();
}
