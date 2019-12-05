package com.solotoband.controllers;

import java.util.List;

import com.solotoband.entity.Annonce;
import com.solotoband.entity.Departement;
import com.solotoband.entity.Instrument;
import com.solotoband.entity.Style;
import com.solotoband.repository.DepartementRepository;
import com.solotoband.repository.InstrumentRepository;
import com.solotoband.repository.StyleRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MusicienController {

    @GetMapping("/musicien")
    public String musicien(Model model) {
        // recupération de la liste des instruments dans la base
        InstrumentRepository depot = new InstrumentRepository();
        List<Instrument> instruments = depot.findAll();
        if (instruments == null) {
            return "erreur";
        }
        model.addAttribute("instruments", instruments);

        // recupération de la liste des départements de la base
        DepartementRepository depotDepartements = new DepartementRepository();
        List<Departement> departements = depotDepartements.findAll();
        if (departements == null) {
            return "erreur";
        }
        model.addAttribute("departements", departements);

        // recupération de la list des courant musicaux
        StyleRepository depotStyle = new StyleRepository();
        List<Style> styles = depotStyle.findAll();
        if (styles == null) {
            return "erreur";

        }
        model.addAttribute("styles", styles);
        model.addAttribute("createdAnnonce", new Annonce());
        return "musicien";

    }

    @GetMapping("musicien/result")
    public String resultat() {
        return "result";
    }
}