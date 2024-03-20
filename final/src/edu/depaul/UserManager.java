package edu.depaul;
import java.util.HashMap;
import java.util.Map;


public class UserManager implements IUserManager {
    private Map<String, UserAuthentication> users;
    private UserAuthentication currentUser;
    


    public UserManager() {
        this.users = new HashMap<>();
    }

    public void registerUser(String username, String password, boolean isAdmin) {
        users.put(username, new UserAuthentication(username, password, isAdmin));
    }

    public boolean loginUser(String username, String password) {
        UserAuthentication user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            return true;
        }
        return false;
    }

    public UserAuthentication getCurrentUser() {
        return currentUser;
    }

    public void logout() {
        currentUser = null;
    }
}
