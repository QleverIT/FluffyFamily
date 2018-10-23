package system.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import system.model.form.AdminLkForm;
import system.model.form.LoginForm;
import system.model.form.ModeratorLkForm;
import system.service.AdminService;
import system.service.ModeratorService;
import system.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/authorize")
public class AuthorizeController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModeratorService moderatorService;
    @Autowired
    private AdminService adminService;

    @RequestMapping(method = RequestMethod.GET)
    public String inputLoginGet(Model model, @ModelAttribute("errorMessage") String errorMessage,
                                HttpServletRequest request){

        HttpSession session = request.getSession();

        LoginForm loginForm = new LoginForm();

        if(session.getAttribute("loginForm")!=null)
            loginForm = (LoginForm)session.getAttribute("loginForm");
        else session.setAttribute("loginForm",loginForm);

        model.addAttribute("loginForm", loginForm);
        return "login_page";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String inputLoginPost(@ModelAttribute("loginForm") @Valid LoginForm loginForm, BindingResult result,
    Model model, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("loginForm",loginForm);

        //если пустые поля
        boolean error = result.hasErrors();
        if (error) return "login_page";

        String login = loginForm.getLogin();
        String password = loginForm.getPassword();

        Map data = new HashMap<String,String>();
        data.put(LoginForm.LOGIN,login);
        data.put(LoginForm.PASSWORD,password);

        String errorMessage = "";

        boolean loginOk = true;

        //ищем по логину пользователя, модератора, администратора
        boolean findeUser = userService.findUserByLogin(login);
        boolean findeModerator = moderatorService.findModeratorByLogin(login);
        boolean findeAdmin = adminService.findAdminByLogin(login);

        //если зарегестрирован
        boolean reg = true;
        //если пароль введен верно
        boolean aut = true;

        if(!findeUser && !findeModerator && !findeAdmin){
            errorMessage = "Логин не найден.";
            reg = false;
        } else {
            boolean autUser = false;
            boolean autModerator = false;
            boolean autAdmin = false;

            if(findeUser) autUser = userService.authorizeUser(login, password);
            else if(findeModerator) autModerator = moderatorService.authorizeModerator(login, password);
            else if(findeAdmin) autAdmin = adminService.authorizeAdmin(login, password);

            //если пароль введен не верно
            if(!(autUser || autModerator || autAdmin)){
                aut = false;
                errorMessage = "Пароль введен неверно.";
            }
        }

        if(!reg || !aut){
            redirectAttributes.addFlashAttribute("errorMessage",errorMessage);
            return "redirect:/authorize";
        }

        session.setAttribute("loginForm",null);

        if(findeUser){
            int idUser = userService.getIdUserByLogin(login);
            session.setAttribute("idUser",idUser);
            return "redirect:/user/lk";
        }else if(findeModerator){
            int idModerator = moderatorService.getIdModeratorByLogin(login);
            session.setAttribute("idModerator",idModerator);
            return "redirect:/moderator/lk";
        }else if(findeAdmin){
            session.setAttribute("login",login);
            session.setAttribute("password",password);
            return "redirect:/admin/lk";
        }
        return "login_page";
    }

    @RequestMapping(value = "/return", method = RequestMethod.GET)
    public String returnGet(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("loginForm") != null)
            session.setAttribute("loginForm", null);
        return "redirect:/";
    }
}

