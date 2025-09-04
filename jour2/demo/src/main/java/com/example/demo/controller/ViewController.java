package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    @GetMapping("/form")
    public String afficherFormulaire() {
        return "view"; // view.html avec formulaire
    }

    @PostMapping("/welcome")
    public String traiterFormulaire(@RequestParam("name") String name, @RequestParam("age") int age, Model model) {
        if (name == null || name.isEmpty() || age <= 0) {
            model.addAttribute("error", "Veuillez entrer un nom valide et un âge supérieur à 0.");
            return "view"; // on réutilise la même page pour afficher l'erreur
        }
        model.addAttribute("message", "Bienvenue, " + name + " vous avez " + age + " ans !");
        return "view"; // on réutilise la même page pour afficher le message
    }
}
