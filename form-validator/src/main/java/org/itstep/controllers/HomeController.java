package org.itstep.controllers;

import org.itstep.dao.UserDao;
import org.itstep.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class HomeController {
    public final static Logger logger = LoggerFactory.getLogger(HomeController.class);

    Validator passwordValidator;
    UserDao userDao;

    @Autowired
    HomeController(UserDao userDao, Validator passwordValidator) {
        this.userDao = userDao;
        this.passwordValidator = passwordValidator;
    }

    @ModelAttribute(name = "user")
    public User getUser() {
        return new User();
    }

    @GetMapping
    public String homePage() {
        return "index";
    }

    @PostMapping(path = "/create")
    public String createUser(@Validated @ModelAttribute User user, BindingResult bindingResult) {
        passwordValidator.validate(user, bindingResult);
        logger.info("In to user= {}", user);
        if (bindingResult.hasErrors()) {
            return "index";
        } else {
            try {
                userDao.save(user);
            } catch (Exception ex) {
                logger.info(ex.toString());
            }
        }
        return "redirect:/";
    }
}
