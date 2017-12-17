package org.sid.web;

import org.sid.Entities.Bar;
import org.sid.Entities.Beer;
import org.sid.services.BarServiceInterface;
import org.sid.services.BeerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Type;
import java.util.List;

@Controller
public class BarController {
    @Autowired
    private BarServiceInterface barMetier;
    @Autowired
    private BeerServiceInterface beerMetier;

    @RequestMapping("/operationBar")
    public String index(Model model){
        Bar ba = barMetier.chercherBarId(Long.parseLong(String.valueOf(4)) );
        model.addAttribute("listBeers",ba.getBeers());

        return "bar";
    }


    @RequestMapping("/chercherBierreNom")
    public String ChercherBierreNom(Model model,String nomBierre){
        Bar ba = barMetier.chercherBarId(Long.parseLong(String.valueOf(4)) );
        model.addAttribute("listBeers",ba.getBeers());

        Beer b1 = beerMetier.ConsulterBeerNom(nomBierre);
        model.addAttribute("foundBeer", b1);


        return "bar";
    }

    @RequestMapping("/chercherBierreType")
    public String ChercherBierreType(Model model, String typeBierre){
        Bar ba = barMetier.chercherBarId(Long.parseLong(String.valueOf(4)) );
        model.addAttribute("listBeers",ba.getBeers());

        List<Beer> lb = beerMetier.ConsulterBeerType(typeBierre);
        model.addAttribute("foundBeers",lb);

        return "bar";
    }





    @RequestMapping("/ajouterBeerBar")
    public String AjouterBeerBar(Model model, Beer be){
        Bar ba = barMetier.chercherBarId(Long.parseLong(String.valueOf(4)) );


        Bar bar = barMetier.ajouterBeerToBar(be,ba);
        model.addAttribute("Bar",bar);
        model.addAttribute("listBeers",bar.getBeers());


        return "bar";
    }




}
