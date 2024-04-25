package com.hitema.sakila.mongodb.mongo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document("city")
public class CityMongo {
    @Id
    private Long id;

    @Field(name = "city")
    private String name;

    private CountryMongo country;

    @Field(name = "last_update")
    private LocalDateTime lastUpdate;

    @Field(name = "capital")
    private Boolean capital;

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", lastUpdate=" + lastUpdate +
                ", capital=" + capital +
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

    public CountryMongo getCountry() {
        return country;
    }

    public void setCountry(CountryMongo country) {
        this.country = country;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Boolean getCapital() {
        return capital != null && capital;
    }

    public void setCapital(Boolean capital) {
        this.capital = capital;
    }
}
