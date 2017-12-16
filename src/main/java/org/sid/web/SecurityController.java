package org.sid.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {


/*

@RequestMapping(value="/")
    public String home(){
        return "redirect:/operationBar";
}

*/

    @RequestMapping(value="/")
    public String home(){
        return "login";
    }

    @RequestMapping(value="/403")
    public String accessDenied(){
        return "403";
    }

}
