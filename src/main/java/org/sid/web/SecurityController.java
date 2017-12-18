package org.sid.web;


import org.sid.Entities.Personne;
import org.sid.services.PersonneInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecurityController {

    @Autowired
    private PersonneInterface personneMetier;


    @RequestMapping(value="/")
    public String home(){
        return "loginpassword";
    }

    @RequestMapping(value="/403")
    public String accessDenied(){
        return "403";
    }

    @RequestMapping(value="/LoginPassword")
    public String loginPassword(Model model, @RequestParam("login") String login,@RequestParam("password") String password){

        Personne per = personneMetier.trouverPersonneLoginPassword(login,password);
        System.out.println(per.toString());
        if (per.getStatus().equals("client")) {
            model.addAttribute("foundUser", per);
            return "client";
        } else if(per.getStatus().equals("barman")){
            model.addAttribute("foundUser",per);
            return "bar";
        }else
            return "loginpassword";
    }

}
