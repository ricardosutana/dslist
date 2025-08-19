package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
    // This interface will automatically inherit methods for CRUD operations
    // and can be extended with custom query methods if needed.

}
