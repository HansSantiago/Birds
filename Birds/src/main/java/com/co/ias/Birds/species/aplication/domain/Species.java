package com.co.ias.Birds.species.aplication.domain;

import com.co.ias.Birds.species.aplication.domain.valueObjs.SpeciesCountry;
import com.co.ias.Birds.species.aplication.domain.valueObjs.SpeciesDescription;
import com.co.ias.Birds.species.aplication.domain.valueObjs.SpeciesId;
import com.co.ias.Birds.species.aplication.domain.valueObjs.SpeciesName;

public class Species {
    private final SpeciesId id ;
    private final SpeciesName name;
    private final SpeciesCountry country;
    private final SpeciesDescription description;

    public Species(SpeciesId id, SpeciesName name, SpeciesCountry country, SpeciesDescription description) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.description = description;
    }

    public SpeciesCountry getCountry() {
        return country;
    }

    public SpeciesId getId() {
        return id;
    }

    public SpeciesName getName() {
        return name;
    }

    public SpeciesDescription getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Species{" +
                "id=" + id +
                ", name=" + name +
                ", country=" + country +
                ", description=" + description +
                '}';
    }
}
