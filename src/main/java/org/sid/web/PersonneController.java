package org.sid.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonneController {

    @RequestMapping("/operationClient")
    public String index(){

        return "client";
    }

}
