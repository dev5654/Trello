package uz.pdp.spring_boot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homePage(Model model) {
        return "index";
    }

    @PreAuthorize("isAuthenticated()")
    @ResponseBody
    @RequestMapping("/secure")
    private String securedPage() {
        return "<h1>Secured Page </h1>";
    }
}
