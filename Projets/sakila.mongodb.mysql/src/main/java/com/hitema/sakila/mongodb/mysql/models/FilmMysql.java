package com.hitema.sakila.mongodb.mysql.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "film")
public class FilmMysql {
    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne()
    @JoinColumn(name="language_id")
    @JsonIgnoreProperties(value = { "language" })
    private LanguageMysql language;

    @Column(name = "release_year")
    private LocalDateTime releaseYear;

    @Column(name = "picture")
    @JsonIgnore
    private byte[] picture;

    @Override
    public String toString() {
        return "FilmMysql{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", language=" + language.toStringWithoutFilms() +
                ", releaseYear=" + releaseYear +
                ", picture=" + Arrays.toString(picture) +
                '}';
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LanguageMysql getLanguage() {
        return language;
    }

    public void setLanguage(LanguageMysql language) {
        this.language = language;
    }

    public LocalDateTime getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(LocalDateTime releaseYear) {
        this.releaseYear = releaseYear;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
