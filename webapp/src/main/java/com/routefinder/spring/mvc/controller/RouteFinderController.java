package com.routefinder.spring.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by karpukdm on 01.04.16.
 */
@org.springframework.stereotype.Controller
public class RouteFinderController {
    @RequestMapping("/main")
    public String main(Model model) {

        return "main";
    }

    @RequestMapping("/profile")
    public String profile(Model model) {

        return "profile";
    }

    @RequestMapping("/signup")
    public String registrate(Model model) {

        return "registration";
    }

    @RequestMapping("/login")
    public String login(Model model) {

        return "registration";
    }
}
