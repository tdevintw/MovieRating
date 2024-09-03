package Auth;

import Database.Database;
import Domain.User;

import java.util.List;
import java.util.Optional;

public class Login {

    public User isUserExist(String name) {
        List<User> users = Database.getDatabase().getUsers();
        Optional<User> searchedUser = users.stream().filter(user -> user.getName().equals(name)).findFirst();
        if (searchedUser.isPresent()) {
            return searchedUser.get();
        } else {
            System.out.println("Name Wasn't Found");
            return null;
        }
    }

    public boolean isPasswordExist(User user, String password) {
        return user.getPassword().equals(password);
    }
}
