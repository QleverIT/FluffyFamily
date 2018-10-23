package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.DAO.implementDAO.AdminDAO;
import system.model.Admin;
import system.model.Moderator;
import system.model.form.AdminLkForm;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminDAO adminDAO;
    @Autowired
    private ModeratorService moderatorService;

    public AdminService(){}

    //для авторизации / for authorize
    public boolean findAdminByLogin(String login) {
        Admin admin = adminDAO.getAdmin();
        String adminLogin = admin.getLogin();
        return login.equals(adminLogin);
    }

    public boolean authorizeAdmin(String login, String password){
        Admin admin = adminDAO.getAdmin();
        String adminLogin = admin.getLogin();
        String adminPassword = admin.getPassword();
        return login.equals(adminLogin) && password.equals(adminPassword);
    }

    public AdminLkForm getAdminLkForm(){
        AdminLkForm adminLkForm =  new AdminLkForm();

        List<Moderator> moderators = moderatorService.getAllModerators();
        adminLkForm.setModetators(moderators);

        return  adminLkForm;
    }

    public boolean checkAdmin(HttpSession session){
        if(session.getAttribute("login") == null
                && session.getAttribute("password")==null)
            return false;

        String login = (String) session.getAttribute("login");
        String password = (String) session.getAttribute("password");

        return authorizeAdmin(login,password);
    }
}
