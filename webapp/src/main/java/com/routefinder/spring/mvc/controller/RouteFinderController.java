package com.routefinder.spring.mvc.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by karpukdm on 01.04.16.
 */
@org.springframework.stereotype.Controller
public class RouteFinderController {
    @RequestMapping(value = "/main", method = RequestMethod.GET)
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

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().
                getAuthentication();
        String name = authentication.getName();
        model.addAttribute("username", name);
        model.addAttribute("message", "Welcome to Spring");

        return "profile";
    }
}
