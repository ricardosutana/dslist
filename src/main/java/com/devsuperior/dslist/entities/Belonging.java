package com.devsuperior.dslist.entities;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;   
import java.util.Objects;

@embeddedId
@table(name = "tb_belonging")
// This class represents a Belonging entity in the application.
public class Belonging {

    private BelongingPK id;// Composite key 
    private Integer position;

}
public Belonging() {
}
// Constructor to initialize the Belonging with a Game, GameList, and position
public Belonging(Game game, GameList gameList, Integer position) {
    id.setGame(game);
    id.setGameList(gameList);
    this.position = position;
}

public BelongingPK getId() {
    return id;
}
public void setId(BelongingPK id) {
    this.id = id;
}
public Integer getPosition() {
    return position;
}

public void setPosition(Integer position) {
    this.position = position;
}
@Override
public int hashCode() {
    return Objects.hash(id);
}
@Override
public boolean equals(Object obj) { 
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Belonging other = (Belonging) obj;
    return Objects.equals(id, other.id);
}