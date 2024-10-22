package com.tnbin.collab.domain.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 박 수 빈
 * @version 1.0
 */

@RestController
public class AccountController {

    /**
     * 회원가입 페이지 호출
     */
    @GetMapping("/account/sign-up")
    public ModelAndView signup() {
        return new ModelAndView("collab/user/signup");
    }
}
