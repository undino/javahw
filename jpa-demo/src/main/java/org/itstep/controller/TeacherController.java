package org.itstep.controller;

import lombok.extern.slf4j.Slf4j;
import org.itstep.dto.GroupDto;
import org.itstep.dto.TeacherDto;
import org.itstep.service.AcademyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(TeacherController.BASE_URL)
public class TeacherController {

    public static final String BASE_URL = "/teachers";
    public static final String REDIRECT_INDEX = "redirect:" + BASE_URL;
    public static final String VIEW_PATH = "teacher";
    public static final String FORM_PATH = VIEW_PATH + "/form";
    public static final String INDEX_PATH = VIEW_PATH + "/index";

    final AcademyService academyService;

    @Autowired
    public TeacherController(AcademyService academyService) {
        this.academyService = academyService;
    }

    @ModelAttribute("groupsDto")
    public List<GroupDto> getGroupsDto() {
        return academyService.findGroupsDto(0, (int) academyService.countGroups());
    }

    @GetMapping
    public String index(Model model,
                        @RequestParam(defaultValue = "1") int page,
                        @RequestParam(defaultValue = "5") int size) {
        log.info("index()");
        model.addAttribute("teacherPage", Math.ceil((double) academyService.countTeacher() / (double) size));
        model.addAttribute("teachersDto", academyService.findAllTeachers(page - 1, size));
        return INDEX_PATH;
    }

    @GetMapping("/create")
    public String create(Model model) {
        log.info("create()");
        model.addAttribute("teacherDto", new TeacherDto());
        return FORM_PATH;
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute TeacherDto teacherDto,
                         BindingResult bindingResult) {
        log.debug("Create teacher: " + teacherDto.toString());
        if (!bindingResult.hasErrors()) {
            academyService.save(teacherDto);
            log.debug("Teacher saved");
            return REDIRECT_INDEX;
        }
        log.error(bindingResult.toString());
        return FORM_PATH;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,
                         RedirectAttributes redirectAttributes) {
        String message = "OK";
        if (!academyService.deleteTeacher(id)) {
            message = "Error deleting teacher by id";
        }
        redirectAttributes.addAttribute("message", message);
        return REDIRECT_INDEX;
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        String url;
        try {
            model.addAttribute("teacherDto", academyService.getTeacherDto(id));
            url = FORM_PATH;
        } catch (Exception ex) {
            url = REDIRECT_INDEX;
        }
        return url;
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id,
                       @Validated @ModelAttribute TeacherDto teacherDto,
                       BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            academyService.update(teacherDto);
            return REDIRECT_INDEX;
        }
        return FORM_PATH;
    }
}
