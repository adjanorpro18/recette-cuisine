package com.example.recettecuisine.controller;

import com.example.recettecuisine.entites.Categorie;
import com.example.recettecuisine.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Categorie Constroller du modele MVC
 * @author: Enyon
 */
@Controller
public class CategorieController {

    //Injection de dependances de services

    @Autowired
    CategorieService categorieService;


    @RequestMapping("/")
    public String getIndex(Model model){
        return "index";
    }

    /**
     * Afficher la liste des categories
     * @return page categories.html
     */

    @GetMapping("categories")
    public String getCategories(Model model){

        List<Categorie> categories = categorieService.getCategories();

        model.addAttribute("categories", categories);

        return "categories";
    }

    /**
     * Afficher le formulaire d'ajout d'une categorie
     * @param model le modele à passer à la vue
     */
    @GetMapping("add-categorie")
    public String addCategorieForm(Model model){
        model.addAttribute("categorie", new Categorie());

        return "add-categorie";
    }
    /**
     * Ajout d'une categorie en base de données
     * @param categorie la catégorie à ajouter
     * @param model le modele à passer à la vue
     * @return categories la page categories.html
     */
    @PostMapping("add-categorie")
    public String addCategorie(Categorie categorie, Model model){

        categorieService.addCategorie(categorie);

        model.addAttribute("categories", categorieService.getCategories());

        return "categories";
    }

    /**
     * Reception de la page avec la methode Get
     */

    @GetMapping("edit-categorie/{id}")
    public String editCategorieForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("categorie",categorieService.getCategorie(id));

        return "edit-categorie";
    }

    /**
     * Envoie des données postées en POST via le formulaire
     * @return la page des categories categories.html
     */
    @PostMapping("edit-categorie")
    public String editCategorie(Categorie categorie, Model model){

        categorieService.updateCategorie(categorie.getId());

        model.addAttribute("categories", categorieService.getCategories());

        return "categories";
    }
}
