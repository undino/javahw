package org.itstep.controller;

import org.itstep.data.GroupRepository;
import org.itstep.data.StudentRepository;
import org.itstep.model.Group;
import org.itstep.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/students")
@Controller
public class StudentController {

    StudentRepository repository;
    GroupRepository groupRepository;

    @Autowired
    public StudentController(StudentRepository repository, GroupRepository groupRepository) {
        this.repository = repository;
        this.groupRepository = groupRepository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("students", repository.findAll());
        model.addAttribute("groups", groupRepository.findAll());
        return "students/index";
    }

    @Deprecated
    @GetMapping("/new")
    public String createStudent(Model model) {
        model.addAttribute("groups", groupRepository.findAll());
        return "students/index";
    }


    @PostMapping("/new")
    public String createStudent(Student student, RedirectAttributes redirectAttributes) {
        String message = "";
        int id = repository.save(student);
        if (id == 0) {
            message = "some error";
            return "redirect:/students";
        } else {
            message = "successfully saved";
            redirectAttributes.addFlashAttribute("error", message);
//            return "redirect:/students/info/" + id;
            return "redirect:/students";
        }

    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable int id, Model model) {
        model.addAttribute("student", repository.find(id));
        return "students/info";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        repository.delete(repository.find(id));

        return "redirect:/students";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        Student student = repository.find(id);
        System.out.println(student);
        model.addAttribute("student", student);
        List<Group> list = groupRepository.findAll();
        model.addAttribute("groups", list);
        System.out.println(list);
        return "students/update";
    }

    @PostMapping("/update/{id}")
    public String update(Student student) {
        System.out.println("new student =\n" + student);
        repository.update(student);
        return "redirect:/students";
    }

}
