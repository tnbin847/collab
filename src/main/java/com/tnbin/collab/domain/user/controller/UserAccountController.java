package com.tnbin.collab.domain.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 박 수 빈
 * @version 1.0
 */

@RestController
public class UserAccountController {

    /**
     * 로그인 페이지(인덱스 페이지) 호출
     */
    @GetMapping("/")
    public ModelAndView login() {
        return new ModelAndView("collab/index");
    }

    /**
     * 회원가입 페이지 호출
     */
    @GetMapping("/membership/sign-up")
    public ModelAndView signup() {
        return new ModelAndView("collab/user/signup");
    }

    /**
     * 아이디 찾기 페이지 호출
     */
    @GetMapping("/membership/find-id")
    public ModelAndView findId() {
        return new ModelAndView("collab/user/find_id");
    }

    /**
     * 비밀번호 찾기 페이지 호출
     */
    @GetMapping("/membership/find-pwd")
    public ModelAndView findPwd() {
        return new ModelAndView("collab/user/find_pwd");
    }
}
