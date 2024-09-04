package Repository;

import DAO.DAOInterfaces.UserDAOInterface;
import Domain.User;

import java.util.List;

public class UserRepository {
    private final UserDAOInterface userDOA;

    public UserRepository(UserDAOInterface userDAO){
        this.userDOA = userDAO;
    }

    public User getUser(int id){
        return userDOA.getUser(id);
    }

    public void update(User user){
        userDOA.update(user);
    }

    public void delete(User user){
        userDOA.update(user);
    }

    public List<User> getAllUsers(){
       return userDOA.getAllUsers();
    }
}
