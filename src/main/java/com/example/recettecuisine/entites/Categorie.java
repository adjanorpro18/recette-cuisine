package com.example.recettecuisine.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entité Catégorie avec ses attributs
 * @param id qui est l'identifiant de l'entité
 * @paeam nom qui est le nom de la catégorie
 * @param famille qui est la famille de la categorie
 */
@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String famille;

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

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    /**
     * Methode toString() qui retourne les valeurs des attrtibuts de l'entité
     */
    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", famille='" + famille + '\'' +
                '}';
    }
}
