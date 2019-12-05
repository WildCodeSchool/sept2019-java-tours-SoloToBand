package com.solotoband.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.solotoband.entity.Annonce;
import com.solotoband.entity.Groupe;
import com.solotoband.repository.DepartementRepository;
import com.solotoband.repository.GroupeRepository;
import com.solotoband.repository.InstrumentRepository;
import com.solotoband.repository.ResultatsRepository;
import com.solotoband.repository.StyleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GroupeController {
    GroupeRepository repository = new GroupeRepository();
    InstrumentRepository depot = new InstrumentRepository();
    StyleRepository depotStyle = new StyleRepository();
    ResultatsRepository resultRepo = new ResultatsRepository();
    DepartementRepository depotDepartements = new DepartementRepository();

    @GetMapping("/groupe")
    public String groupe(Model model) {
        Groupe groupe = new Groupe();
        model.addAttribute("groupe", groupe);
        return "groupe";
    }

    @PostMapping("/groupe")
    public String postGroupe(@Valid Groupe groupe, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "groupe";
        }

        if (repository.createGroup(groupe)) {

            return "redirect:/groupe/" + groupe.getId();
        }

        return "erreur";
    }

    @PostMapping("/musicien/resultats")
    public String annonce(Model model, @ModelAttribute Annonce createdAnnonce) {
        System.out.println("instru:" + createdAnnonce.getId_instrument());
        System.out.println("style:" + createdAnnonce.getId_style());
        System.out.println("departement:" + createdAnnonce.getId_departement());
        System.out.println("level:" + createdAnnonce.getLevel());
        List<Annonce> annonceList = resultRepo.getAnnonceByQuery(createdAnnonce.getId_instrument(),
                createdAnnonce.getId_style(), createdAnnonce.getId_departement(), createdAnnonce.getLevel());
        model.addAttribute("annonceList", annonceList);
        return "resultats";
    }
}
