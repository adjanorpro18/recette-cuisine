package com.example.recettecuisine.service;

import com.example.recettecuisine.entites.Categorie;
import com.example.recettecuisine.entites.Ingredient;
import com.example.recettecuisine.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service d'injection de dépendance des données de l'entité Ingredient
 * @author: Enyon
 */
@Service
public class IngredientService {


    /**
     * Service concernant l'entité Ingredient
     */

    @Autowired
    IngredientRepository ingredientRepository;


    /**
     * Methode qui retourne la liste des ingredients
     * @return ingredients
     */

    public List<Ingredient> getIngredients(){

        return ingredientRepository.findAll();
    }

    /**
     * Methode qui permet d'ajouter un ingredient
     * @param ingredient la classe ingredient
     * @return ingredient
     */

    public String addIngredient(Ingredient ingredient){

        ingredientRepository.save(ingredient);
        return "L'ingrédient " + ingredient + "a été bien ajouté";
    }

    /**
     * Methode qui permet d'afficher un ingredient
     * @param id identifiant de l'ingredient
     * @return ingredient
     */

    public Ingredient getIngredient(Long id){

        return ingredientRepository.findById(id).get();
    }

    /**
     * Methode qui permet de modifier une categorie donnée
     *  @param id identifiant de la catégorie
     * @return categorie qui est modifiée
     */

    public String updateIngredient(Long id){

        Ingredient ingredient = ingredientRepository.findById(id).get();

        ingredientRepository.save(ingredient);

        return " L'ingrédient  " + ingredient + " a bien été modifié";
    }

    /**
     * Methode qui permet de supprimer un ingredient
     * @param id identifiant de l'ingredient
     * @return ingredient
     */

    public String deleteIngredient(Long id){

        Ingredient ingredient = ingredientRepository.findById(id).get();

        ingredientRepository.delete(ingredient);

        return " L'ingredient " + ingredient + " a bien été supprimé";
    }

}
