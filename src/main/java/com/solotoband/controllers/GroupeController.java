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
        Groupe groupe = new Groupe();
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
            return "annonce";
        }

        return "erreur";
    }

   /* @GetMapping("/valiation")
    public String groupe(Model model)
    {
        Groupe groupe = new Groupe();
        model.addAttribute("groupe", groupe);
        return "groupe";
    } 

    @PostMapping("/validation")
    public String postGroupe(@Valid Groupe groupe, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
        {
            return "groupe";
        }
       
        if (GroupeRepository.createGroup(groupe)){
            model.addAttribute("groupe", groupe);
            return "annonce";
        }

        return "erreur";
    }

   /* @GetMapping("musicien/resultats")
    public String resultat(Model model, 
                            @RequestParam String instrument, 
                            String musicFlux, 
                            Long departement, 
                            String level) {
        model.addAttribute("groupes", repository.findRequest(instrument, musicFlux, departement, level));
        return "resultats";
    }*/
}