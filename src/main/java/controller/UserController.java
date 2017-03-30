package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import services.UserService;

import javax.validation.constraints.NotNull;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/", "/index"})
    public ModelAndView index() {

        return new ModelAndView("index");
    }


    @PostMapping("/signup")
    public View saveUser(@NotNull @RequestBody User user) {
        userService.saveUpdate(user);

        return new RedirectView("/index");
    }

//    @GetMapping(value = "/signup")
//    public Vi
}
