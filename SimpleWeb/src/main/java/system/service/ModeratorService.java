package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.DAO.implementDAO.ModeratorDAO;
import system.helper.ValidateHelper;
import system.model.Moderator;
import system.model.Pet;
import system.model.form.ModeratorLkForm;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModeratorService {
    @Autowired
    private ModeratorDAO moderatorDAO;
    @Autowired
    private PetService petService;

    public boolean findModeratorByLogin(String login) {
        Moderator moderator = moderatorDAO.getModeratorByLogin(login);
        return (moderator != null);
    }

    //поиск user по email
    public boolean findModeratorByEmail(String email){
        Moderator moderator = moderatorDAO.getModeratorByEmail(email);
        return moderator != null;
    }

    public boolean authorizeModerator(String login, String password){
        Moderator user = moderatorDAO.getModeratorByLogin(login);
        String userPassword = user.getPassword();
        return userPassword.equals(password);
    }

    public ModeratorLkForm getModeratorLkFormById(int id){

        List<Pet> pets =  petService.getPetsByModeratorId(id);

        List<Pet> newPets = new ArrayList<>();
        List<Pet> hoverPets = new ArrayList<>();
        List<Pet> editPets = new ArrayList<>();

        if(pets!=null){
            int idPet;
            for(Pet pet:pets){
                idPet = pet.getIdPet();
                if(petService.petIsNew(idPet))
                    newPets.add(pet);
                else if(petService.petIsHoverAModerator(idPet))
                    editPets.add(pet);
                else
                    hoverPets.add(pet);
            }
        }


        ModeratorLkForm moderatorLkForm =  new ModeratorLkForm();

        moderatorLkForm.setIdModerator(id);
        moderatorLkForm.setNewPets(newPets);
        moderatorLkForm.setHoverPets(hoverPets);
        moderatorLkForm.setEditPets(editPets);

        return  moderatorLkForm;
    }

    public void updatePet(int idPet){
        petService.updateNoPublicPetForModerator(idPet);
    }

    public Moderator getModeratorByEmail(String email){
        return moderatorDAO.getModeratorByEmail(email);
    }

    public void insertModerator(Moderator moderator){

        String name = moderator.getName();
        String surname = moderator.getSurname();
        String middleName = moderator.getMiddleName();

        //исп для входа в систему
        String login = moderator.getEmail();
        login = login.replaceAll("[^A-Za-zА-Яа-я0-9]", "");

        moderator.setLogin(login+"0");

        //Имя + Отчество (вашу анкету проверял(а) + ник)
        String nickname = name + " " + middleName;

        moderator.setNickname(nickname);

        //генерация случайного пароля
        String password = ValidateHelper.generatePassword();
        moderator.setPassword(password);

        moderatorDAO.insertModerator(moderator);
    }


    public int getIdModeratorForTask() {
        return 3;
    }

    public int getIdModeratorByLogin(String login) {
        Moderator moderator = moderatorDAO.getModeratorByLogin(login);
        return moderator.getIdModerator();
    }

    public  Moderator getModeratorById(int idModerator){
        return moderatorDAO.getModeratorById(idModerator);
    }

    public List<Moderator> getAllModerators() {
        return moderatorDAO.getAllModerators();
    }
}
