package com.devsuperior.dslist.entities;
// This class is used as a composite primary key for the Belonging entity
// It combines the Game and GameList entities to uniquely identify a belonging. 

@embeddable
public class BelongingPK {
    @manyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @manyToOne
    @JoinColumn(name = "game_list_id")
    private GameList gameList;
}

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
    return Objects.hash(game, gameList);
}   

@Override
public boolean equals(Object obj) { 
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    BelongingPK other = (BelongingPK) obj;
    return Objects.equals(game, other.game) && Objects.equals(gameList, other.gameList);
}