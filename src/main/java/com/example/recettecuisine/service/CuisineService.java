package com.example.recettecuisine.service;

import com.example.recettecuisine.entites.Recette;

import com.example.recettecuisine.repository.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Service de mise en place des recettes de cuisine
 * @author: Enyon
 */
@Service
public class CuisineService {

    /**/
    /**
     * Service concernant l'entité Recette
     */


    @Autowired
    RecetteRepository recetteRepository;


    /**
     * Methode qui retourne la liste des recettes
     * @return recettes
     */

    public List<Recette> getRecettes(){

        return recetteRepository.findAll();
    }

    /**
     * Methode qui permet d'ajouter une recette
     * @return recette
     */

    public String addRecette(Recette recette){
        recetteRepository.save(recette);
        return "L'ingrédient " + recette + "a été bien ajouté";
    }

    /**
     * Methode retourne une recette
     * @return recette
     */

    public Recette findRecette(Long id){

        return recetteRepository.findById(id).get();
    }

    /**
     * Methode qui permet de supprimer une recette
     * @return recette
     */

    public String deleteRecette(Long id){

        Recette recette = recetteRepository.findById(id).get();

        recetteRepository.delete(recette);

        return " L'ingredient " + recette + " a bien été supprimée";
    }
}
