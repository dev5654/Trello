package uz.pdp.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.pdp.spring_boot.dto.project.ProjectCreateDto;
import uz.pdp.spring_boot.services.project.ProjectService;

@Controller
@RequestMapping("/project/*")
public class ProjectController extends AbstractController<ProjectService> {


    @Autowired
    public ProjectController(ProjectService service) {
        super(service);
    }
    @RequestMapping(value = "project/", method = RequestMethod.GET)
    public String projectPage() {
        return "project/project";
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "create/", method = RequestMethod.GET)
    public String createPage() {
        return "project/create";
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "create/", method = RequestMethod.POST)
    public String create(@ModelAttribute ProjectCreateDto dto) {
        service.create(dto);
        return "redirect:/";
    }



}
