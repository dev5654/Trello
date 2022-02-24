package uz.pdp.spring_boot.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import uz.pdp.spring_boot.configs.security.UserDetails;
import uz.pdp.spring_boot.entity.auth.AuthUser;

@Controller
public class HomeController  {

   private   UserDetails userDetails;


    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
//        userDetails.getUser().getRole();
        AuthUser user = UserDetails.getUser();
        if(user.getRole().getCode().equals("SUPER_ADMIN"))return "panel/superAdmin";
        if(user.getRole().getCode().equals("ADMIN"))return "panel/admin";
        if(user.getRole().getCode().equals("MANAGER"))return "panel/manager";
        if(user.getRole().getCode().equals("USER"))return "panel/user";
        return "index";
    }

   /* @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        userDetails.getUser().getRole();
        return "HOME";
    }
*/


    @PreAuthorize("isAuthenticated()")
    @ResponseBody
    @RequestMapping("/secure")
    private String securedPage() {
        return "<h1>Secured Page </h1>";
    }
}
