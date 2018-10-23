package system.model;

public class NoPublicPet {
    private int idPet;
    private int idModerator;
    private int countEdit;
    private long dateEditUser;
    private long dateEditModerator;
    private String messageForUser;

    public NoPublicPet(){}

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public int getIdModerator() {
        return idModerator;
    }

    public void setIdModerator(int idModerator) {
        this.idModerator = idModerator;
    }

    public int getCountEdit() {
        return countEdit;
    }

    public void setCountEdit(int countEdit) {
        this.countEdit = countEdit;
    }

    public long getDateEditUser() {
        return dateEditUser;
    }

    public void setDateEditUser(long dateEditUser) {
        this.dateEditUser = dateEditUser;
    }

    public long getDateEditModerator() {
        return dateEditModerator;
    }

    public void setDateEditModerator(long dateEditModerator) {
        this.dateEditModerator = dateEditModerator;
    }

    public String getMessageForUser() {
        return messageForUser;
    }

    public void setMessageForUser(String messageForUser) {
        this.messageForUser = messageForUser;
    }

    @Override
    public String toString() {
        return "NoPublicPet{" +
                "idPet=" + idPet +
                ", idModerator=" + idModerator +
                ", countEdit=" + countEdit +
                ", dateEditUser=" + dateEditUser +
                ", dateEditModerator=" + dateEditModerator +
                ", messageForUser='" + messageForUser + '\'' +
                '}';
    }
}
