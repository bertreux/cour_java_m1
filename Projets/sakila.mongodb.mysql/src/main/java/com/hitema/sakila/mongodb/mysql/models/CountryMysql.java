package com.hitema.sakila.mongodb.mysql.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "country")
public class CountryMysql {
    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String name;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy="country")
    @JsonIgnoreProperties(value = {"country"})
    private List<CityMysql> cities;

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", cities=" + cities +
                '}';
    }

    public String toStringWithoutCities() {
        return "Country{" +
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

    public List<CityMysql> getCities() {
        return cities;
    }

    public void setCities(List<CityMysql> city) {
        this.cities = city;
    }
}
