package org.itstep.controller;

import org.itstep.dto.GroupDto;
import org.itstep.dto.TeacherDto;
import org.itstep.service.AcademyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/teachers")
public class TeacherController {

    final AcademyService academyService;


    @Autowired
    public TeacherController(AcademyService academyService) {
        this.academyService = academyService;
    }

    @ModelAttribute("groups")
    List<GroupDto> groupGroups() {
        return academyService.findGroupsDto();
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("teachers", academyService.getAllTeacherDto());
        return "teacher/index";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("teacherDto", new TeacherDto());
        return "teacher/form";
    }

    @PostMapping(value = "/create")
    public String create(TeacherDto teacherDto){
        academyService.save(teacherDto);
        return "redirect:/teachers";
    }
}
