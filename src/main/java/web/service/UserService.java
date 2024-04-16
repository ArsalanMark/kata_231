package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void update(User user);
    void delete(User user);
    User getUser(int id);
    List<User> userList();
}
