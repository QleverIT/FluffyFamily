package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.DAO.implementDAO.PetDAO;
import system.model.*;
import system.model.form.FindPetForm;
import system.model.form.PetForm;
import system.model.form.PetEditForm;

import java.util.*;

@Service
public class PetService {
    @Autowired
    private PetDAO petDAO;
    @Autowired
    private UserService userService;
    @Autowired
    private ModeratorService moderatorService;

    public void insertPet(Pet pet){

        petDAO.insertPet(pet);

        pet = petDAO.getPetByPassImg(pet.getPassImg());

        NoPublicPet noPublicPet = new NoPublicPet();

        int idModerator = moderatorService.getIdModeratorForTask();
        noPublicPet.setIdModerator(idModerator);

        noPublicPet.setCountEdit(0);
        noPublicPet.setDateEditUser(new Date().getTime());
        noPublicPet.setIdPet(pet.getIdPet());

        petDAO.insertNoPublicPet(noPublicPet);


    }

    public void deletePetById(int idPet) {
        petDAO.deleteNoPublicPetById(idPet);
        petDAO.deletePetById(idPet);
    }

    public Pet getPetById(int idPet) {
        return petDAO.getPetById(idPet);
    }

    public List<Pet> getPublicPets(){
        return petDAO.getPetsByPublic(true);
    }

    public List<Pet> getPetsByFindPetForm(FindPetForm form){

        int[] paramForm={
            form.getIdType(),
            form.getIdCharacter(),
            form.getIdTraining(),
            form.getIdEyeColor(),
            form.getIdColor()
        };

        //собрать имя колонки и искомое значение в два массива
        List<String> column = new ArrayList<>();
        List<Integer> value = new ArrayList<>();

        column.add("isPublic");
        value.add(1);

        for (int i = 1; i<paramForm.length+1; i++){
            if(paramForm[i-1] > 0){
                value.add(paramForm[i-1]);
                switch (i){
                    case 1:
                        column.add("idType");
                        break;
                    case 2:
                        column.add("idCharacter");
                        break;
                    case 3:
                        column.add("idTraining");
                        break;
                    case 4:
                        column.add("idEyeColor");
                        break;
                    case 5:
                        column.add("idColor");
                        break;
                }
            }
        }
        int sizeParam = column.size();
        String[] paramColumn = column.toArray(new String[sizeParam]);
        Integer[] paramValue = value.toArray(new Integer[sizeParam]);



        return petDAO.getPetsByParam(paramColumn,paramValue);

    }

    public List<Pet> getPetsByUserId(int idUser){
        return petDAO.getPetsByUserId(idUser);
    }

    public Map<String,List<ParamPet>> getAllParamsPet(){
        Map params = new HashMap<String,List<ParamPet>>();
        params.put("typesPet", petDAO.getAllTypePet());
        params.put("charactersPet", petDAO.getAllCharacterPet());
        params.put("trainingsPet", petDAO.getAllTrainingPet());
        params.put("eyeColorsPet", petDAO.getAllEyeColorPet());
        params.put("colorsPet", petDAO.getAllColorPet());
        return params;
    }

    public PetForm getPetFormById(int idPet) {
        Pet pet = petDAO.getPetById(idPet);
        if (pet==null)
            return null;

        PetForm form = new PetForm();

        form.setGender(pet.getGender());
        form.setAge(pet.getAge());
        form.setPrice(pet.getPrice());
        form.setName(pet.getName());
        form.setAnnotation(pet.getAnnotation());
        form.setAbout(pet.getAbout());
        form.setPassImg(pet.getPassImg());

        ParamPet paramPet;
        String value;
        int id;

        id = pet.getIdType();
        paramPet = petDAO.getTypePetById(id);
        value = paramPet.getNameParamPet();
        form.setType(value);

        id = pet.getIdCharacter();
        paramPet = petDAO.getCharacterPetById(id);
        value = paramPet.getNameParamPet();
        form.setCharacter(value);

        id = pet.getIdTraining();
        paramPet = petDAO.getTrainingPetById(id);
        value = paramPet.getNameParamPet();
        form.setTraining(value);

        id = pet.getIdEyeColor();
        paramPet = petDAO.getEyeColorPetById(id);
        value = paramPet.getNameParamPet();
        form.setEyeColor(value);

        id = pet.getIdColor();
        paramPet = petDAO.getColorPetById(id);
        value = paramPet.getNameParamPet();
        form.setColor(value);

        User user = userService.getUserById(pet.getIdUser());
        String contact = "Если "+pet.getName()+" вам нравится, то пишите на почту "+
                user.getNameAndMiddleName() +" : "+user.getEmail();
        form.setContact(contact);

        return form;
    }

