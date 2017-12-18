package org.sid.web;


import org.sid.Entities.Bar;
import org.sid.Entities.Beer;
import org.sid.services.BarServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientFidelsController {
    @Autowired
    private BarServiceInterface barMetier;


    @RequestMapping(value="/operationClientFidel")
    public String index(Model model){
        Bar ba = barMetier.chercherBarNom("bar1");
        model.addAttribute("foundPerson",ba.getPersonnes());

        return "BarClientsFidels";
    }

    @RequestMapping("/clientsFidels")
    public String AfficherClients(Model model, String barNom){
        Bar ba = barMetier.chercherBarNom(barNom);
        model.addAttribute("foundBar",ba);
        model.addAttribute("foundPerson", ba.getPersonnes());

        return "BarClientsFidels";
    }
}
