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

    User savedUser = new User();

    private static Logger logger = Logger.getLogger(HomeController.class.getName());

    private boolean isLoggedIn = false;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        System.out.println(user);
        if (userRepo.login(user.getUsername(), user.getPassword()) != null) {
            userRepo.login(user.getUsername(), user.getPassword());
            savedUser = user;
            isLoggedIn = true;
            return "userPage";
        }
        model.addAttribute("error", true);
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        userRepo.createUser(user);
        System.out.println(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") int id, Model model) {

        if (isLoggedIn) {
            model.addAttribute("user", new User());
            return "deleteUser";
        }
        return "redirect:/";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@ModelAttribute User user) {
        userRepo.deleteUser(user, user.getPassword());
        return "redirect:/";
    }


    @GetMapping("/changePassword")
    public String changePassword(Model model) {
        if (isLoggedIn) {
            model.addAttribute("user", new User());
            model.addAttribute("password", new String());
            return "changePassword";
        }
        return "redirect:/";
    }

    @PostMapping("/changePassword")
    public String changePassword(@ModelAttribute User user, Model model) {
        if (user.getPassword() == savedUser.getPassword()) {
                userRepo.changePassword(savedUser, user.getPassword());
                return "userPage";
            }
            model.addAttribute("error", true);
            return "changePassword";
        }
    }