    public boolean petIsHoverAModerator(int idPet){
        NoPublicPet pet = petDAO.getNoPublicPetById(idPet);
        if (pet==null)
            return false;
        return (pet.getDateEditUser() - pet.getDateEditModerator() >= 0);
    }

    public boolean petIsNew(int idPet){
        NoPublicPet pet = petDAO.getNoPublicPetById(idPet);
        if (pet==null)
            return false;
        return (pet.getDateEditModerator() == 0);
    }

    public List<Pet> getPetsByModeratorId(int id) {
        List<NoPublicPet> petsNoP = petDAO.getNoPublicPetsByModeratorId(id);
        List<Pet> pets = new ArrayList<>();

        if(petsNoP == null)
            return null;
        Pet pet;
        for(NoPublicPet petNoP:petsNoP){
            pet = petDAO.getPetById(petNoP.getIdPet());
            pets.add(pet);
        }
        if(pets.size()==0)
            return null;

        return pets;
    }


    public void updateNoPublicPetForModerator(PetEditForm formEdit, int idPet, int idModerator) {

        Moderator moder = moderatorService.getModeratorById(idModerator);

        String message = "";
        if(!editPetFormIsOk(formEdit)) {

            message = "Вашу анкету проверял модератор " + moder.getName() + " " +
                    moder.getMiddleName() + " " + moder.getSurname() + ". " +
                    "Вы можете написать модератору на почту, если появятся вопросы: " +
                    moder.getEmail() + ". Пожалуйста, исправтье поля: ";

            if (!formEdit.getType())
                message += "тип питомца | ";

            if (!formEdit.getGender())
                message += "пол питомца | ";

            if (!formEdit.getAge())
                message += "возраст питомца | ";

            if (!formEdit.getCharacter())
                message += "характер питомца | ";

            if (!formEdit.getTraining())
                message += "умение питомца | ";

            if (!formEdit.getEyeColor())
                message += "цвет глаз питомца | ";

            if (!formEdit.getColor())
                message += "окрас питомца | ";

            if (!formEdit.getPrice())
                message += "цена питомца | ";

            if (!formEdit.getName())
                message += "имя питомца | ";

            if (!formEdit.getAnnotation())
                message += "краткое описание питомца | ";

            if (!formEdit.getAbout())
                message += "описание питомца |";

            if (!formEdit.getContact())
                message += "контактные данные |";

            if (!formEdit.getImg())
                message += "фотография питомца |";

            String getM = formEdit.getMessage();
            if (getM != null && !getM.matches("^\\s*$"))
                message += " У модератора есть сообщение для вас: " + formEdit.getMessage();
        }else{
            message = "ok";
        }
        petDAO.updateNoPublicPetByModerator(message, idPet);

    }

    public void updateNoPublicPetForModerator(int idPet) {
        int count = petDAO.getNoPublicPetById(idPet).getCountEdit()+1;
        long date = new Date().getTime();
        petDAO.updateNoPublicPetByModerator(count, date, idPet);
    }


    public void updatePetForUser(Pet pet) {
        int idPet = pet.getIdPet();
        long date = new Date().getTime();
        petDAO.updateNoPublicPetByUser(date,idPet);
        petDAO.updatePet(pet);
    }

    public String getMessageByIdPet(int idPet) {
        NoPublicPet pet = petDAO.getNoPublicPetById(idPet);
        return pet.getMessageForUser();
    }


    public void insertPetPublicById(int idPet) {
        petDAO.updatePublicPet(idPet);
        petDAO.deleteNoPublicPetById(idPet);
    }

    public boolean editPetFormIsOk(PetEditForm formEdit){
        if(formEdit==null)return false;
        if(!formEdit.getType())
            return false;

        if(!formEdit.getGender())
            return false;

        if(!formEdit.getAge())
            return false;

        if(!formEdit.getCharacter())
            return false;

        if(!formEdit.getTraining())
            return false;

        if(!formEdit.getEyeColor())
            return false;

        if(!formEdit.getColor())
            return false;

        if(!formEdit.getPrice())
            return false;

        if(!formEdit.getName())
            return false;

        if(!formEdit.getAnnotation())
            return false;

        if(!formEdit.getAbout())
            return false;

        if(!formEdit.getContact())
            return false;

        if(!formEdit.getImg())
            return false;

        return true;
    }

    public void deletePetByIdUser(int idUser) {
        List<Pet> pets = petDAO.getPetsByUserId(idUser);
        int id;
        if(pets!=null){
            for(Pet pet:pets){
                id = pet.getIdPet();
                petDAO.deleteNoPublicPetById(id);
                petDAO.deletePetById(id);
            }
        }

    }
}
