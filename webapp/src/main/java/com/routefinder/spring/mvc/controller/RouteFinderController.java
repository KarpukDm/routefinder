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

    @RequestMapping("/home")
    public String home(Model model) {

        return "home";
    }

    @RequestMapping("/profile")
    public String profile(Model model) {

        return "profile";
    }

    @RequestMapping("/signup")
    public String registrate(Model model) {

        return "registration";
    }

    @RequestMapping("/favorites")
    public String favorites(Model model) {

        return "favorites";
    }

    @RequestMapping("/myroutes")
    public String myroutes(Model model) {

        return "my-routes";
    }

    @RequestMapping("/reminders")
    public String reminders(Model model) {

        return "my-reminders";
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

    @RequestMapping("/comments")
    public String comments(Model model) {

        return "my-comments";
    }

    @RequestMapping("/marks")
    public String marks(Model model) {

        return "marks";
    }

    @RequestMapping("/admin")
    public String admin(Model model) {

        return "admin";
    }

    @RequestMapping("/help")
    public String help(Model model) {

        return "help";
    }

    @RequestMapping("/settings")
    public String settings(Model model) {

        return "settings";
    }

    @RequestMapping("/createroute")
    public String createroute(Model model) {

        return "creating-route";
    }

    @RequestMapping("/search")
    public String search(Model model) {

        return "search";
    }
}
