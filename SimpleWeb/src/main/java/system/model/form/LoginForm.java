package system.model.form;

import org.hibernate.validator.constraints.NotBlank;
import system.helper.NameFields;
import system.helper.ValidateHelper;

public class LoginForm {

    @NotBlank(message = ValidateHelper.errorNotBlank)
    private String login;

    @NotBlank(message = ValidateHelper.errorNotBlank)
    private String password;

    public static final String LOGIN = NameFields.LOGIN;
    public static final String PASSWORD = NameFields.PASSWORD;

    public LoginForm(){}

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

}
