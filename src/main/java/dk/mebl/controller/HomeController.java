package dk.mebl.controller;

import dk.mebl.BL.IUserRepo;
import dk.mebl.BL.UserRepo;
import dk.mebl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    IUserRepo userRepo = new UserRepo();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());
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
    public String changePassword(@RequestParam("id") int id, Model model){
        return "changePassword";
    }
    @PostMapping("/changePassword")
    public String changePassword(@ModelAttribute String password) {
        return "changePassword";
    }
}
