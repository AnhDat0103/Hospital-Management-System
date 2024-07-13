package models;

public class AdminAccount {

    private final String userName;
    private final String password;

    public AdminAccount() {
        this.userName = "admin";
        this.password = "admin";
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}
