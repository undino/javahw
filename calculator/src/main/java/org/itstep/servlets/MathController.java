package org.itstep.servlets;

import org.itstep.entity.MathOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MathController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(Model model, @RequestParam(defaultValue = "0") double a, @RequestParam(defaultValue = "0") double b, @RequestParam(defaultValue = "+") char op) {
        System.out.println("a: " + a + "\nb: " + b + "\nop: " + op);
        model.addAttribute("result", MathOperation.execute(a, b, op));
        model.addAttribute("task", a + " " + op + " " + b + " = ");
        return "index";
    }


}
