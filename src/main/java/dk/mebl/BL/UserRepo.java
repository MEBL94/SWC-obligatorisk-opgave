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
    }

    public void changePassword(String password) {
        jdbc.update("UPDATE user SET " + "password = " + password + "WHERE id=" + user.getId());
    }

    public void deleteUser(User user, String password) {
        if (password.equals(user.getPassword())) {
            jdbc.update("DELETE FROM user WHERE password = password");
        }
    }
    public Boolean login(String username, String password) {
        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            return true;
        }
        return false;
    }
}