package com.example.recettecuisine.service;

import com.example.recettecuisine.entites.Categorie;
import com.example.recettecuisine.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service d'injection de dépendance des données de l'entité Categorie
 * @author: Enyon
 */
@Service
public class CategorieService {

    @Autowired
    CategoryRepository categoryRepository;


    /**
     * Methode qui retourne la liste des categories
     * @return categories
     */

    public List<Categorie> getCategories(){

        return categoryRepository.findAll();
    }

    /**
     * Methode qui permet d'ajouter une categorie
     * @return categorie
     */

    public String addCategorie(Categorie categorie){

        categoryRepository.save(categorie);
        return "La catégorie " + categorie + " a été bien ajoutée";
    }

    /**
     * Methode qui permet de trouver une categorie donnée
     * @param id identifiant de la catégorie
     * @return categorie
     */

    public Categorie getCategorie( Long id){

         return categoryRepository.findById(id).get();
    }

    /**
     * Methode qui permet de modifier une categorie donnée
     *  @param id identifiant de la catégorie
     * @return categorie qui est modifiée
     */

    public String updateCategorie(Long id){

        Categorie categorie = categoryRepository.findById(id).get();

        categoryRepository.save(categorie);

        return " La catégorie " + categorie + " a bien été modifiée";
    }

    /**
     * Methode qui permet de supprimer une categorie donnée
     *  @param id identifiant de la catégorie
     * @return categorie qui est supprimée
     */

    public String deleteCategorie(Long id){

        Categorie categorie = categoryRepository.findById(id).get();

        categoryRepository.delete(categorie);
        return " La catégorie " + categorie + " a bien été supprimée";
    }

}
