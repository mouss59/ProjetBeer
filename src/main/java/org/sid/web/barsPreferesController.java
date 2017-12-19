package org.sid.web;

import org.sid.Entities.Bar;
import org.sid.Entities.Personne;
import org.sid.services.BarServiceInterface;
import org.sid.services.PersonneInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class barsPreferesController {
    @Autowired
    private PersonneInterface personneMetier;
    @Autowired
    private BarServiceInterface barMetier;


    @RequestMapping("/operationbarPrefere")
    public String index(Model model){
        Personne per = personneMetier.chercherPersonneId(Long.parseLong(String.valueOf(1)));
        model.addAttribute("listBar",per.getBarsPreferes());
        return "barprefere";
    }

    @RequestMapping("/chercherBarNom")
    public String ChercherBarNom(Model model, String nomBar){
        Personne per = personneMetier.chercherPersonneId(Long.parseLong(String.valueOf(1)));
        model.addAttribute("listBar",per.getBarsPreferes());
        Bar bart = barMetier.chercherBarNom(nomBar);
        model.addAttribute("foundBarNomBar", bart);

        return "barprefere";
    }

    @RequestMapping(value="/ajouterBarPrefere", method = RequestMethod.POST)
    public String AjouterAMesBarPref(Model model, Bar bar){
        Personne person = personneMetier.chercherPersonneId(Long.parseLong(String.valueOf(1)));

        Personne p = personneMetier.ajouterBarPrefere(person , bar);
        model.addAttribute("PersonneBars",bar);
        model.addAttribute("listBars",person.getBarsPreferes());
        return "barprefere";
    }
}
