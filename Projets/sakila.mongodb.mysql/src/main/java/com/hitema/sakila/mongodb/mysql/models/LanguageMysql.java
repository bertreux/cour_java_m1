package com.hitema.sakila.mongodb.mysql.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "language")
public class LanguageMysql {
    @Id
    @Column(name = "language_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy="language")
    @JsonIgnoreProperties(value = {"language"})
    private List<FilmMysql> films;

    @Override
    public String toString() {
        return "LanguageMysql{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", films=" + films +
                '}';
    }

    public String toStringWithoutFilms() {
        return "LanguageMysql{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<FilmMysql> getFilms() {
        return films;
    }

    public void setFilms(List<FilmMysql> films) {
        this.films = films;
    }
}
