package org.sid.web;

import org.sid.Entities.Bar;
import org.sid.Entities.Beer;
import org.sid.Entities.Personne;
import org.sid.services.BarServiceInterface;
import org.sid.services.BeerServiceInterface;
import org.sid.services.PersonneInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PersonneController {
    @Autowired
    private PersonneInterface personneMetier;
    @Autowired
    private BarServiceInterface barMetier;
    @Autowired
    private BeerServiceInterface beerMetier;


    @RequestMapping("/operationClient")
    public String index(Model model){
        Personne per = personneMetier.chercherPersonneId(Long.parseLong(String.valueOf(1)));
        model.addAttribute("listBar",per.getBarsPreferes());
        return "client";
    }


    @RequestMapping("/chercherBarNomP")
    public String ChercherBarNomP(Model model, String nomBar){
        Personne per = personneMetier.chercherPersonneId(Long.parseLong(String.valueOf(1)));
        //model.addAttribute("listBar",per.getBarsPreferes());
        Bar bar = barMetier.chercherBarNom(nomBar);

        List<Beer> lbe =barMetier.ListerBeerBar(bar);

        model.addAttribute("foundBarBeer", lbe);

        return "client";
    }

    @RequestMapping(value="/chercherBarBeerNom", method=RequestMethod.GET)
    public String ChercherBarBeerNom(Model model, String nomBeer){

        Personne per = personneMetier.chercherPersonneId(Long.parseLong(String.valueOf(1)));
        model.addAttribute("listBar",per.getBarsPreferes());

        List<Bar> lbarN = beerMetier.trouverBarBeerNom(nomBeer);
        for(int i=0 ; i < lbarN.size() ; i++){
            System.out.println(lbarN.get(i).toString());
        }
        model.addAttribute("foundBarNomBeer",lbarN);

        return "client";
    }

    @RequestMapping(value="/chercherBarBeerType" , method= RequestMethod.GET)
    public String ChercherBarBeerType(Model model, String typeBeer){

        Personne per = personneMetier.chercherPersonneId(Long.parseLong(String.valueOf(1)));
        model.addAttribute("listBar",per.getBarsPreferes());

        List<Bar> lbar = beerMetier.trouverBarBeerType(typeBeer);

        model.addAttribute("foundBarsTypeBeer",lbar);


        return "client";
    }

    /*@RequestMapping(value="/ajouterBarPrefere", method = RequestMethod.POST)
    public String AjouterAMesBarPref(Model model,Bar bar){
        Personne person = personneMetier.chercherPersonneId(Long.parseLong(String.valueOf(1)));

        Personne p = personneMetier.ajouterBarPrefere(person , bar);
        model.addAttribute("PersonneBars",bar);
        model.addAttribute("listBars",person.getBarsPreferes());
        return "client";
    }*/

}
