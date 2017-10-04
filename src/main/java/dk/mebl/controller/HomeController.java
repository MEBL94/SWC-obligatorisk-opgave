package dk.mebl.controller;

import dk.mebl.BL.IUserRepo;
import dk.mebl.BL.UserRepo;
import dk.mebl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
public class HomeController {
    @Autowired
    IUserRepo userRepo = new UserRepo();

    private static Logger logger = Logger.getLogger(HomeController.class.getName());

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model){
        user = userRepo.login(user.getUsername(), user.getPassword());
        model.addAttribute("error", true);
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
        model.addAttribute("user", userRepo.readUser(id));
        return "changePassword";
    }
    @PostMapping("/changePassword")
    public String changePassword(@ModelAttribute User user, Model model) {
        if ((userRepo.changePassword(user.getId(), user.getPassword()) != null)) {
            return "userPage";
        }
        model.addAttribute("error", true);
        return "changePassword";
    }
}
