package com.devsuperior.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity// This class represents a Belonging entity, which is used to associate a Game with a GameList
@Table(name = "tb_belonging") // maps the class to the "tb_belonging" table in the database
public class Belonging {

    @EmbeddedId// This annotation indicates that the class has a composite primary key
    // The primary key is represented by the BelongingPK class, which combines Game and GameList
    // The BelongingPK class is used to uniquely identify a belonging in the system
    private BelongingPK id = new BelongingPK();

    private Integer position;

    public Belonging() {

    }
    public Belonging(Game game, GameList  gamelist, Integer position) {
        this.id.setGame(game);
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
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Belonging other = (Belonging) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


}

