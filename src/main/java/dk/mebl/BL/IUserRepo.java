package dk.mebl.BL;

import dk.mebl.model.User;

public interface IUserRepo {
    void createUser(User user);
    String changePassword(int id, String password);
    void deleteUser(User user, String password);
    Boolean login(String username, String password);
    User readUser(int id);
}
