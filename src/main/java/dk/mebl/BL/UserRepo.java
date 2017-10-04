package dk.mebl.BL;

import dk.mebl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo implements IUserRepo {

    @Autowired
    private JdbcTemplate jdbc;
    private User user = new User();

    public void createUser(User user) {
        jdbc.update("INSERT INTO user (username, address, email, password) VALUES ('"+ user.getUsername() + "','" + user.getAddress() + "','" + user.getEmail() + "','" + user.getPassword() + "')");
        System.out.println("User has been created");
    }

    public String changePassword(int id, String password) {
        if (readUser(id).equals(id)) {
            jdbc.update("UPDATE user SET " + "password = " + password + "WHERE id=" + user.getId());
            return password;
        }
        return null;
    }

    public void deleteUser(User user, String password) {
        if (password.equals(user.getPassword())) {
            jdbc.update("DELETE FROM user WHERE password = password");
        }
    }
    public User login(String username, String password) {
//        if () {
//            return user;
//        }
//        jdbc.("SELECT username AND password FROM user WHERE EXISTS (SELECT user WHERE username = '"+ username +"' AND password ='"+ password+"'");
//        System.out.println(jdbc.update("SELECT username AND password FROM user WHERE EXISTS (SELECT user WHERE username = '"+ username +"' AND password ='"+ password+"'"));
        return null;
    }

    public User readUser(int id) {
        if (user.getId() == id) {
            jdbc.update("SELECT * FROM user WHERE id = " + user.getId());
            return user;
        }
        return null;
    }
}