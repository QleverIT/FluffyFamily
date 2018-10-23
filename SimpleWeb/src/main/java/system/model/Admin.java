package system.model;

import system.helper.NameFields;

public final class Admin {
    //private int idAdmin;
    private String login;
    private String password;
    private String email;

    /*
    public static final String LOGIN = NameFields.LOGIN;
    public static final String PASSWORD = NameFields.PASSWORD;
    public static final String EMAIL = NameFields.EMAIL;
*/
    public Admin(){}


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
