package com.example.recettecuisine.entites;

import javax.persistence.*;
import java.util.List;

/**
 * Classe Recette avec ses attributs
 */
@Entity
public class Recette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String modePreparation;
    private String tempsPreparation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="categorie_id")
    private Categorie categorie;

    public Recette() {
    }

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

    public String getModePreparation() {
        return modePreparation;
    }

    public void setModePreparation(String modePreparation) {
        this.modePreparation = modePreparation;
    }

    public String getTempsPreparation() {
        return tempsPreparation;
    }

    public void setTempsPreparation(String tempsPreparation) {
        this.tempsPreparation = tempsPreparation;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
