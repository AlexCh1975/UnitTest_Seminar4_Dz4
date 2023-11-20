package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        if (user != null && user.authenticate(user.name, user.password)){
            data.add(user);
            System.out.println("User added successfully.");
        }else System.out.println("Authentication failed. User not added.");

    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public List<User> getData() {
        return data;
    }

    // Метод для разлогинивания не администраторов
    public void logoutNonAdmins() {
        for (User user : data) {
            if (!user.isAdmin) {
                // Разлогиниваем пользователя
                user.isAuthenticate = false;
            }
        }
    }
}