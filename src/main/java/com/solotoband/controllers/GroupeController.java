package com.solotoband.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.solotoband.entity.*;
import com.solotoband.repository.*;

import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class GroupeController
{
    GroupeRepository groupeRepository = new GroupeRepository();
    AnnonceRepository annonceRepository = new AnnonceRepository();
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
            
        if (groupeRepository.createGroup(groupe)){

            return "redirect:/groupe/"+groupe.getId();
        }

        return "erreur";
    }

    /**
     * Contrôleur qui prend en paramètre l'ID du groupe récement crée
     * @param groupeId
     */
    @GetMapping("/groupe/{groupeId}")
    public String annonce(@PathVariable final long groupeId, Model model) {

        // création d'un groupe à partir de l'id récupéré dans l'url
        Groupe groupe = groupeRepository.findGroupeById(groupeId);
        //vérifier que le groupe existe.
        model.addAttribute("groupe", groupe);

        // Chargement et création d'une annonce 
        Annonce annonce = new Annonce();
        model.addAttribute("annonce", annonce);

        //appel de la méthode me permettant de récuperer la liste des instruments le >select>
        List<Instrument> instruments = depot.findAll();
        if (instruments == null) {
            return "erreur";
        }
        model.addAttribute("instruments", instruments);

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


    @PostMapping("/annonce/{groupeId}")
    public String postAnnonce(@ModelAttribute @Valid Annonce annonce,@PathVariable long groupeId,  BindingResult bindingResult, Model model) {
        
        if (bindingResult.hasErrors())
        {
            return "/groupe/{groupeId}";
        }
            annonce.setIdGroupe(groupeId);
        if (annonceRepository.createAnnonce(annonce)){

            return "redirect:/AnnonceOk/"+ groupeId;
        }

        return "erreur";
    }
    
    @RequestMapping(value = "/AnnonceOK/{groupeId}", RequestMethod.GET)
    public String getAnnonceOk(@PathVariable long groupeId, HttpServletRequest request) {
        Groupe groupe = groupeRepository.findGroupeById(groupeId);
        ModelAndView modelAndView = new ModelAndView("default");

        Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
        if (!CollectionUtils.isEmpty(FlashMap)){
            modelAndView.addObject("groupeID", flashMap.get("groupeID"));
        }
        return "/AnnonceOK/";
    }
    @PostMapping("/AnnonceOK/{groupeId}")
    public String postAnnonceOk(@PathVariable long groupeId) {

        return "redirect:/annonce/"+{groupeId};
    }

    

}