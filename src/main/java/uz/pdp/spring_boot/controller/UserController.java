package uz.pdp.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.auth.UserCreateDto;
import uz.pdp.spring_boot.dto.auth.UserDto;
import uz.pdp.spring_boot.services.auth.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController extends AbstractController<UserService> {

    @Autowired
    public UserController(UserService service) {
        super(service);
    }

    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    @RequestMapping(value = "/admin/create/{id}", method = RequestMethod.GET)
    public String adminPage(Model model ,@PathVariable String id) {
        model.addAttribute("organization" , id);
        return "admin/create";
    }

/*
    @RequestMapping(value = "/admin/create/", method = RequestMethod.GET)
    public String sAdmin(Model model) {
        model.addAttribute("authRole");
        return "admin/create";
    }*/


    @RequestMapping(value = "/admin/create/{id}", method = RequestMethod.POST)
    public String create(@ModelAttribute UserCreateDto dto) {
//       dto.setOrganizationId(Long.valueOf(id));
        service.create(dto);
        return "redirect:/organization/organizations/";
    }


    @RequestMapping(value = "/superadmin/create/", method = RequestMethod.POST)
    public String superAdminCreate(@ModelAttribute UserCreateDto dto) {
//       dto.setOrganizationId(Long.valueOf(id));
        service.create(dto);
        return "redirect:/superAdmin/lists/";
    }

 /*   @RequestMapping(value = "/admin/list/", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("users", service.getAll(new GenericCriteria()));
        return "admin/list";
    }*/

    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @RequestMapping(value = "/superAdmin/lists/", method = RequestMethod.GET)
    public String superAdminPage(Model model ) {
        List<UserDto> all = service.getAll(new GenericCriteria());
        List<UserDto> superAdminList = new ArrayList<>();
        for (UserDto dto : all) {
            if (dto.getRole().getCode().equals("SUPER_ADMIN")){
                superAdminList.add(dto);
            }
        }
        model.addAttribute("superAdmins" , superAdminList);
        return "superAdmin/list";
}







}

