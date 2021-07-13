package com.example.recettecuisine.repository;

import com.example.recettecuisine.entites.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetteRepository extends JpaRepository<Recette, Long> {
}
