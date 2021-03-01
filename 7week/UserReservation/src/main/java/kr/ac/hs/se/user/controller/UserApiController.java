package kr.ac.hs.se.user.controller;

import kr.ac.hs.se.user.model.request.SignupRequest;
import kr.ac.hs.se.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private final UserService userService;

    @PostMapping("/signup")
    public String postUser(@RequestBody SignupRequest request) {
        userService.createUserAndUserRole(request);
        return "success";
    }
}
