package system.model;

import org.hibernate.validator.constraints.NotBlank;
import system.helper.ValidateHelper;

public class Pet {
    private int idPet;

    private int idType;

    private String gender;

    private int age;

    private int idCharacter;

    private int idTraining;

    private int idEyeColor; //*

    //@NotBlank(message = ValidateHelper.errorNotBlank)
    private int idColor; //*

    //@NotBlank(message = ValidateHelper.errorNotBlank)
   /* @Pattern(message = ValidateHelper.errorPrice,
             regexp = ValidateHelper.regPrice)*/
    private int price;

    @NotBlank(message = ValidateHelper.errorNotBlank)
    private String name;

    @NotBlank(message = ValidateHelper.errorNotBlank)
    private String annotation;

    @NotBlank(message = ValidateHelper.errorNotBlank)
    private String about;

    private int idUser;

    @NotBlank(message = ValidateHelper.errorNotBlank)
    private String passImg;

    private boolean isPublic;

    public Pet(){}

    public int getIdPet() {return idPet;}

    public void setIdPet(int idPet) {this.idPet = idPet;}

    public int getIdType() {return idType;}

    public void setIdType(int idType) {this.idType = idType;}

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIdCharacter() {
        return idCharacter;
    }

    public void setIdCharacter(int idCharacter) {
        this.idCharacter = idCharacter;
    }

    public int getIdTraining() {
        return idTraining;
    }

    public void setIdTraining(int idTraining) {
        this.idTraining = idTraining;
    }

    public int getIdEyeColor() {
        return idEyeColor;
    }

    public void setIdEyeColor(int idEyeColor) {
        this.idEyeColor = idEyeColor;
    }

    public int getIdColor() {
        return idColor;
    }

    public void setIdColor(int idColor) {
        this.idColor = idColor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getPassImg() {return passImg;}

    public void setPassImg(String passImg) {
        this.passImg = passImg;
    }

    public boolean getIsPublic() {return isPublic;}

    public void setIsPublic(boolean isPublic) {this.isPublic = isPublic;}

    @Override
    public String toString() {
        return "Pet{" +
                "idPet=" + idPet +
                ", idType=" + idType +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", idCharacter=" + idCharacter +
                ", idTraining=" + idTraining +
                ", idEyeColor=" + idEyeColor +
                ", idColor=" + idColor +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", annotation='" + annotation + '\'' +
                ", about='" + about + '\'' +
                ", idUser=" + idUser +
                ", passImg='" + passImg + '\'' +
                ", publicPet=" + isPublic +
                '}';
    }
}

