package dk.mebl.BL;

import dk.mebl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo implements IUserRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public void createUser(User user) {
        jdbc.update("INSERT INTO user (username, address, email, password) VALUES ('"+ user.getUsername() + "','" + user.getAddress() + "','" + user.getEmail() + "','" + user.getPassword() + "')");
    }

    public void changePassword(String password) {
    }
    public void deleteUser(User user, String password) {

    }
    public void login(String username, String password) {

    }
}
