package ru.maveri.potions.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class MainController {




    @RequestMapping
    public String mainUs(){


        return "index";
    }


}
