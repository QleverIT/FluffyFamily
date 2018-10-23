package system.helper;

import java.util.UUID;

public class ValidateHelper {
    public static final String errorNotBlank = "Поле не может быть пустым.";
    public static final String errorSizeLogin = "Поле должно содеражть от 3 до 18 символов.";
    public static final String errorSizePassword = "Поле должно содеражть от 3 до 10 символов.";
    public static final String errorInputLogin = "Логин не может заканчиваться цифрой. Допустимы только цифры и буквы латинского алфовита";
    public static final String errorInputPassword = "Пароль введен не верно. Допустимы только цифры и буквы латинского алфовита";
    public static final String errorInputEmail = "Email введен неверно!";
    public static final String errorInputTelephone = "Номер телефона введен не верно!";
    public static final String errorBirthdayPet = "Ввести дату рождения питомца в формате DD/MM/YYYY" +
            " или введите \"?\", если вы ее не знаете.";
    //public static final String errorPrice = "Введите цену в формате ...ddd,dd или \"Дарим\"";
    public static final String errorPrice = "Введите цену - целое число или \"Дарим\"";

    public static final String errorEmailModerator = "Модератор с таким email уже существует";

    public static final String regTelephone = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
    public static final String regUserLogin = "^([A-z0-9]*[^0-9])?$";
    public static final String regEmail = "^([_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))?$";
    public static final String regPassword = "^[A-Za-z0-9]*$";

    public static final String regBirthdayPet = "^[((0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d),\\?]$";
    //public static final String regPrice = "^[(/\\b\\d+,\\d{2}\\b/),\\?]$";
    public static final String regPrice = "^[\\d+|(Дарим)]$";

    private ValidateHelper(){}

    //генератор паролей
    public static String generatePassword(){
        String password = UUID.randomUUID().toString();
        password = password.replace("-", "");
        password = password.substring(0,6);
        return password;
    }



    /*public static final String errorNotBlank(String s){
        return "Поле не может быть пустым. Введите "+s;
    }*/

    //генерация сообщений об ошибках
}
