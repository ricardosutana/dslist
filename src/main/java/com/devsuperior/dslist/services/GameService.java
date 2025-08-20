package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service // indicates that this class is a service component in the Spring framework
public class GameService {
    // Business logic related to "Game" entities will be implemented here

    @Autowired
    private GameRepository gameRepository;
    
    public List<GameMinDTO> findAll() {
        // This method will contain logic to retrieve all games and convert them to GameMinDTOs
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dtoList = result.stream()
            .map(x -> new GameMinDTO(x)) // Convert each Game entity to GameMinDTO
            .toList(); // Colle1t the results into a list
    return dtoList; 

        }
    }
