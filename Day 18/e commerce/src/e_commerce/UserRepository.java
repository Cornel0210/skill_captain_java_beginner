package e_commerce;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UserRepository {
    Map<String, User> users;

    public UserRepository() {
        users = new HashMap<>();
    }

    public void addUser(User user){
        if (user == null){
            return;
        }

        if (users.putIfAbsent(user.getEmail(), user) == null){
            System.out.println(user.getName() + " has been added to the repository");
        } else {
            System.out.println("User already exists");
        }
    }

    public User getUser(String email){
        if (email != null){
            return users.get(email);
        }
        return null;
    }

    public Set<User> getAllUsers(){
        return new HashSet<>(users.values());
    }
}
