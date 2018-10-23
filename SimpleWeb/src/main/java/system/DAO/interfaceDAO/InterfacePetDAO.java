package system.DAO.interfaceDAO;

import system.model.ParamPet;
import system.model.Pet;
import system.model.NoPublicPet;

import java.util.List;

public interface InterfacePetDAO {
    void insertNoPublicPet(NoPublicPet noPublicPet);
    NoPublicPet getNoPublicPetById(int idPet);

    List<NoPublicPet> getNoPublicPetsByModeratorId(int idModerator);
    void updateNoPublicPetByModerator(String message,  int idPet);
    void updateNoPublicPetByModerator(int count, long date, int idPet);

    void updateNoPublicPetByUser(long date, int idPet);
    void deleteNoPublicPetById(int idPet);

    void insertPet(Pet pet);
    void updatePet(Pet pet);
    void updatePublicPet(int idPet);
    void deletePetById(int idPet);
    Pet getPetById(int idPet);
    List<Pet> getPetsByPublic(Boolean isPublic);
    List<Pet> getPetsByParam(String[] paramColumn, Integer[] paramValue);
    List<Pet> getPetsByUserId(int idUser);

    ParamPet getTypePetById(int idType);
    List<ParamPet> getAllTypePet();
    ParamPet getCharacterPetById(int idCharacter);
    List<ParamPet> getAllCharacterPet();
    ParamPet getTrainingPetById(int idTraining);
    List<ParamPet> getAllTrainingPet();
    ParamPet getEyeColorPetById(int idEyeColor);
    List<ParamPet> getAllEyeColorPet();
    ParamPet getColorPetById(int idColor);
    List<ParamPet> getAllColorPet();

}
