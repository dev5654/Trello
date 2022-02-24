package uz.pdp.spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : Oyatjon  -> @data :2/24/2022 10:18
 */

@Controller
@RequestMapping("/panel/*")
public class PanelController {

    @RequestMapping(value = "superAdmin/", method = RequestMethod.GET)
    public String orgPage(Model model) {
        return "panel/superAdmin";
    }
}
