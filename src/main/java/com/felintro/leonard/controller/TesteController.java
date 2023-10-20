package com.felintro.leonard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author allan
 **/
@Controller
@RequestMapping("/teste")
public class TesteController {

    @GetMapping
    public String teste() {
        return "login/login";
    }
}