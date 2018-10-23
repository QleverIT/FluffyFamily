package system.model.form;

public class PetEditForm {
    String message;
    Boolean type;
    Boolean gender;
    Boolean age;
    Boolean character;
    Boolean training;
    Boolean eyeColor;
    Boolean color;
    Boolean price;
    Boolean name;
    Boolean annotation;
    Boolean about;
    Boolean contact;
    Boolean img;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Boolean getAge() {
        return age;
    }

    public void setAge(Boolean age) {
        this.age = age;
    }

    public Boolean getCharacter() {
        return character;
    }

    public void setCharacter(Boolean character) {
        this.character = character;
    }

    public Boolean getTraining() {
        return training;
    }

    public void setTraining(Boolean training) {
        this.training = training;
    }

    public Boolean getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(Boolean eyeColor) {
        this.eyeColor = eyeColor;
    }

    public Boolean getColor() {
        return color;
    }

    public void setColor(Boolean color) {
        this.color = color;
    }

    public Boolean getPrice() {
        return price;
    }

    public void setPrice(Boolean price) {
        this.price = price;
    }

    public Boolean getName() {
        return name;
    }

    public void setName(Boolean name) {
        this.name = name;
    }

    public Boolean getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Boolean annotation) {
        this.annotation = annotation;
    }

    public Boolean getAbout() {
        return about;
    }

    public void setAbout(Boolean about) {
        this.about = about;
    }

    public Boolean getContact() {
        return contact;
    }

    public void setContact(Boolean contact) {
        this.contact = contact;
    }

    public Boolean getImg() {
        return img;
    }

    public void setImg(Boolean img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "PetEditForm{" +
                "message='" + message + '\'' +
                ", type=" + type +
                ", gender=" + gender +
                ", age=" + age +
                ", character=" + character +
                ", training=" + training +
                ", eyeColor=" + eyeColor +
                ", color=" + color +
                ", price=" + price +
                ", name=" + name +
                ", annotation=" + annotation +
                ", about=" + about +
                ", contact=" + contact +
                ", img=" + img +
                '}';
    }
}
