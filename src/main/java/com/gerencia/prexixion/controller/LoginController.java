package com.gerencia.prexixion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gerencia.prexixion.models.Personal;
import com.gerencia.prexixion.services.PersonalService;

@Controller
@RequestMapping
public class LoginController {

    @Autowired
    private PersonalService personalService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("personal", new Personal());
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@ModelAttribute Personal personal, Model model){
        System.out.println(personal.getDni());
        
        if(personal.getInternoExterno() == 1){
            try {
                personal = personalService.login(personal.getDni(), personal.getClave());
            } catch (Exception e) {
                System.out.println("ERROR");
            }
            System.out.println(personal.toString());
            model.addAttribute("personal", personal);
            return "dashboard";
        } else {
            return "dashboardExtranet";
        }
        
    }
}
