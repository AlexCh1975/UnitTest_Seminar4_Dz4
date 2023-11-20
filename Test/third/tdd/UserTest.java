package third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import seminars.third.tdd.User;
import seminars.third.tdd.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;
    private UserRepository userRepository;

    @BeforeEach
    void setUp(){
        user = new User("User1", "123", true);
        userRepository = new UserRepository();
    }

    /**
     * 3.6 Разработайте класс User с методом аутентификации по логину и паролю.
     * Метод должен возвращать true, если
     * введенные логин и пароль корректны, иначе false. Протестируйте все методы
     */
    @Test
    void testAuthenticateTrue(){
        assertTrue(user.authenticate("User1", "123"));
    }

    @ParameterizedTest
    @CsvSource({
            "'User123', '123'",
            "'User1', '1234'"
    })
    void testAuthenticateFalse(String name, String password){
        assertFalse(user.authenticate(name, password));
    }

    /**
     *  3.7 Добавьте класс UserRepository для управления пользователями. В этот
     *  класс должен быть включен метод
     * addUser, который добавляет пользователя в систему, если он прошел аутентификацию.
     * Покройте тестами новую
     * функциональность
     */
    @Test
    void testAddUserInRepository(){
        int sizeIn = userRepository.getData().size();
        userRepository.addUser(new User("User2", "321", false));
        assertEquals(sizeIn + 1, userRepository.getData().size());
    }

    /**
     * hw Задание 3.3. Добавьте функцию в класс UserRepository, которая разлогинивает
     * всех пользователей,
     * кроме администраторов. Для этого, вам потребуется расширить класс User новым
     * свойством,
     * указывающим, обладает ли пользователь админскими правами. Протестируйте данную
     * функцию.
     */
    @Test
    void testLogoutNonAdmins(){
        User user3 = new User("User3", "12345", false);
        // Добавляем пользователей
        userRepository.addUser(user);
        userRepository.addUser(user3);
        // проеряем, что пользователи залогинены
        assertTrue(user.authenticate("User1", "123"));
        assertTrue(user3.authenticate("User3", "12345"));
        // разлогиниваем
        userRepository.logoutNonAdmins();
        // Проверяем
        assertFalse(user3.isAuthenticate());
        assertTrue(user.isAuthenticate());
    }

}