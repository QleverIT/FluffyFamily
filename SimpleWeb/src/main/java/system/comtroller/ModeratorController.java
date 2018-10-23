package system.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import system.helper.ValidateHelper;
import system.model.Moderator;
import system.model.form.ModeratorLkForm;
import system.service.AdminService;
import system.service.ModeratorService;
import system.service.PetService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/moderator")
public class ModeratorController {
    @Autowired
    private ModeratorService moderatorService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private PetService petService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationGet(Model model, @ModelAttribute("errorMessages") HashMap<String,String> errorMessages,
                            @ModelAttribute("moderator") Moderator moderator, HttpServletRequest request){

        if(!adminService.checkAdmin(request.getSession()))
            return "redirect:/authorize";

        model.addAttribute("moderator", moderator);

        //для передачи всех сообщений об ошибках в представление по параметру
        for (Map.Entry<String, String> entry : errorMessages.entrySet()) {
            model.addAttribute(entry.getKey(),entry.getValue());
        }

        return "moderator_registration_page";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationPost(@ModelAttribute("moderator") @Valid Moderator moderator, BindingResult result,
                           Model model, RedirectAttributes redirectAttributes, HttpServletRequest request) {

        if(!adminService.checkAdmin(request.getSession()))
            return "redirect:/authorize";

        //если пустые поля
        boolean error = result.hasErrors();
        if (error) return "moderator_registration_page";

        String email = moderator.getEmail();
        boolean findEmail = moderatorService.findModeratorByEmail(email);

        if(findEmail){
            redirectAttributes.addFlashAttribute("moderator", moderator);

            Map errorMessages = new HashMap<String,String>();
            String errorEmail = ValidateHelper.errorEmailModerator;

            errorMessages.put("errorEmail",errorEmail);
            redirectAttributes.addFlashAttribute("errorMessages",errorMessages);
            return "redirect:/moderator/registration";
        }

        moderatorService.insertModerator(moderator);

        //передать сгенерированные пароль, ник, логин
        moderator = moderatorService.getModeratorByEmail(email);

        request.getSession().setAttribute("newModerator",moderator);
        return "redirect:/moderator/registration/valid";
    }


    @RequestMapping(value = "/registration/valid", method = RequestMethod.GET)
    public String validGet(Model model, HttpServletRequest request){

        if(!adminService.checkAdmin(request.getSession()))
            return "redirect:/authorize";

        Moderator moderator = (Moderator)  request.getSession().getAttribute("newModerator");
        model.addAttribute("moderator", moderator);
        return "moderator_successfully_registered_page";
    }

    @RequestMapping(value = "registration/return", method = RequestMethod.GET)
    public String validPost(Model model, HttpServletRequest request){

        if(!adminService.checkAdmin(request.getSession()))
            return "redirect:/authorize";

        request.getSession().setAttribute("newModerator",null);
        return "redirect:/admin/lk";
    }

    @RequestMapping(value = "/lk",method = RequestMethod.GET)
    public String lkGet(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("idModerator") == null)
            return "redirect:/authorize";

        int idModerator = (int)session.getAttribute("idModerator");

        ModeratorLkForm form = moderatorService.getModeratorLkFormById(idModerator);

        model.addAttribute("lkForm",form);
        return "moderatorLk_page";
    }

    @RequestMapping(value = "/lk/update",method = RequestMethod.POST)
    public String lkGet(Model model, HttpServletRequest request, @ModelAttribute("idPet") int idPet){
        HttpSession session = request.getSession();
        if(session.getAttribute("idModerator") == null)
            return "redirect:/authorize";
        if(idPet==0)
            return "redirect:/moderator/lk";

        String message = petService.getMessageByIdPet(idPet);
        if(message==null || message.equals("")){
            return "redirect:/moderator/lk";
        }else if(message.equals("ok"))
            petService.insertPetPublicById(idPet);
        else moderatorService.updatePet(idPet);
        return "redirect:/moderator/lk";
    }

    @RequestMapping(value = "/lk_admin/moderator_view", method = RequestMethod.GET)
    public String lkAdminModeratorUpdateGet(Model model, HttpServletRequest request){
        if(!adminService.checkAdmin(request.getSession()))
            return "redirect:/authorize";
        HttpSession session = request.getSession();
        if(session.getAttribute("idModerator")==null)
            return "redirect:/moderator/lk_admin/moderator_update/return";

        int idModerator = (int)session.getAttribute("idModerator");
        Moderator moderator = moderatorService.getModeratorById(idModerator);
        model.addAttribute("moderator",moderator);
        return "update_moderator_page";
    }

    @RequestMapping(value = "/lk_admin/moderator_update/return", method = RequestMethod.GET)
    public String lkAdminModeratorUpdateReturnGet(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("idModerator", null);

        return "redirect:/admin/lk";
    }

    @RequestMapping(value = "/lk/return", method = RequestMethod.GET)
    public String lkReturnGet(HttpServletRequest request){

        HttpSession session = request.getSession();
        session.setAttribute("idModerator", null);

        return "redirect:/";
    }
}

