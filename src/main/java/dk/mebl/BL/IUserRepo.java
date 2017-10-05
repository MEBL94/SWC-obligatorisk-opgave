package dk.mebl.BL;

import dk.mebl.model.User;

public interface IUserRepo {
    void createUser(User user);
    String changePassword(int id, String password);
    boolean deleteUser(User user, String password);
    User login(String username, String password);
    User readUser(int id);
}
