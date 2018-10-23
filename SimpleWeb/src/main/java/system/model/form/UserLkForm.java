package system.model.form;
import system.model.Pet;
import java.util.List;

public class UserLkForm {
    private int idUser;
    private List<Pet> publicPets;
    private List<Pet> hoverPets;
    private List<Pet> editPets;

    public UserLkForm(){}

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public List<Pet> getPublicPets() {
        return publicPets;
    }

    public void setPublicPets(List<Pet> publicPets) {
        this.publicPets = publicPets;
    }

    public List<Pet> getHoverPets() {
        return hoverPets;
    }

    public void setHoverPets(List<Pet> hoverPets) {
        this.hoverPets = hoverPets;
    }

    public List<Pet> getEditPets() {
        return editPets;
    }

    public void setEditPets(List<Pet> editPets) {
        this.editPets = editPets;
    }
}
