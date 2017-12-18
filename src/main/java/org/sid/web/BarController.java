package org.sid.web;

import org.sid.Entities.Bar;
import org.sid.Entities.Beer;
import org.sid.Entities.Personne;
import org.sid.services.BarServiceInterface;
import org.sid.services.BeerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Type;
import java.util.List;

@Controller
public class BarController {
    @Autowired
    private BarServiceInterface barMetier;
    @Autowired
    private BeerServiceInterface beerMetier;

    @RequestMapping(value="/operationBar")
    public String index(Model model){
        Bar ba = barMetier.chercherBarNom("bar1");
        model.addAttribute("listBeers",ba.getBeers());

        return "bar";
    }


    @RequestMapping("/chercherBierreNom")
    public String ChercherBierreNom(Model model,String nomBierre, String barNom){

        Bar ba = barMetier.chercherBarNom(barNom);
        model.addAttribute("foundBar",ba);
        model.addAttribute("listBeers",ba.getBeers());

        Beer b1 = beerMetier.ConsulterBeerNom(nomBierre);
        System.out.println(b1.toString());
        model.addAttribute("foundBeer", b1);


        return "bar";
    }

    @RequestMapping("/chercherBierreType")
    public String ChercherBierreType(Model model, String typeBierre, String barNom){
        Bar ba = barMetier.chercherBarNom(barNom);
        model.addAttribute("foundBar",ba);
        model.addAttribute("listBeers",ba.getBeers());

        List<Beer> lb = beerMetier.ConsulterBeerType(typeBierre);
        model.addAttribute("foundBeers",lb);

        return "bar";
    }
    @RequestMapping("/ajouterBeerBar")
    public String AjouterBeerBar(Model model, Beer be, String barNom){

        Bar ba = barMetier.chercherBarNom(barNom) ;


        Bar bar = barMetier.ajouterBeerToBar(be,ba);
        model.addAttribute("foundBar",bar);
        model.addAttribute("listBeers",bar.getBeers());


        return "bar";
    }

    @RequestMapping("/chercherBarNomBar")
    public String ChercherBarNom(Model model, @RequestParam("barNom") String barNom){

        Bar ba = barMetier.chercherBarNom(barNom) ;

        model.addAttribute("foundBar",ba);
        model.addAttribute("listBeers",ba.getBeers());
        return "bar";
    }





}
