package com.felintro.leonard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teste")
public class TesteController {

    @GetMapping
    public String teste() {
        return "teste/testea";
    }
}
