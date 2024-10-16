package com.tnbin.collab.domain.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 박 수 빈
 * @version 1.0
 */

@RestController
public class UserController {

    @GetMapping("/sign-up")
    public ModelAndView signup() {
        return new ModelAndView("app/user/signup");
    }
}
