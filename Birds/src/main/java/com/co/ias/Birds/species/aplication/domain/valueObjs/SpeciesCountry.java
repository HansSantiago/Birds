package com.co.ias.Birds.species.aplication.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class SpeciesCountry {
    private final String value;

    public SpeciesCountry(String value) {
        Validate.notNull(value, "Specie country can not be null");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SpeciesCountry{" +
                "value='" + value + '\'' +
                '}';
    }
}
