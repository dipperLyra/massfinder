package com.abuja_archdiocese.masses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticController {

    @GetMapping({"/", "/home", "/index","/welcome"})
    public String home() {

        return "/index";
    }
}
