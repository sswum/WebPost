package org.minipost.member.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    //나중에 모바일 버전 | PC버전 나누기

    @GetMapping("/join")
    public String join() {
        return "/join";
    }

    @PostMapping("/join")
    public String joinPs() {
        return "/login";

    }
    @GetMapping("/login")
    public String login() {
        return "/login";
    }
}
