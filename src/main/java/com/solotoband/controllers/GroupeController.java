package com.solotoband.controllers;

import java.util.List;
import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;

import com.solotoband.entity.Annonce;
import com.solotoband.entity.Departement;
import com.solotoband.entity.Groupe;
import com.solotoband.entity.Instrument;
import com.solotoband.entity.Style;
import com.solotoband.repository.DepartementRepository;
import com.solotoband.repository.GroupeRepository;
import com.solotoband.repository.InstrumentRepository;
import com.solotoband.repository.StyleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GroupeController
{
    GroupeRepository repository = new GroupeRepository();
    InstrumentRepository depot = new InstrumentRepository();
    StyleRepository depotStyle = new StyleRepository();
    DepartementRepository depotDepartements = new DepartementRepository();

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
            
        if (repository.createGroup(groupe)){

            return "redirect:/groupe/"+groupe.getId();
        }

        return "erreur";
    }

    @GetMapping("/groupe/{groupeId}")
    public String annonce(@PathVariable final long groupeId, Model model) {
        Annonce annonce = new Annonce();
        model.addAttribute("annonce", annonce);
        List<Instrument> instruments = depot.findAll();
        if (instruments == null) {
            return "erreur";
        }
        model.addAttribute("instruments", instruments);

        List<Departement> departements = depotDepartements.findAll();
        if (departements == null) {
            return "erreur";
        }
        model.addAttribute("departements", departements);

        StyleRepository depotStyle = new StyleRepository();
        List<Style> styles = depotStyle.findAll();
        if (styles == null) {
            return "erreur";

        }
        model.addAttribute("styles", styles);



        return "annonce";
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