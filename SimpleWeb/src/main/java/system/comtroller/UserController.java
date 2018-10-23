package system.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import system.model.ParamPet;
import system.model.Pet;
import system.model.User;
import system.model.form.UserFindForm;
import system.model.form.UserLkForm;
import system.service.AdminService;
import system.service.ModeratorService;
import system.service.PetService;
import system.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationGet(Model model, @ModelAttribute("errorMessages") HashMap<String,String> errorMessages,
                                  HttpServletRequest request){
        User newUser = new User();
        HttpSession session = request.getSession();

        if(session.getAttribute("newUser") != null)
            newUser = (User) session.getAttribute("newUser");

        model.addAttribute("newUser", newUser);

        //для передачи всех сообщений об ошибках в представление по параметру
        for (Map.Entry<String, String> entry : errorMessages.entrySet()) {
            model.addAttribute(entry.getKey(),entry.getValue());
        }

        return "user_registration_page";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationPost(@ModelAttribute("newUser") @Valid User newUser,
                                   BindingResult result,  RedirectAttributes redirectAttributes,
                                   HttpServletRequest request) {
        boolean error = result.hasErrors();
        if (error) return "user_registration_page";

        //
        String login = newUser.getLogin();
        String email = newUser.getEmail();

        Map errorMessages = userService.getErrorLoginEmailUser(login, email);

        if(errorMessages!=null){
            request.getSession().setAttribute("newUser",newUser);

            redirectAttributes.addFlashAttribute("errorMessages",errorMessages);
            return "redirect:/user/registration";
        }

        userService.insertUser(newUser);
        newUser = userService.getUserByLogin(newUser.getLogin());
        request.getSession().setAttribute("newUser",newUser);
        return "redirect:/user/registration/valid";
       // return "user_successfully_registered_page";//запрос для успешной (отобразить логин + проль и просьбоу авторизироваться)
    }

    @RequestMapping(value = "/registration/valid", method = RequestMethod.GET)
    public String validGet(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
            User newUser = (User)  request.getSession().getAttribute("newUser");
            model.addAttribute("newUser", newUser);
        return "user_successfully_registered_page";
    }

    @RequestMapping(value = "/lk", method = RequestMethod.GET)
    public String lkGet(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("idUser") == null)
            return "redirect:/authorize";

        int idUser = (int)request.getSession().getAttribute("idUser");

        UserLkForm lkForm = userService.getUserLkFormById(idUser);
        model.addAttribute("lkForm",lkForm);
        return "userLk_page";
    }

    @RequestMapping(value = "/lk/new_pet", method = RequestMethod.GET)
    public String lkNewPetPost(HttpServletRequest request){

        HttpSession session = request.getSession();

        if(session.getAttribute("idUser") == null)
            return "redirect:/authorize";

        return "redirect:/pet/new_pet";
    }

    @RequestMapping(value = "/lk_admin/find_user",method = RequestMethod.GET)
    public String lkAdminFindUserGet(Model model, HttpServletRequest request){

        HttpSession session = request.getSession();
        if(!adminService.checkAdmin(session))
            return "redirect:/authorize";

        if(session.getAttribute("userFindForm")==null){
            session.setAttribute("userFindForm",new UserFindForm());
        }
        UserFindForm form = (UserFindForm) session.getAttribute("userFindForm");
        model.addAttribute("userFindForm",form);
        return "find_user_page";
    }

    @RequestMapping(value = "/lk_admin/find_user",method = RequestMethod.POST)
    public String lkAdminFindUserPost(Model model, HttpServletRequest request,
                                      @ModelAttribute("userFindForm") UserFindForm form){
        HttpSession session = request.getSession();
        session.setAttribute("userFindForm",form);

        User user = userService.getUserByLogin(form.getLogin());
        if(user==null)
            user = userService.getUserByEmail(form.getEmail());
        if(user!= null){
            session.setAttribute("idUser",user.getIdUser());
            session.setAttribute("userFindForm",null);
            return "redirect:/user/lk_admin/user_change";
        }

        return "redirect:/user/lk_admin/find_user";
    }

    @RequestMapping(value = "/lk_admin/user_change", method = RequestMethod.GET)
    public String lkAdminUserChangeGet(Model model, HttpServletRequest request,
                                       @ModelAttribute("errorMessages") HashMap<String,String> errorMessages){
        HttpSession session = request.getSession();
        if(!adminService.checkAdmin(session))
            return "redirect:/authorize";
        if(session.getAttribute("idUser")==null)
            return "redirect:/user/lk_admin/find_user";

        int idUser = (int) session.getAttribute("idUser");
        User user = userService.getUserById(idUser);
        model.addAttribute("user",user);

        //для передачи всех сообщений об ошибках в представление по параметру
        for (Map.Entry<String, String> entry : errorMessages.entrySet()) {
            model.addAttribute(entry.getKey(),entry.getValue());
        }

        return "user_change_page";
    }

    @RequestMapping(value = "/lk_admin/user_change", method = RequestMethod.POST)
    public String lkAdminUserChangePost(Model model, HttpServletRequest request,
                 @ModelAttribute("user") @Valid User user, BindingResult result,
                                        RedirectAttributes redirectAttributes){
        HttpSession session = request.getSession();
        if(!adminService.checkAdmin(session))
            return "redirect:/authorize";
        if(session.getAttribute("idUser")==null)
            return "redirect:/user/lk_admin/find_user";

        boolean error = result.hasErrors();
        if (error) return "user_change_page";

        String login = user.getLogin();
        String email = user.getEmail();

        int idUser = (int) session.getAttribute("idUser");


        Map errorMessages = userService.getErrorLoginEmailUser(login, email, idUser);

        if(errorMessages!=null){
            redirectAttributes.addFlashAttribute("errorMessages",errorMessages);
            return "redirect:/user/lk_admin/user_change";
        }

        user.setIdUser(idUser);
        userService.updateUser(user);

        return "redirect:/user/lk_admin/user_change";
    }

    @RequestMapping(value = "/lk_admin/delete_user", method = RequestMethod.GET)
    public String lkAdminDeleteUserGet(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(!adminService.checkAdmin(session))
            return "redirect:/authorize";
        if(session.getAttribute("idUser")!=null){
            int idUser = (int) session.getAttribute("idUser");
            userService.deleteUser(idUser);
        }
        return "redirect:/user/lk_admin/find_user";
    }

    @RequestMapping(value = "/lk_admin/find_user/return", method = RequestMethod.GET)
    public String lkAdminFindUserReturnGet(HttpServletRequest request){
        HttpSession session = request.getSession();

        if(!adminService.checkAdmin(session))
            return "redirect:/authorize";

        session.setAttribute("idUser",null);
        session.setAttribute("userFindForm",null);
        return "redirect:/admin/lk";
    }

    @RequestMapping(value = "/return", method = RequestMethod.GET)
    public String returnGet(HttpServletRequest request){

        HttpSession session = request.getSession();
        session.setAttribute("newUser", null);

        return "redirect:/";
    }

    @RequestMapping(value = "/lk/return", method = RequestMethod.GET)
    public String lkReturnGet(HttpServletRequest request){

        HttpSession session = request.getSession();
        session.setAttribute("idUser", null);

        return "redirect:/";
    }



}
