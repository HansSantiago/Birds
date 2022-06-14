package com.co.ias.Birds.infraestructure.models;

import com.co.ias.Birds.species.aplication.domain.Species;
import com.co.ias.Birds.species.aplication.domain.valueObjs.SpeciesCountry;
import com.co.ias.Birds.species.aplication.domain.valueObjs.SpeciesDescription;
import com.co.ias.Birds.species.aplication.domain.valueObjs.SpeciesId;
import com.co.ias.Birds.species.aplication.domain.valueObjs.SpeciesName;

public class SpeciesDTO {
    private Long speciesId;
    private String name;
    private String country;
    private String description;

    public SpeciesDTO(Long productId, String name, String country, String description) {
        this.speciesId = productId;
        this.name = name;
        this.country = country;
        this.description = description;
    }

    public Species toDomain() {
        return new Species(
                new SpeciesId(speciesId),
                new SpeciesName(name),
                new SpeciesCountry(country),
                new SpeciesDescription(description)
        );
    }

    public static SpeciesDTO fromDomain(Species species) {
        SpeciesDTO speciesDTO = new SpeciesDTO();
        speciesDTO.setSpeciesId(species.getId().getValue());
        speciesDTO.setName(species.getName().getValue());
        speciesDTO.setCountry(species.getCountry().getValue());
        speciesDTO.setDescription(species.getDescription().getValue());
        return speciesDTO;
    }

    public SpeciesDTO() {
    }

    public Long getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(Long speciesId) {
        this.speciesId = speciesId;
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
        return "SpeciesDTO{" +
                "speciesId=" + speciesId +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

