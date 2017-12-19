package org.sid.web;

import org.sid.Entities.Beer;
import org.sid.services.BeerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AjouterBierreController {
    @Autowired
    private BeerServiceInterface beerMetier;

    @RequestMapping(value="/ajouterBeer")
    public String AjouterBierre(Model model, String beerNom, String beerType){
        Beer b =new Beer(beerNom,beerType,0);
        beerMetier.ajouterBeer(b);
        model.addAttribute("addBeer", b);
        return "ajouterBeer";
    }

}
