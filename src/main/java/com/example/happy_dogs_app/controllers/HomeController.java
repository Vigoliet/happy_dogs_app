package com.example.happy_dogs_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomePage(){

        System.out.println("In get home!");

        return "home";
    }

}
