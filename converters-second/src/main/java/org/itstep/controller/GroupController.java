package org.itstep.controller;

import org.itstep.model.Groups;
import org.itstep.service.AcademyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/groups")
public class GroupController {

    AcademyService academyService;

    @Autowired
    public GroupController(AcademyService academyService) {
        this.academyService = academyService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("groups", academyService.getGroups());
        return "groups/index";
    }

    @GetMapping(path = "/create")
    public String create(Model model) {
        model.addAttribute("group", new Groups());
        return "groups/form";
    }

    @PostMapping(path = "/create")
    public String create(Groups groups) {
        academyService.saveGroup(groups);
        return "redirect:/groups";
    }

    @GetMapping(path = "/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("group", academyService.getOneGroup(id));
        return "groups/form";
    }

    @PostMapping(path = "/edit/{id}")
    public String edit(@Validated @ModelAttribute Groups groups, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            academyService.updateGroup(groups);
            return "redirect:/groups";
        }
        return "groups/form";
    }

    @GetMapping(path = "/delete/{id}")
    public String delete(@PathVariable int id){
        academyService.deleteGroup(id);
        return "redirect:/groups";
    }

}
