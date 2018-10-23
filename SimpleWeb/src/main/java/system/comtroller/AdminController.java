package system.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import system.model.Moderator;
import system.model.form.AdminLkForm;
import system.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/lk", method = RequestMethod.GET)
    public String lkGet(Model model, HttpServletRequest request){

        if(!adminService.checkAdmin(request.getSession()))
            return "redirect:/authorize";

        AdminLkForm lkForm = adminService.getAdminLkForm();
        model.addAttribute("lkForm",lkForm);
        return "adminLk_page";
    }

    @RequestMapping(value = "/lk/new_moderator", method = RequestMethod.GET)
    public String lkGet(HttpServletRequest request){

        if (!adminService.checkAdmin(request.getSession()))
            return "redirect:/authorize";

        return "redirect:/moderator/registration";

    }


    @RequestMapping(value = "/lk/return", method = RequestMethod.GET)
    public String lkReturnGet(HttpServletRequest request){

        HttpSession session = request.getSession();
        session.setAttribute("login", null);
        session.setAttribute("password",null);

        return "redirect:/";
    }

    @RequestMapping(value = "/lk/moderator_view", method = RequestMethod.POST)
    public String lkModeratorUpdate(HttpServletRequest request,
                                    @ModelAttribute("idModerator") int idModerator){
        if(!adminService.checkAdmin(request.getSession()))
            return "redirect:/authorize";

        HttpSession session = request.getSession();
        session.setAttribute("idModerator",idModerator);
        return "redirect:/moderator/lk_admin/moderator_view";
    }


}
