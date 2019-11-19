package com.solotoband.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GroupeController
{

    @GetMapping("/groupe")
    public String groupe()
    {
        return "groupe";
    } 

   
}