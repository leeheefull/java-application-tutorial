package kr.ac.hs.se.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    @GetMapping("/loginform")
    public String loginform() {
        return "users/loginform";
    }

    @RequestMapping("/loginerror")
    public String loginerror(@RequestParam("login_error") String loginError) {
        return "users/loginerror";
    }
}
