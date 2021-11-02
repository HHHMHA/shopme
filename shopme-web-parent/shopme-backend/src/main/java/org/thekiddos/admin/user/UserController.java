package org.thekiddos.admin.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController( UserService userService ) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listAll( Model model ) {
        model.addAttribute( "users", userService.listAll() );
        return "users";
    }
}
