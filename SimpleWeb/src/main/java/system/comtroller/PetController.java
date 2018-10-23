package system.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import system.model.ParamPet;
import system.model.Pet;
import system.model.form.FindPetForm;
import system.model.form.PetForm;
import system.model.form.PetEditForm;
import system.service.PetService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService petService;

    @RequestMapping(value = "/new_pet", method = RequestMethod.GET)
    public String newPetGet(Model model, HttpServletRequest request){

        HttpSession session = request.getSession();

        if(session.getAttribute("update")!=null && (boolean)session.getAttribute("update")){
            if(session.getAttribute("idPet")==null)
                return "redirect:/pet/lk_user/new_pet/return";
            int idPet = (int) session.getAttribute("idPet");
            String message = petService.getMessageByIdPet(idPet);
            model.addAttribute("message",message);
        }else {
            session.setAttribute("update",false);
        }

        model.addAttribute("update",(boolean)session.getAttribute("update"));

        if(session.getAttribute("idUser") == null){
            session.setAttribute("newPet",null);
            return "redirect:/authorize";
        }

        initModelList(model);

        Pet newPet = new Pet();
        if(session.getAttribute("newPet")!=null)
            newPet = (Pet) session.getAttribute("newPet");
        model.addAttribute("pet",newPet);

        return "pet_registration_page";
    }


    @RequestMapping(value = "/new_pet", method = RequestMethod.POST)
    public String newPetPost(@ModelAttribute("pet") @Valid Pet pet, BindingResult result,
                             HttpServletRequest request, Model model){
        HttpSession session = request.getSession();

        if(session.getAttribute("idUser") == null){
            session.setAttribute("newPet",null);
            return "redirect:/authorize";
        }

        boolean error = result.hasErrors();
        if (error){
            initModelList(model);
            session.setAttribute("newPet",pet);
            return "pet_registration_page";
        }

        int idUser = (int) request.getSession().getAttribute("idUser");
        pet.setIdUser(idUser);

        if(session.getAttribute("update")!=null && (boolean)session.getAttribute("update")){
            if(session.getAttribute("idPet")!=null){
                int idPet = (int)session.getAttribute("idPet");
                pet.setIdPet(idPet);
            }
            petService.updatePetForUser(pet);
        }
        else {
            petService.insertPet(pet);
        }
        return "redirect:/pet/lk_user/new_pet/return";
    }

    @RequestMapping(value = "/lk_user/edit_pet", method = RequestMethod.POST)
    public String lkUserEditPet(Model model, HttpServletRequest request, @ModelAttribute("idPet") int idPet){
        Pet pet = petService.getPetById(idPet);
        HttpSession session = request.getSession();
        session.setAttribute("idPet",idPet);
        session.setAttribute("newPet",pet);
        session.setAttribute("update",true);
        return "redirect:/pet/new_pet";
    }

    @RequestMapping(value = "/lk_user/delete_pet",method = RequestMethod.POST)
    public String lkUserDeletePet(Model model, @ModelAttribute("idPet") int idPet){
        petService.deletePetById(idPet);
        return "redirect:/user/lk";
    }

    @RequestMapping(value = "/find_pets", method = RequestMethod.GET)
    public String findPetsGet(Model model, HttpServletRequest request){

        HttpSession session = request.getSession();

        if(session.getAttribute("find")==null)
            session.setAttribute("find",true);

        model.addAttribute("find",session.getAttribute("find"));

        initModelList(model);
        List<Pet> result;

        FindPetForm form = new FindPetForm();
        if(session.getAttribute("findPetForm")!=null)
            form = (FindPetForm) session.getAttribute("findPetForm");

        model.addAttribute("findPetForm", form);

        if(session.getAttribute("resultFindPets")!=null) {
            result = (List<Pet>) session.getAttribute("resultFindPets");
        }
        else{
            result = petService.getPublicPets();
        }

        model.addAttribute("resultFindPets",result);

        return "find_pets_page";
    }

    @RequestMapping(value = "/find_pets", method = RequestMethod.POST)
    public String findPetsPost(Model model, HttpServletRequest request,
                               @ModelAttribute("findPetForm") FindPetForm form){
        HttpSession session = request.getSession();

        session.setAttribute("find",true);

        //Это означает, что пользователь не ввел никаких параметров поиска
        //и нажал на кнопку "найти"
        if(form==null)
            return "redirect:/pet/find_pets";

        session.setAttribute("findPetForm",form);

        List<Pet> result = petService.getPetsByFindPetForm(form);
        session.setAttribute("resultFindPets",result);

        if(result==null)
            session.setAttribute("find",false);

        return "redirect:/pet/find_pets";
    }

    @RequestMapping(value = "/find_pets/more", method = RequestMethod.POST)
    public String findPetsMorePost(Model model, HttpServletRequest request, @ModelAttribute("idPet") int idPet){

        HttpSession session = request.getSession();
        session.setAttribute("idPet", idPet);
        return  "redirect:/pet/find_pets/more";
    }

    @RequestMapping(value = "/find_pets/more", method = RequestMethod.GET)
    public String findPetsMoreGet(Model model, HttpServletRequest request){

        HttpSession session = request.getSession();
        if(session.getAttribute("idPet")==null)
            return "redirect:/pet/find_pets";
        int idPet = (int)session.getAttribute("idPet");//*
        PetForm form = petService.getPetFormById(idPet);
        model.addAttribute("petForm",form);
        model.addAttribute("ret","pub");
        return  "pet_page";
    }

    @RequestMapping(value = "/lk_user/view_pet", method = RequestMethod.POST)
    public String lkUserViewPetPost(Model model, HttpServletRequest request,
                                    @ModelAttribute("idPet") int idPet){

        HttpSession session = request.getSession();
        if(session.getAttribute("idUser") == null)
            return "redirect:/authorize";
        session.setAttribute("idPet", idPet);
        return  "redirect:/pet/lk_user/view_pet";
    }

    @RequestMapping(value = "/lk_moderator/view_pet", method = RequestMethod.GET)
    public String lkModerViewPetGet(Model model, HttpServletRequest request){

        HttpSession session = request.getSession();
        if(session.getAttribute("idPet")==null)
            if(session.getAttribute("idModerator") == null)
                return "redirect:/authorize";
            else
                return "redirect:/moderator/lk";
        int idPet = (int)session.getAttribute("idPet");
        PetForm form = petService.getPetFormById(idPet);
        model.addAttribute("petForm",form);
        model.addAttribute("ret","moder");
        return  "pet_page";
    }

    @RequestMapping(value = "/lk_moderator/view_pet", method = RequestMethod.POST)
    public String lkModerViewPetPost(Model model, HttpServletRequest request,
                                    @ModelAttribute("idPet") int idPet){

        HttpSession session = request.getSession();
        if(session.getAttribute("idModerator") == null)
            return "redirect:/authorize";
        session.setAttribute("idPet", idPet);
        return  "redirect:/pet/lk_moderator/view_pet";
    }

    @RequestMapping(value = "/lk_user/view_pet", method = RequestMethod.GET)
    public String lkUserViewPetGet(Model model, HttpServletRequest request){

        HttpSession session = request.getSession();
        if(session.getAttribute("idPet")==null)
            if(session.getAttribute("idUser") == null)
                return "redirect:/authorize";
            else
                return "redirect:/user/lk";
        int idPet = (int)session.getAttribute("idPet");
        PetForm form = petService.getPetFormById(idPet);
        model.addAttribute("petForm",form);
        model.addAttribute("ret","user");
        return  "pet_page";
    }

    @RequestMapping(value = "/lk_moderator/edit_pet", method = RequestMethod.POST)
    public String lkModeratorEditPetPost(Model model, HttpServletRequest request,
                                        @ModelAttribute("idPet") int idPet){
        HttpSession session = request.getSession();
        if(session.getAttribute("idModerator") == null)
            return "redirect:/authorize";
        session.setAttribute("idPet", idPet);
        return  "redirect:/pet/lk_moderator/edit_pet";
    }

    @RequestMapping(value = "/lk_moderator/edit_pet", method = RequestMethod.GET)
    public String lkModeratorEditPetGet(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("idPet")==null)
            if(session.getAttribute("idModerator") == null)
                return "redirect:/authorize";
            else
                return "redirect:/pet/lk_moderator/edit_pet";

        int idPet = (int)session.getAttribute("idPet");
        PetForm form = petService.getPetFormById(idPet);

        model.addAttribute("petForm",form);

        PetEditForm formEdit;
        if(session.getAttribute("petFormEdit")==null){
            formEdit = new PetEditForm();
            session.setAttribute("petFormEdit",formEdit);
        }else
            formEdit = (PetEditForm)session.getAttribute("petFormEdit");
        model.addAttribute(formEdit);
        return  "pet_edit_moderator_page";
    }

    @RequestMapping(value = "/lk_moderator/edit_pet/working", method = RequestMethod.POST)
    public String lkModeratorEditPetWorkingPost(Model model, HttpServletRequest request,
                                                @ModelAttribute("petFormEdit") PetEditForm formEdit){
        HttpSession session = request.getSession();
        if(session.getAttribute("idPet")==null)
            if(session.getAttribute("idModerator") == null)
                return "redirect:/authorize";
            else
                return "redirect:/pet/lk_moderator/edit_pet";

        session.setAttribute("petFormEdit",formEdit);

        int idPet = (int) session.getAttribute("idPet");
        int idModer = (int) session.getAttribute("idModerator");
        petService.updateNoPublicPetForModerator(formEdit,idPet, idModer);

        return "redirect:/pet/lk_moderator/edit_pet";
    }



    @RequestMapping(value = "/find_pets/more/return", method = RequestMethod.GET)
    public String findPetsMoreReturnGet(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("idPet",null);
        session.setAttribute("ret",null);
        return "redirect:/pet/find_pets";
    }

    @RequestMapping(value = "/find_pets/return", method = RequestMethod.GET)
    public String findPetsReturnGet(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("find",null);
        session.setAttribute("findPetForm",null);
        session.setAttribute("resultFindPets",null);
        return "redirect:/";
    }

    @RequestMapping(value = "/lk_user/view/return", method = RequestMethod.GET)
    public String lkUserReturnGet(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("idPet",null);
        session.setAttribute("ret",null);
        return "redirect:/user/lk";
    }


    //во время или после создания новой анкеты
    @RequestMapping(value = "/lk_user/new_pet/return", method = RequestMethod.GET)
    public String LkUserNewPetReturnGetGet(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("idPet",null);
        session.setAttribute("newPet",null);
        session.setAttribute("update", null);
        return "redirect:/user/lk";
    }

    @RequestMapping(value = "/lk_moderator/view/return", method = RequestMethod.GET)
    public String lkModeratorViewReturnGet(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("newPet",null);

        return "redirect:/moderator/lk";
    }

    @RequestMapping(value = "/lk_moderator/edit/return", method = RequestMethod.GET)
    public String lkModeratorEditReturnGet(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("idPet",null);
        session.setAttribute("petFormEdit",null);
        return "redirect:/moderator/lk";
    }

    private void initModelList(Model model) {
        Map<String,List<ParamPet>> params = petService.getAllParamsPet();
        for (Map.Entry<String, List<ParamPet>> entry : params.entrySet()) {
            model.addAttribute(entry.getKey(),entry.getValue());
        }
    }

}
