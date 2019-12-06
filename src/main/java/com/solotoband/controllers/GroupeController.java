package com.solotoband.controllers;



import java.util.List;
import javax.validation.Valid;

import com.solotoband.entity.*;
import com.solotoband.repository.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GroupeController {
    GroupeRepository groupeRepository = new GroupeRepository();
    AnnonceRepository annonceRepository = new AnnonceRepository();
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

        if (groupeRepository.createGroup(groupe)) {

            return "redirect:/groupe/" + groupe.getId();
        }
        return "erreur";
    }

    /**
     * Contrôleur qui prend en paramètre l'ID du groupe récement crée
     * @param groupeId
     */
    @GetMapping("/groupe/{groupeId}")
    public String annonce(@PathVariable long groupeId, Model model) {

        // création d'un groupe à partir de l'id récupéré dans l'url
        Groupe groupe = groupeRepository.findGroupeById(groupeId);
        //vérifier que le groupe existe.
        model.addAttribute("groupe", groupe);

        // Chargement et création d'une annonce 
        Annonce annonce = new Annonce();
        model.addAttribute("annonce", annonce);

        //appel de la méthode me permettant de récuperer la liste des instruments le <select>
        List<Instrument> instruments = depot.findAll();
        if (instruments == null) {
            return "erreur";
        }
        model.addAttribute("instruments", instruments);

        // Déclaration et ajout du model pour ajouter un instrument
        Instrument instrument = new Instrument();
        model.addAttribute("instrument", instrument);
        Style style = new Style();
        model.addAttribute("style", style);

        //appel de la méthode me permettant de récuperer la liste des départements le >select>
        List<Departement> departements = depotDepartements.findAll();
        if (departements == null) {
            return "erreur";
        }
        model.addAttribute("departements", departements);

        //appel de la méthode me permettant de récuperer la liste des styles musicaux le >select>
        StyleRepository depotStyle = new StyleRepository();
        List<Style> styles = depotStyle.findAll();
        if (styles == null) {
            return "erreur";

        }
        model.addAttribute("styles", styles);

        return "annonce";
    }
   
   
    @PostMapping("/instrument/{groupeId}")
    public String postInstrument(@ModelAttribute @Valid Instrument instrument, 
                                BindingResult bindingResult, Model model,
                                @PathVariable long groupeId)
    {
        if (bindingResult.hasErrors())
        {
            return "redirect:/groupe/"+groupeId;
        }

        if (depot.createInstrument(instrument)){

            return "redirect:/groupe/"+groupeId;
        }
        return "erreur";
    }

    @PostMapping("/style/{groupeId}")
    public String postInstrument(@ModelAttribute @Valid Style style, 
                                BindingResult bindingResult, Model model,
                                @PathVariable long groupeId)
    {
        if (bindingResult.hasErrors())
        {
            return "redirect:/groupe/"+groupeId;
        }

        if (depotStyle.createStyle(style)){

            return "redirect:/groupe/"+groupeId;
        }
        return "erreur";
    }
    @PostMapping("/annonce/{groupeId}")
    public String postAnnonce(@ModelAttribute @Valid Annonce annonce, 
                                @PathVariable long groupeId,  
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
        {
            return "erreur";
        }
            annonce.setIdGroupe(groupeId);
        if (annonceRepository.createAnnonce(annonce)){

            return "redirect:/annonceOk/"+groupeId;
        }
        return "erreur";
    }

    @GetMapping("/annonceOk/{groupeId}")
    public String annonceOk(@PathVariable long groupeId) {
        
        return "annonceOk";
    }

    @PostMapping("/musicien/resultats")
    public String annonce(Model model, @ModelAttribute Annonce createdAnnonce) {
        List<Annonce> annonceList = resultRepo.getAnnonceByQuery(createdAnnonce.getIdInstrument(),
                createdAnnonce.getIdStyle(), createdAnnonce.getIdDepartement(), createdAnnonce.getLevel());
        model.addAttribute("annonceList", annonceList);
        return "resultats";
    }
}

