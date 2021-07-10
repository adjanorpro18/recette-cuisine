package com.example.recettecuisine.controller;

import com.example.recettecuisine.entites.Categorie;
import com.example.recettecuisine.service.CuisineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller
 */
@RestController
@RequestMapping("api")
public class ApiController {

    /**
     * CuisineService
     */
    @Autowired
    CuisineService cuisineService;

    /**
     * recupererCategorie
     * @return liste de categories
     */
    @GetMapping("categories-list")
    public List<Categorie> recupererCategories(){

        return cuisineService.getCategorie();
    }

    /**
     * ajouterCategorie
     * @return liste de categories
     */
    @PostMapping("add-category")
    public Categorie  ajouterCategorie(Categorie categorie){

        return cuisineService.addCategorie(categorie);
    }

}
