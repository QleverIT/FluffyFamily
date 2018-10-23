package system.model;

import org.hibernate.validator.constraints.NotBlank;
import system.helper.ValidateHelper;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

    private int idUser;

    @Size(message = ValidateHelper.errorSizeLogin, min=3, max=18)
    @Pattern(message = ValidateHelper.errorInputLogin,
            regexp = ValidateHelper.regUserLogin)
    private String login;

    @NotBlank(message = ValidateHelper.errorNotBlank)
    private String nameAndMiddleName;

    @Size(message = ValidateHelper.errorSizePassword, min=3, max=10)
    @Pattern(message = ValidateHelper.errorInputPassword,
            regexp = ValidateHelper.regPassword)
    private String password;

    @NotBlank(message = ValidateHelper.errorNotBlank)
    @Pattern (message = ValidateHelper.errorInputEmail,
              regexp = ValidateHelper.regEmail)
    private String email;

    public User(){}

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int id){
        this.idUser = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setNameAndMiddleName(String nameAndMiddleName) {
        this.nameAndMiddleName = nameAndMiddleName;
    }

    public String getNameAndMiddleName() {
        return nameAndMiddleName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", login='" + login + '\'' +
                ", nameAndMiddleName='" + nameAndMiddleName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}



