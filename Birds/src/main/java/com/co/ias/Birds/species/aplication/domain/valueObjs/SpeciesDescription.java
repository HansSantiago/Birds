package com.co.ias.Birds.species.aplication.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class SpeciesDescription {
    private final String value;


    public SpeciesDescription(String value) {
        Validate.isTrue(value.length() <= 60, "Species description can not be longer than 60 characters");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
