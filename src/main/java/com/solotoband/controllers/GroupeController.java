package com.solotoband.controllers;

import javax.validation.Valid;

import com.solotoband.entity.Groupe;
import com.solotoband.repository.GroupeRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GroupeController
{
    GroupeRepository repository = new GroupeRepository();
    @GetMapping("/groupe")
    public String groupe(Model model)
    {
        Groupe groupe= new Groupe();
        model.addAttribute("groupe", groupe);
        return "groupe";
    } 

    @PostMapping("/groupe")
    public String postGroupe(@Valid Groupe groupe, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
        {
            return "groupe";
        }
       
        if (GroupeRepository.createGroup(groupe)){
            model.addAttribute("groupe", groupe);
            return "annonceOk";
        }

        return "erreur";
    }
}