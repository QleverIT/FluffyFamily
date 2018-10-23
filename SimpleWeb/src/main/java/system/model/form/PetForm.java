package system.model.form;

import system.model.Pet;

public class PetForm extends Pet {
    private String contact;
    private String type;
    private String character;
    private String training;
    private String eyeColor;
    private String color;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {

        return  "PetForm{" +
                ", type=" + type +
                ", gender=" + getGender() +
                ", age='" + getAge() + '\'' +
                ", character=" + character +
                ", training=" + training +
                ", eyeColor=" + eyeColor +
                ", color=" + color +
                ", price='" + getPrice() + '\'' +
                ", name='" + getName() + '\'' +
                ", annotation='" + getAnnotation() + '\'' +
                ", about='" + getAbout() + '\'' +
                ", contact='" + contact + '\'' +
                ", passImg='" + getPassImg() + '\'' +
                '}';
    }
}
