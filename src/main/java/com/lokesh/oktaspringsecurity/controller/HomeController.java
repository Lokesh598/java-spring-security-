package com.lokesh.oktaspringsecurity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
//    @GetMapping("/")
//    public String home(@AuthenticationPrincipal OidcUser user) {
//        return "Welcome, "+ user.getFullName() + "!";
//    }

    @GetMapping("/")
    public ModelAndView homeToAngular(@AuthenticationPrincipal OidcUser user) {
        String fullName = user.getFullName();
        String accessToken = user.getIdToken().getTokenValue();
        ModelAndView modelAndView = new ModelAndView("redirect:http://localhost:4200/Home");
        modelAndView.addObject("fullName", fullName);
//        modelAndView.addObject("accessToken", accessToken);
        return modelAndView;
    }

}
