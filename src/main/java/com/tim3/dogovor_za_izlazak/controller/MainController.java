package com.tim3.dogovor_za_izlazak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String homepage(){
        return "homepage";
    }
}