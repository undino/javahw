package org.itstep.controllers;

import org.itstep.api.UserRestApi;
import org.itstep.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller()
@RequestMapping(path = "/")
public class StartController {

    private final UserRestApi restApi;

    @Autowired
    public StartController(UserRestApi restApi) {
        this.restApi = restApi;
    }

    @GetMapping
    public String showStartPage(Model model){
        System.out.println("in start controller");
        Page page = restApi.getAllUsers();
        model.addAttribute("pageData", page.getData());
        return "index";
    }


}
