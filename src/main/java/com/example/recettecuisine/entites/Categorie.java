package com.example.recettecuisine.entites;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Entité Catégorie avec ses attributs
 * @param id qui est l'identifiant de l'entité
 * @param nom qui est le nom de la catégorie
 */
@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="recette_id")
    private Set<Recette> recettes = new HashSet<>();

    /**
     * Constructeur spar defaut
     */
    public Categorie() {
    }

    /**
     * Getters et Setters des attributs de l'entite
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

    public Set<Recette> getRecettes() {
        return recettes;
    }

    public void setRecettes(Set<Recette> recettes) {
        this.recettes = recettes;
    }

    /**
     * Methode toString() qui retourne les valeurs des attrtibuts de l'entité
     */
    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
