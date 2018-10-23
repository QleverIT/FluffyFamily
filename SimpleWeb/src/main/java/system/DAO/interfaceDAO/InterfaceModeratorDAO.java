package system.DAO.interfaceDAO;

import system.model.Moderator;

import java.util.List;

public interface InterfaceModeratorDAO {

    void insertModerator(Moderator moderator);
    void deleteModerator(Moderator moderator);
    void deleteModeratorById(int id);
    Moderator getModeratorById(int id);
    Moderator getModeratorByLogin(String login);
    Moderator getModeratorByEmail(String email);

    List<Moderator> getAllModerators();
}
