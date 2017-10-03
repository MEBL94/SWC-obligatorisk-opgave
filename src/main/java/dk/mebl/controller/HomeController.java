package dk.mebl.controller;

import dk.mebl.BL.IUserRepo;
import dk.mebl.BL.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class HomeController {
    @Autowired
    IUserRepo userRepo = new UserRepo();
}
