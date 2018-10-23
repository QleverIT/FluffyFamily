package system.model.form;

public class FindPetForm {

    private int idType;
    private int idCharacter;
    private int idTraining;
    private int idEyeColor;
    private int idColor;

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
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

    @Override
    public String toString() {
        return "FindPetForm{" +
                "idType=" + idType +
                ", idCharacter=" + idCharacter +
                ", idTraining=" + idTraining +
                ", idEyeColor=" + idEyeColor +
                ", idColor=" + idColor +
                '}';
    }
}
