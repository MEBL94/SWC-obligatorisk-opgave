package dk.mebl.controller;

import dk.mebl.BL.IUserRepo;
import dk.mebl.BL.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String changePassword(@RequestParam("password") String password, Model model){
        model.addAttribute("password", userRepo.changePassword(password));
        return "changePassword";
    }
}
