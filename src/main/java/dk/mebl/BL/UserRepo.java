package dk.mebl.BL;

import dk.mebl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
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

    public User changePassword(User user, User user2) {
        if (read(user.getId()) == user && user == user2) {
            jdbc.update("UPDATE user SET password = '" + user2.getPassword() + "' WHERE id= '" + user.getId() + "'");
            return user2;
        }
        return null;
    }

    public boolean deleteUser(User user, String password) {
        if (password.equals(user.getPassword())) {
            jdbc.update("DELETE FROM user WHERE password = password");
            return true;
        }
            return false;
    }
    public User login(String username, String password) {
        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM user WHERE username = '"+ username +"' AND password ='"+ password +"'");

        if (sqlRowSet.next()){
            return new User(sqlRowSet.getInt("id"), sqlRowSet.getString("username"), sqlRowSet.getString("password"), sqlRowSet.getString("email"), sqlRowSet.getString("address"));
        }
        return null;
    }

    public User read(int id) {
//        if (user.getId() == id) {
//            jdbc.update("SELECT * FROM user WHERE id = " + user.getId());
//            return user;
//        }
        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM user WHERE id =" + id + "");

        if (sqlRowSet.next()){
            System.out.println();
            return new User(sqlRowSet.getInt("id"), sqlRowSet.getString("username"), sqlRowSet.getString("password"), sqlRowSet.getString("email"), sqlRowSet.getString("address"));
        }

        return null;
    }

    public int getId(User user){
        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT id FROM user WHERE username = '"+ user.getUsername() + "' AND password ='"+ user.getPassword() +"'");
        if (sqlRowSet.next()) {
            return sqlRowSet.getInt("id");
        }

        return 0;
    }
}