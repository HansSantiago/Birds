package com.co.ias.Birds.infraestructure.models;

import com.co.ias.Birds.species.aplication.domain.Species;
import com.co.ias.Birds.species.aplication.domain.valueObjs.SpeciesCountry;
import com.co.ias.Birds.species.aplication.domain.valueObjs.SpeciesDescription;
import com.co.ias.Birds.species.aplication.domain.valueObjs.SpeciesId;
import com.co.ias.Birds.species.aplication.domain.valueObjs.SpeciesName;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpeciesDAO {
    private Long id;
    private String name;
    private String country;
    private String description;

    public SpeciesDAO(Long id, String name, String country, String description) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.description = description;
    }

    public Species toDomain() {
        return new Species(
                new SpeciesId(id),
                new SpeciesName(name),
                new SpeciesCountry(country),
                new SpeciesDescription(description)
        );
    }

    public static SpeciesDAO fromDomain (Species species) {
        SpeciesDAO speciesDAO = new SpeciesDAO(
                species.getId().getValue(),
                species.getName().getValue(),
                species.getCountry().getValue(),
                species.getDescription().getValue()
        );
        return speciesDAO;
    }

    public static SpeciesDAO fromResultSet (ResultSet resultSet) throws SQLException {
        SpeciesDAO speciesDAO = new SpeciesDAO();
        speciesDAO.setId(resultSet.getLong("id"));
        speciesDAO.setName(resultSet.getString("name"));
        speciesDAO.setCountry(resultSet.getString("country"));
        speciesDAO.setDescription(resultSet.getString("description"));
        return speciesDAO;
    }

    public SpeciesDAO() {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SpeciesDAO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
