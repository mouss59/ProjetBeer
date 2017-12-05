package org.sid.web;

import org.sid.services.BarServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BarController {
    @Autowired
    private BarServiceInterface barMetier;

    @RequestMapping("/operationBar")
    public String index(){
        return "bar";
    }
}
