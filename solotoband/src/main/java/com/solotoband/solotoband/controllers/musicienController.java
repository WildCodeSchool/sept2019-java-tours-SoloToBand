package com.solotoband.solotoband.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class musicienController {

    @GetMapping("/musicien")
    public String home() {
        return "musicien";
    }
}