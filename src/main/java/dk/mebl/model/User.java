package dk.mebl.model;

public class User {
    private int id;
    private String username;
    private String address;
    private String email;
    private String password;
    private String newPassword;
    private String newPasswordConfirm;

    public User(int id, String username, String password, String newPassword, String newPasswordConfirm, String address, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.newPassword = newPassword;
        this.newPasswordConfirm = newPasswordConfirm;
        this.address = address;
        this.email = email;
    }


    public User(int id, String username, String password, String address, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.email = email;
    }
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
