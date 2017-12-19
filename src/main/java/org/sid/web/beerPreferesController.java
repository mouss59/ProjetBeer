package org.sid.web;

import org.sid.Entities.Bar;
import org.sid.Entities.Beer;
import org.sid.Entities.Personne;
import org.sid.services.BeerServiceInterface;
import org.sid.services.PersonneInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class beerPreferesController {
    @Autowired
    private PersonneInterface personneMetier;
    @Autowired
    private BeerServiceInterface beerMetier;


    @RequestMapping("/operationBeerPrefere")
    public String index(Model model){
        Personne per = personneMetier.chercherPersonneId(Long.parseLong(String.valueOf(1)));
        model.addAttribute("listBeer",per.getBeersPreferes());
        return "beerprefere";
    }

    @RequestMapping("/chercherBeerNom")
    public String ChercherBierreNom(Model model,String nomBeer){

        Personne per = personneMetier.chercherPersonneId(Long.parseLong(String.valueOf(1)));
        model.addAttribute("listBeer",per.getBeersPreferes());
        Beer beert = beerMetier.ConsulterBeerNom(nomBeer);
        model.addAttribute("foundBeerNomBeer", beert);


        return "beerprefere";
    }


    @RequestMapping("/ajouterBeerPerson")
    public String AjouterBeerPerson(Model model, Beer be){

        Personne per = personneMetier.chercherPersonneId(Long.parseLong(String.valueOf(1)));

        Personne p = personneMetier.ajouterBeerPrefere(per,be);

        model.addAttribute("foundPer",per);
        model.addAttribute("listBeers",per.getBeersPreferes());


        return "beerprefere";
    }



}
