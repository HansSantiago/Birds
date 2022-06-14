package com.co.ias.Birds.species.aplication.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class SpeciesId {
    private final Long value;

    public SpeciesId(Long value) {
        Validate.notNull(value, "Species id can not be null");
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SpeciesId{" +
                "value=" + value +
                '}';
    }
}
