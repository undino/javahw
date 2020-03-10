package org.itstep.controllers;

import lombok.extern.slf4j.Slf4j;
import org.itstep.api.TodoRestApi;
import org.itstep.models.ToDoForAdd;
import org.itstep.models.UserTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/")
public class HomePageController {
    public static final Logger log = LoggerFactory.getLogger(HomePageController.class);
    @Autowired
    TodoRestApi todoRestApi;
    @Autowired
    UserTask userTask;

    @GetMapping
    public String showHomePage(Model model) {

        log.debug("Into controller`s method: 'showHomePage'");
        userTask = todoRestApi.getUserTask();
        model.addAttribute("model", userTask.getEmbedded());
        log.debug("Method got" + model.getAttribute("model").getClass().getSimpleName() + " from ./api/todolists ");
        return "index";
    }

    @GetMapping(path = "/delete")
    public String deleteTodo(@RequestParam String url) {
        log.debug("Into controller`s method: 'deleteTodo'");
        todoRestApi.delete(url);
        log.debug("Method deleted model from ./api/todolists/delete ");
        return "redirect:/";
    }

    @GetMapping(path = "/create")
    public String createTodo() {
        log.debug("Into controller`s method: GET 'createTodo', end go to Post_create path");
        return "create";
    }

    @PostMapping(path = "/create")
    public String createTodo(ToDoForAdd toDoForAdd, Model messageModel) {
        log.debug("Into controller`s method: POST 'createTodo'");
        boolean b = todoRestApi.createTodo(toDoForAdd);
        log.debug("b has b is: " + b);
        if (b) {
            messageModel.addAttribute("message", "Не получилось создать новое задание");
            return "error";
        }
        return "redirect:/";
    }
}
