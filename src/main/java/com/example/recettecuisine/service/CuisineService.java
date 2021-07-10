package com.example.recettecuisine.service;

import com.example.recettecuisine.entites.Categorie;
import com.example.recettecuisine.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Service de mise en place des recettes de cuisine
 */
@Service
public class CuisineService {

    /**
     * Service concernant l'entité Catégorie
     */

    @Autowired
    CategoryRepository categoryRepository;


    //Récuperer la liste de cartegories

    public List<Categorie> getCategorie(){

        return categoryRepository.findAll();
    }

    //Ajouter une categorie à la liste

    public Categorie addCategorie(Categorie categorie){

        return categoryRepository.save(categorie);
    }
}
