package com.solotoband.controllers;

import com.solotoband.repository.GroupeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GroupeController
{
    private GroupeRepository repository = new GroupeRepository();

    @GetMapping("/groupe")
    public String groupe()
    {
        return "groupe";
    } 

    @PostMapping("/groupe/create")
    public String postGroupe(
        Model model,
        @RequestParam String nameGroupe,
        @RequestParam String contactName,
        @RequestParam Long groupPhone,
        @RequestParam String groupMail,
        @RequestParam String groupInfo,
        @RequestParam String instrument,
        @RequestParam String musicFlux,
        @RequestParam String level,
        @RequestParam Long departement
    ) {
        model.addAttribute("groupe", repository.save(nameGroupe, 
        contactName, groupPhone, groupMail, groupInfo, instrument, 
        musicFlux, level, departement));
        return "annonceOk";
    }
}