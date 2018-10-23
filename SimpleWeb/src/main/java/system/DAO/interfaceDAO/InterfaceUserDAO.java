package system.DAO.interfaceDAO;

import system.model.User;

public interface InterfaceUserDAO {

    void insertUser(User user);
    void deleteUser(User user);
    void deleteUserById(int id);
    User getUserById(int id);
    User getUserByLogin(String login);
    User getUserByEmail(String email);

    void updateUser(User user);
}
