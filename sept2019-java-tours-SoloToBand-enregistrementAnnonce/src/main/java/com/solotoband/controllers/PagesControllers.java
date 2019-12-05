package com.solotoband.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesControllers {

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/Mentions-Legal")
    public String mentionsLegal(){
        return "mentionsLegal";
    }




}
