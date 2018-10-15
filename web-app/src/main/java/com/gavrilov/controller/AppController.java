package com.gavrilov.controller;

import com.gavrilov.model.User;
import com.gavrilov.model.dto.UserDTO;
import com.gavrilov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authManager;

    @RequestMapping(value = {"/", "/authorization"}, method = RequestMethod.GET)
    public String authorization(ModelMap modelMap) {
        modelMap.addAttribute("user", new UserDTO());
        return "authorization";
    }

    @RequestMapping(value = "/login-user", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult result, ModelMap model) {

        Authentication request = new UsernamePasswordAuthenticationToken(userDTO.getLogin(), userDTO.getPassword());
        Authentication resultt = authManager.authenticate(request);
        SecurityContextHolder.getContext().setAuthentication(resultt);

        if (result.hasErrors()) {
            return "error";
        }

        return "noteList";
    }
}
