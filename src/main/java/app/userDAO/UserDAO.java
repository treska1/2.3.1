package app.userDAO;

import app.model.User;

import java.util.List;

public interface UserDAO {

    List getAllUsers();

    void saveUser(User user);

    User getUserById(long id);

    void removeUser(long id);

    void updateUser(User user);
}
