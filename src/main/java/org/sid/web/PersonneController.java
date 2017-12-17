package org.sid.web;

import org.sid.Entities.Bar;
import org.sid.Entities.Personne;
import org.sid.services.BarServiceInterface;
import org.sid.services.BeerServiceInterface;
import org.sid.services.PersonneInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PersonneController {
    @Autowired
    private PersonneInterface personneMetier;
    @Autowired
    private BarServiceInterface BarMetier;
    @Autowired
    private BeerServiceInterface beerMetier;


    @RequestMapping("/operationClient")
    public String index(Model model){
        Personne per = personneMetier.chercherPersonneId(Long.parseLong(String.valueOf(1)));
        model.addAttribute("listBar",per.getBarsPreferes());
        return "client";
    }



    @RequestMapping("/chercherBarBeerNom")
    public String ChercherBarBeerNom(Model model, String nomBeer){

        Personne per = personneMetier.chercherPersonneId(Long.parseLong(String.valueOf(1)));
        model.addAttribute("listBar",per.getBarsPreferes());

        List<Bar> lbar = beerMetier.trouverBarBeerNom(nomBeer);
        model.addAttribute("foundBarsNomBeer",lbar);

        return "client";
    }

    @RequestMapping("/chercherBarBeerType")
    public String ChercherBarBeerType(Model model, String typeBeer){

        Personne per = personneMetier.chercherPersonneId(Long.parseLong(String.valueOf(1)));
        model.addAttribute("listBar",per.getBarsPreferes());

        List<Bar> lbar = beerMetier.trouverBarBeerType(typeBeer);
        model.addAttribute("foundBarsTypeBeer",lbar);


        return "client";
    }


    public String AjouterAMesBarPref(Model model,Bar bar){

        return "client";
    }

}
