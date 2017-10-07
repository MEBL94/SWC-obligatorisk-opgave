package dk.mebl.model;

public class NewPassword {
    private String oldPassword;
    private String password1;
    private String password2;

    public NewPassword(){

    }

    public NewPassword(String oldPassword, String password1, String password2){
        this.oldPassword = oldPassword;
        this.password1 = password1;
        this.password2 = password2;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    @Override
    public String toString() {
        return "NewPassword{" +
                "password1='" + password1 + '\'' +
                ", password2='" + password2 + '\'' +
                '}';
    }
}
