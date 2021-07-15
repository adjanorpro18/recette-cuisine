package com.example.recettecuisine.controller;


import com.example.recettecuisine.entites.Ingredient;
import com.example.recettecuisine.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Ingredient Constroller du modele MVC
 * @author: Enyon
 */
@Controller
public class IngredientController {

    //Injection de dependances de services

    @Autowired
    IngredientService ingredientService;


    /**
     * Afficher la liste des ingredients
     * @return page ingredients.html
     */

    @GetMapping("ingredients")
    public String getIngredients(Model model){

        List<Ingredient> ingredients = ingredientService.getIngredients();

        model.addAttribute("ingredients", ingredients);

        return "ingredients";
    }

    /**
     * Afficher le formulaire d'ajout d'un ingredient
     * @param model le modele à passer à la vue
     */
    @GetMapping("add-ingredient")
    public String addIngredientForm(Model model){
        model.addAttribute("ingredient", new Ingredient());

        return "add-ingredient";
    }
    /**
     * Ajout d'un ingredient en base de données
     * @param ingredient l'ingredient à ajouter
     * @param model le modele à passer à la vue
     * @return ingredients la page ingredients.html
     */
    @PostMapping("add-ingredient")
    public String addIngredient(Ingredient ingredient, Model model){

        ingredientService.addIngredient(ingredient);

        model.addAttribute("ingredients", ingredientService.getIngredient(ingredient.getId()));

        return "ingredients";
    }

    /**
     * Reception de la page avec la methode Get
     */

    @GetMapping("edit-ingredient/{id}")
    public String editIngredientForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("ingredient",ingredientService.getIngredient(id));

        return "edit-ingredient";
    }

    /**
     * Envoie des données postées en POST via le formulaire
     * @return la page des ingredients ingredients.html
     */
    @PostMapping("edit-ingredient")
    public String editIngredient(Ingredient ingredient, Model model){

        ingredientService.updateIngredient(ingredient.getId());

        model.addAttribute("ingredients", ingredientService.getIngredients());

        return "ingredients";
    }
}
