package system.model.form;

import system.model.Moderator;

import java.util.List;

public class AdminLkForm {
    List<Moderator> modetators;

    public List<Moderator> getModetators() {
        return modetators;
    }

    public void setModetators(List<Moderator> modetators) {
        this.modetators = modetators;
    }

    @Override
    public String toString() {
        return "AdminLkForm{" +
                "modetators=" + modetators +
                '}';
    }
}
