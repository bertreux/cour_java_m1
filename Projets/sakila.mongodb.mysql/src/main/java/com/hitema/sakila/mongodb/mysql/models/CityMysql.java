package com.hitema.sakila.mongodb.mysql.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "city")
public class CityMysql {
    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    private String name;

    @ManyToOne()
    @JoinColumn(name="country_id")
    @JsonIgnoreProperties(value = { "cities" })
    private CountryMysql country;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @Column(name = "capital", nullable = true)
    private Boolean capital;

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country.toStringWithoutCities() +
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

    public CountryMysql getCountry() {
        return country;
    }

    public void setCountry(CountryMysql country) {
        this.country = country;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public boolean isCapital() {
        return capital != null && capital;
    }

    public void setCapital(Boolean capital) {
        this.capital = capital;
    }
}
