package system.model.form;
import system.model.Pet;

import java.util.List;

public class ModeratorLkForm {
    private int idModerator;
    private List<Pet> newPets;
    private List<Pet> hoverPets;
    private List<Pet> editPets;

    public ModeratorLkForm(){}

    public int getIdModerator() {
        return idModerator;
    }

    public void setIdModerator(int idModerator) {
        this.idModerator = idModerator;
    }

    public List<Pet> getNewPets() {
        return newPets;
    }

    public void setNewPets(List<Pet> newPets) {
        this.newPets = newPets;
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

    @Override
    public String toString() {
        return "ModeratorLkForm{" +
                "idModerator=" + idModerator +
                ", newPets=" + newPets +
                ", hoverPets=" + hoverPets +
                ", editPets=" + editPets +
                '}';
    }
}
