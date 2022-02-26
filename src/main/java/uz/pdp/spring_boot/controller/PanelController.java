package uz.pdp.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.services.auth.UserService;
import uz.pdp.spring_boot.services.organization.OrganizationService;

/**
 * @author : Oyatjon  -> @data :2/24/2022 10:18
 */

@Controller
@RequestMapping("/panel/*")
public class PanelController extends AbstractController<UserService> {

    public PanelController(UserService service) {
        super(service);
    }

//    @RequestMapping(value = "superAdmin/", method = RequestMethod.GET)
//    public String orgPage() {
//        return "panel/superAdmin";
//    }

    @RequestMapping(value = "admin/", method = RequestMethod.GET)
    public String projectPage() {
        return "panel/admin";
    }

    @RequestMapping(value = "superAdmin/", method = RequestMethod.GET)
    public String ProfilePage(Model model) {
        model.addAttribute("users", service.getAll(new GenericCriteria()));
        return "panel/superAdmin";
    }
}
