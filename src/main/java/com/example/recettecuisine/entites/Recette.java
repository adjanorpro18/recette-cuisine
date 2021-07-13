package com.example.recettecuisine.entites;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Classe Recette avec ses attributs
 */
@Entity
public class Recette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String preparation;
    private String modeCuisson;
    private String tempsCuisson;
    private String description;
    private int nombreLike;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "recette_ingredient",
            joinColumns = @JoinColumn(name = "recette_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<Ingredient> ingredients = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="categorie_id")
    private Categorie categorie;

    /**
     * Contructeur par defaut
     */
    public Recette() {
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

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getTempsCuisson() {
        return tempsCuisson;
    }

    public void setTempsCuisson(String tempsCuisson) {
        this.tempsCuisson = tempsCuisson;
    }

    public String getModeCuisson() {
        return modeCuisson;
    }

    public void setModeCuisson(String modeCuisson) {
        this.modeCuisson = modeCuisson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNombreLike() {
        return nombreLike;
    }

    public void setNombreLike(int nombreLike) {
        this.nombreLike = nombreLike;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    /**
     * Methode toString() de l'entité recette
     */
    @Override
    public String toString() {
        return "Recette{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", preparation='" + preparation + '\'' +
                ", modeCuisson='" + modeCuisson + '\'' +
                ", tempsCuisson='" + tempsCuisson + '\'' +
                ", description='" + description + '\'' +
                ", nombreLike=" + nombreLike +
                ", ingredients=" + ingredients +
                ", categorie=" + categorie +
                '}';
    }
}
