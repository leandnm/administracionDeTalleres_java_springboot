package com.talleres.talleres.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MainController {

    @GetMapping("/saludo")
    public String saludo(){
        return "hola mundo";
    }

}
