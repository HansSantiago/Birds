package com.co.ias.Birds.species.aplication.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class SpeciesName {
    private final String value;


    public SpeciesName(String value) {
        Validate.notNull(value, "Species name can not be null");
        Validate.isTrue(value.length() <= 25, "Species name can not be longer than 25" );
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SpeciesName{" +
                "value='" + value + '\'' +
                '}';
    }
}
