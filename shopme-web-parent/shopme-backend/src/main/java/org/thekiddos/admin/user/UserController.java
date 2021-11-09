package org.thekiddos.admin.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thekiddos.shopmecommon.models.User;

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

    @GetMapping("/users/new")
    public String newUser( Model model ) {
        var user = new User();
        user.setEnabled( true );
        model.addAttribute( "user", user );
        model.addAttribute( "roles", userService.listRoles() );
        return "user_form";
    }

    @PostMapping("users/save")
    public String saveUser( User user, RedirectAttributes redirectAttributes ) {
        userService.save( user );
        redirectAttributes.addFlashAttribute( "message", "User Saved Successfully" );
        return "redirect:/users";
    }
}
