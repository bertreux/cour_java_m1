package com.hitema.sakila.mongodb.mongo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Document("film")
public class FilmMongo {
    @Id
    private Long id;

    @Field(name = "title")
    private String title;

    @Field(name = "description")
    private String description;

    private LanguageMongo language;

    @Field(name = "release_year")
    private LocalDateTime releaseYear;

    @Field(name = "picture")
    @JsonIgnore
    private byte[] picture;

    @Override
    public String toString() {
        return "FilmMongo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", language=" + language +
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

    public LanguageMongo getLanguage() {
        return language;
    }

    public void setLanguage(LanguageMongo language) {
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
