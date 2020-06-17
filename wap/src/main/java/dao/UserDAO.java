package dao;

import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO {

    private static UserDAO single_instance = null;

    private UserDAO() {
    }

    public static UserDAO UserDAO() {
        if (single_instance == null)
            single_instance = new UserDAO();
        return single_instance;
    }

    Map<Integer, User> userDb = new HashMap<>();

    {
        userDb.put(1, new User(1, "student1", "123",false));
        userDb.put(2, new User(2, "student2", "123",false));
        userDb.put(3, new User(3, "student3", "123",false));
        userDb.put(4, new User(4, "admin", "admin",true));
    }

    public void addUser(User user) {
        userDb.put(genId(), user);
    }

    public void deleteUser(int userId){
        userDb.remove(userId);
    }

    public void updateUser(User user){
        userDb.put(user.getId(), user);
    }

    public List<User> getAllUsers(){
        return new ArrayList<>(userDb.values());
    }

    public User getUserById(int userId){
        return userDb.get(userId);
    }

    public int genId() {
        return userDb.size()+1;
    }

    public boolean isValidUser(String username, String password) {
        for (int i=1; i <= userDb.size(); i++) {
            if (username.equals(userDb.get(i).getUsername()) && password.equals(userDb.get(i).getPassword())) {
                return true;
            }
        }
        return false;
    }

    public User getUserByName(String username) {
        for (int i=1; i <= userDb.size(); i++) {
            if (username.equals(userDb.get(i).getUsername()) ) {
                return userDb.get(i);
            }
        }
        return null;
    }
}
