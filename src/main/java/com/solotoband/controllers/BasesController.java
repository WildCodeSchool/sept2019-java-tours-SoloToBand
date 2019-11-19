package com.solotoband.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasesController
{

    @GetMapping("/")
    public String accueil()
    {
        return "index";
    } 

   
}