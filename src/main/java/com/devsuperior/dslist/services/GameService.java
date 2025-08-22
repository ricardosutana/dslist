package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service // indicates that this class is a service component in the Spring framework
public class GameService {
    // This class is responsible for handling business logic related to games
    // It interacts with the GameRepository to perform CRUD operations
    // It converts Game entities to DTOs (Data Transfer Objects) for use in the controller
    // Business logic related to "Game" entities will be implemented here
    // This class will use GameRepository to interact with the database
    // It will contain methods to retrieva and delete games
    // The methods will return DTOs (Data Transfer Objects) to the controller
    // to send responses to the client
    // Autowired annotation is used to inject the GameRepository dependency
    // This allows Spring to manage the lifecycle of the GameRepository bean
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        // This method will contain logic to retrieve all games and convert them to GameMinDTOs
        // Using findAll which returns a List<Game>
        // The List<Game> will be converted to List<GameMinDTO> using a stream
        // and the GameMinDTO constructor that takes a Game entity as an argument
        // This allows for a more concise representation of the game data
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dtoList = result.stream()
            .map(x -> new GameMinDTO(x)) // Convert each Game entity to GameMinDTO
            .toList(); // Collect the results into a list
    return dtoList; 

    }
    @Transactional(readOnly = true)// This annotation indicates that the method is read-only and does not modify the database
    public GameDTO findById(Long id) {
        // This method will contain logic to retrieve a game by its ID and convert it to GameDTO
        // Using findById which returns an Optional<Game>
        // If the game with the given ID does not exist, calling get() will throw a NoSuchElementException
        // In a production application, you might want to handle this case more gracefully
        // Need treatment to check if ID exists
        Game result = gameRepository.findById(id).get();// get() retrieves the Game entity from the Optional
        GameDTO dto = new GameDTO(result);// Convert the Game entity to GameDTO
        return dto;
    }

    public void deleteById(Long id) {
        // This method will contain logic to delete a game by its ID
        // Using deleteById which is a method provided by JpaRepository
        // It will throw an exception if the game with the given ID does not exist
        // Need treatment to check if ID exists
        if (!gameRepository.existsById(id)) {
            throw new IllegalArgumentException("Game with ID " + id + " does not exist.");
        }
         // If the game exists, delete it
        gameRepository.deleteById(id);
    }

}
