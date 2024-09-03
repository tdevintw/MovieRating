package DAO.DAOInterfaces;

import Domain.User;

import java.util.List;

public interface UserDAOInterface {

    User getUser(int id);

    void update(User user);

    void delete(User user);

    List<User> getAllUsers();
}
