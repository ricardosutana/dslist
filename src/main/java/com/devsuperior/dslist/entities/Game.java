package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity // configura a classe como uma entidade JPA do tipo "Game" no banco de dados
@Table(name = "tb_game")
public class Game {

    @Id // define o campo "id" como a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // indica que o valor do campo "id" será gerado automaticamente pelo banco de dados
    private Long id;

    private String title;

    @Column(name = "game_year")// mapeia o campo "year" para a coluna "game_year" na tabela do banco de dados
    private String year;
    
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;

    @Column(columnDefinition = "TEXT") // define o tipo da coluna como TEXT no banco de dados
    private String shortDescription;

    @Column(columnDefinition = "TEXT") // define o tipo da coluna como TEXT no banco de dados
    private String longDescription;

    // Constructors, getters, and setters

    public Game() {
    }
    
    public Game(Long id, String title, String year, String genre, String platforms, Double score, String imgUrl, String shortDescription, String longDescription) {
        
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.platforms = platforms;
        this.score = score;
        this.imgUrl = imgUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatform(String platforms) {
        this.platforms = platforms;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Game target = (Game) obj;
        return Objects.equals(id, target.id);
    }
}
