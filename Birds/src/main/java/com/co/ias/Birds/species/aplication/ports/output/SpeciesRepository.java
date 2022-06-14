package com.co.ias.Birds.species.aplication.ports.output;

import com.co.ias.Birds.species.aplication.domain.Species;
import com.co.ias.Birds.species.aplication.domain.valueObjs.SpeciesId;

import java.util.Optional;

public interface SpeciesRepository {
    void store(Species species);

    Optional<Species> get(SpeciesId speciesId);

    void update(Species species);

    Boolean delete(SpeciesId speciesId);
}
