package dk.mebl.controller;

import dk.mebl.BL.IUserRepo;
import dk.mebl.BL.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    IUserRepo userRepo = new UserRepo();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/delete")
    public String deleteUser(){
        return "deleteUser";
    }

    @GetMapping("/changePassword")
    public String changePassword(){
        return "changePassword";
    }
}
