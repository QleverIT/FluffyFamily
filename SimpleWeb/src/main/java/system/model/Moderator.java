package system.model;

import org.hibernate.validator.constraints.NotBlank;
import system.helper.NameFields;
import system.helper.ValidateHelper;

import javax.validation.constraints.Pattern;

public class Moderator {
    private int idModerator;

    //исп для входа в систему и отображается в ЛК админа
    //генерируется автоматически в ModeratorService методе setModerator
    private String login;

    //генерируется в ModeratorService методе setModerator
    private String nickname;

    @NotBlank(message = ValidateHelper.errorNotBlank)
    @Pattern(message = ValidateHelper.errorInputEmail,
            regexp = ValidateHelper.regEmail)
    private String email;

    @NotBlank(message = ValidateHelper.errorNotBlank)
    private String name;

    @NotBlank(message = ValidateHelper.errorNotBlank)
    private String surname;

    @NotBlank(message = ValidateHelper.errorNotBlank)
    private String middleName;

    @NotBlank(message = ValidateHelper.errorNotBlank)
    @Pattern(regexp = ValidateHelper.regTelephone,
             message = ValidateHelper.errorInputTelephone)
    private String telephone;

    //генерируется автоматически
    private String password;

    private boolean vacation;

    public Moderator(){
        this.vacation = false;
    }

    public int getIdModerator() {
        return idModerator;
    }

    public void setIdModerator(int idModerator) {
        this.idModerator = idModerator;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getVacation() {
        return vacation;
    }

    public void setVacation(boolean vacation) {
        this.vacation = vacation;
    }

    @Override
    public String toString() {
        return "Moderator{" +
                "idModerator=" + idModerator +
                ", login='" + login + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", vacation=" + vacation +
                '}';
    }
}
