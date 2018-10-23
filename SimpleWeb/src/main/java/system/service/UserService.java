package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.DAO.implementDAO.UserDAO;
import system.model.Pet;
import system.model.User;
import system.model.form.UserLkForm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private PetService petService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private ModeratorService moderatorService;

    //поиск user по login
    public boolean findUserByLogin(String login) {
        User user = userDAO.getUserByLogin(login);
        return (user != null);
    }

    public int getIdUserByLogin(String login){
        User user = userDAO.getUserByLogin(login);
        return user.getIdUser();
    }

    //поиск user по email
    public boolean findUserByEmail(String email){
        User user = userDAO.getUserByEmail(email);
        return user != null;
    }

    //проверка на соответствие пароля и логина
    public boolean authorizeUser(String login, String password){
        User user = userDAO.getUserByLogin(login);
        String userPassword = user.getPassword();
        return userPassword.equals(password);
    }

    public UserLkForm getUserLkFormByLogin(String login){
        User user = userDAO.getUserByLogin(login);
        int idUser = user.getIdUser();
        return  getUserLkFormById(idUser);
    }

    public User getUserById(int idUser){
        return userDAO.getUserById(idUser);
    }

    public User getUserByLogin(String login){
        return userDAO.getUserByLogin(login);
    }

    public User getUserByEmail(String email){
        return userDAO.getUserByEmail(email);
    }

    public UserLkForm getUserLkFormById(int idUser){

        List<Pet> pets;
        pets = petService.getPetsByUserId(idUser);

        List<Pet> publicPets = new ArrayList<>();
        List<Pet> hoverPets = new ArrayList<>();
        List<Pet> editPets = new ArrayList<>();

        if(pets!=null){
            for (Pet pet:pets){
                if(pet.getIsPublic())
                    publicPets.add(pet);
                else if(petService.petIsHoverAModerator(pet.getIdPet()))
                    hoverPets.add(pet);
                else
                    editPets.add(pet);
            }
        }

        UserLkForm userLk =  new UserLkForm();

        userLk.setIdUser(idUser);
        userLk.setPublicPets(publicPets);
        userLk.setHoverPets(hoverPets);
        userLk.setEditPets(editPets);

        return  userLk;
    }

    public void insertUser(User user){
        userDAO.insertUser(user);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public void deleteUser(int idUser) {

        userDAO.deleteUserById(idUser);
        petService.deletePetByIdUser(idUser);
    }

    public Map<String,String> getErrorLoginEmailUser(String login, String email){
        boolean findLogin = findUserByLogin(login) ||
                moderatorService.findModeratorByLogin(login) ||
                adminService.findAdminByLogin(login);

        boolean findEmail = findUserByEmail(email);

        if(findEmail || findLogin){

            Map errorMessages = new HashMap<String,String>();
            String errorEmail = "";
            String errorLogin = "";

            if(findEmail)
                errorEmail = "Пользователь с таким email уже зарегестрирован!";

            if(findLogin)
                errorLogin = "Логин занят!";

            errorMessages.put("errorEmail",errorEmail);
            errorMessages.put("errorLogin",errorLogin);
            return errorMessages;
        }
        return null;
    }

    public Map<String,String> getErrorLoginEmailUser(String login, String email, int idUser){

        boolean findLogin =
                moderatorService.findModeratorByLogin(login) ||
                adminService.findAdminByLogin(login);

        if(!findLogin){
            User u1 = userDAO.getUserByLogin(login);
            if(u1!=null && u1.getIdUser()!=idUser)
                findLogin = true;
        }

        boolean findEmail = false;
        User u2 = getUserByEmail(email);
        if(u2!= null && u2.getIdUser()!=idUser)
            findEmail = true;

        if(findEmail || findLogin){

            Map errorMessages = new HashMap<String,String>();

            if(findEmail){
                String errorEmail = "Пользователь с таким email уже зарегестрирован!";
                errorMessages.put("errorEmail",errorEmail);
            }

            if(findLogin){
                String errorLogin = "Логин занят!";
                errorMessages.put("errorLogin",errorLogin);
            }
            return errorMessages;
        }
        return null;
    }
}
