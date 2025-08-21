package com.devsuperior.dslist.entities;
// This class is used as a composite primary key for the Belonging entity
// It combines the Game and GameList entities to uniquely identify a belonging. 

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class BelongingPK {
    
    @ManyToOne // establishes a many-to-one relationship with the Game entity
    @JoinColumn(name = "game_id") // maps the "game_id" column to the Game entity
    private Game game;

    @ManyToOne
    @JoinColumn(name = "list_id") // establishes a many-to-one relationship with the GameList entity
    private GameList gameList;

    public BelongingPK() {
    }
    public BelongingPK(Game game, GameList gameList) {
        this.game = game;
        this.gameList = gameList;
    }
    public Game getGame() {
        return game;
    }
    public void setGame(Game game) {
        this.game = game;
    }
    public GameList getGameList() {
        return gameList;
    }
    public void setGameList(GameList gameList) {
        this.gameList = gameList;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((game == null) ? 0 : game.hashCode());
        result = prime * result + ((gameList == null) ? 0 : gameList.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BelongingPK other = (BelongingPK) obj;
        if (game == null) {
            if (other.game != null)
                return false;
        } else if (!game.equals(other.game))
            return false;
        if (gameList == null) {
            if (other.gameList != null)
                return false;
        } else if (!gameList.equals(other.gameList))
            return false;
        return true;
    }
    
}


