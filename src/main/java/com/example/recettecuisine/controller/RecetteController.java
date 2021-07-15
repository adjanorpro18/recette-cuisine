package com.example.recettecuisine.controller;


import com.example.recettecuisine.entites.Ingredient;
import com.example.recettecuisine.entites.Recette;
import com.example.recettecuisine.service.IngredientService;
import com.example.recettecuisine.service.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Recette Constroller du modele MVC
 * @author: Enyon
 */
@Controller
public class RecetteController {

    //Injection de dependances de services

    @Autowired
    RecetteService recetteService;


    /**
     * Afficher la liste des recettes
     * @return page recettes.html
     */

    @GetMapping("recettes")
    public String getRecettes(Model model){

        List<Recette> recettes = recetteService.getRecettes();

        model.addAttribute("recettes", recettes);

        return "recettes";
    }

    /**
     * Afficher le formulaire d'ajout d'une recette
     * @param model le modele à passer à la vue
     */
    @GetMapping("add-recette")
    public String addRecetteForm(Model model){
        model.addAttribute("recette", new Recette());

        return "add-recette";
    }
    /**
     * Ajout d'une recette en base de données
     * @param recette la recette à ajouter
     * @param model le modele à passer à la vue
     * @return ingredients la page ingredients.html
     */
    @PostMapping("add-recette")
    public String addRecette(Recette recette, Model model){

        recetteService.addRecette(recette);

        model.addAttribute("recettes", recetteService.getRecette(recette.getId()));

        return "recettes";
    }

    /**
     * Reception de la page avec la methode Get
     */

    @GetMapping("edit-recette/{id}")
    public String editRecetteForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("recette",recetteService.getRecette(id));

        return "edit-recette";
    }

    /**
     * Envoie des données postées en POST via le formulaire
     * @return la page des recettes recettes.html
     */
    @PostMapping("edit-recette")
    public String editRecette(Recette recette, Model model){

        recetteService.updateRecette(recette.getId());

        model.addAttribute("recettes", recetteService.getRecettes());

        return "recettes";
    }
}
