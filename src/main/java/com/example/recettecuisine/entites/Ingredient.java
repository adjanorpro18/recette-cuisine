package com.example.recettecuisine.entites;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Entité Ingredient avec ses attributs
 * @param id qui est l'identifiant de l'entité
 * @param liste qui est la liste des ingredients
 */
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String quantité;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "recette_ingredient",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "recette_id"))
    private Set<Recette> recettes = new HashSet<>();

    /**
     * Constrcuteur par defaut
     */
    public Ingredient() {
    }

    /**
     * Getters et Setters
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getQuantité() {
        return quantité;
    }

    public void setQuantité(String quantité) {
        this.quantité = quantité;
    }

    public Set<Recette> getRecettes() {
        return recettes;
    }

    public void setRecettes(Set<Recette> recettes) {
        this.recettes = recettes;
    }

    /**
     * Methode toString() de l'entité Ingredient
     */
    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", quantité='" + quantité + '\'' +
                ", recettes=" + recettes +
                '}';
    }
}

