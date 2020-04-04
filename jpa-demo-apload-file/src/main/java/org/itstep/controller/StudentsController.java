package org.itstep.controller;

import lombok.extern.slf4j.Slf4j;
import org.itstep.dto.GroupDto;
import org.itstep.dto.StudentDto;
import org.itstep.model.Group;
import org.itstep.model.Student;
import org.itstep.service.AcademyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/students")
public class StudentsController {

    final AcademyService academyService;
    private final Path staticPathToAvatar = Paths.get(System.getProperty("user.dir") + "/src/main/webapp/uploads//");

    @Autowired
    public StudentsController(AcademyService academyService) {
        this.academyService = academyService;

    }

    @ModelAttribute("groups")
    List<GroupDto> getGroups() {
        return academyService.findGroupsDto(0, (int) academyService.countGroups());
    }

    @GetMapping
    public String index(Model model,
                        @RequestParam(defaultValue = "1") int page,
                        @RequestParam(defaultValue = "5") int size) {
        log.info("index()");
        model.addAttribute("studentPage", Math.ceil((double) academyService.countStudents() / (double) size));
        model.addAttribute("students", academyService.findStudentsDto(page - 1, size));
        return "student/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        log.info("create()");
        model.addAttribute("studentDto", new StudentDto());
        return "student/form";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute StudentDto studentDto,
                         BindingResult bindingResult,
                         @RequestParam CommonsMultipartFile img) throws IOException {

        if (!bindingResult.hasErrors()) {
            String fileName = studentDto.getFirstName().hashCode() + "_" + img.getOriginalFilename();

            File fullPathWithAvatar = new File(staticPathToAvatar + "/" + fileName);
            log.info("img.isEmpty = " + img.isEmpty() + " studentDto.getAvatar().isEmpty() " + (studentDto.getAvatar() == null));

            if (img.isEmpty() && studentDto.getAvatar() == null) {
                studentDto.setAvatar("default.jpg");
            } else {
                img.transferTo(fullPathWithAvatar);
                studentDto.setAvatar(fileName);
            }
            academyService.save(studentDto);
            log.debug("Student saved");
            return "redirect:/students";
        }

        log.error(bindingResult.toString());
        return "student/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,
                         RedirectAttributes redirectAttributes) {
        if (academyService.delete(id)) {
            redirectAttributes.addAttribute("message", "OK");
        } else {
            redirectAttributes.addAttribute("message", "Error");
        }
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        String url;
        try {
            StudentDto studentDto = academyService.getStudentDto(id);
            model.addAttribute("studentDto", studentDto);
            url = "student/form";
        } catch (EmptyResultDataAccessException ex) {
            url = "redirect:/students";
        }
        return url;
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id,
                       @Validated @ModelAttribute StudentDto studentDto,
                       BindingResult bindingResult,
                       @RequestParam CommonsMultipartFile img) throws IOException {


        if (!bindingResult.hasErrors()) {
            String fileName = studentDto.getFirstName().hashCode() + "_" + img.getOriginalFilename();

            File fullPathWithAvatar = new File(staticPathToAvatar + "/" + fileName);
            log.info("img.isEmpty = " + img.isEmpty() + " studentDto.getAvatar().isEmpty() " + (studentDto.getAvatar() == null));

            if (img.isEmpty() && studentDto.getAvatar() == null)
                studentDto.setAvatar("default.jpg");
            else {
                img.transferTo(fullPathWithAvatar);
                studentDto.setAvatar(fileName);
            }
            academyService.update(studentDto);
            return "redirect:/students";
        }
        return "student/form";
    }

}
