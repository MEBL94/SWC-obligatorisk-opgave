package dk.mebl.BL;

import dk.mebl.model.User;

public interface IUserRepo {
    void createUser(User user);
    User changePassword(User user, String newPassword);
    boolean deleteUser(User user, String password);
    User login(String username, String password);
    User read(int id);
}
