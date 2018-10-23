package system.model;

public class ParamPet {
    private int idParamPet;
    private String nameParamPet;

    public  ParamPet(){}

    public int getIdParamPet() {
        return idParamPet;
    }

    public void setIdParamPet(int idParam) {
        this.idParamPet = idParam;
    }

    public String getNameParamPet() {
        return nameParamPet;
    }

    public void setNameParamPet(String nameParam) {
        this.nameParamPet = nameParam;
    }

    @Override
    public String toString() {
        return "ParamPet{" +
                "idParamPet=" + idParamPet +
                ", nameParamPet='" + nameParamPet + '\'' +
                '}';
    }
}


