package com.example.recettecuisine.repository;

import com.example.recettecuisine.entites.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
}
