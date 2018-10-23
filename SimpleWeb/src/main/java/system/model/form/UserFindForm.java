package system.model.form;

public class UserFindForm {
    private String login;
    private String email;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserFindForm{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
