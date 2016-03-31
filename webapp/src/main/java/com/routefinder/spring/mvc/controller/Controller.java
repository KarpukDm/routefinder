package com.routefinder.spring.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by karpukdm on 01.04.16.
 */
@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/main")
    public String main(Model model) {

        model.addAttribute("message", "Hi, user");

        return "main";
    }

    @RequestMapping("/profile")
    public String profile(Model model) {

        model.addAttribute("message", "Hi, user");

        return "profile";
    }
}
