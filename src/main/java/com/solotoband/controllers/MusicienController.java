package com.solotoband.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MusicienController {

    @GetMapping("/musicien")
    public String musicien() {
        return "musicien";
    }

    @GetMapping("musicien/result")
    public String resultat() {
        return "result";
    }
}