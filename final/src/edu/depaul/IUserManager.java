package edu.depaul;

public interface IUserManager {
    void registerUser(String username, String password, boolean isAdmin);
    boolean loginUser(String username, String password);
    UserAuthentication getCurrentUser();
    void logout();
}
