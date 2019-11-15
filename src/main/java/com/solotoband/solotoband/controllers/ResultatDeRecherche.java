package com.solotoband.solotoband.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResultatDeRecherche {

    @GetMapping("/resultat-de-recherche")
    public String resultat() {
        return "resultat-de-recherche";
    }
}