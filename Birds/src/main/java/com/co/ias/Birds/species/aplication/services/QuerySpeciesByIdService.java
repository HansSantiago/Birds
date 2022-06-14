package com.co.ias.Birds.species.aplication.services;

import com.co.ias.Birds.infraestructure.models.SpeciesDTO;
import com.co.ias.Birds.species.aplication.ports.input.QuerySpeciesByIdUseCase;
import org.springframework.stereotype.Service;

@Service
public class QuerySpeciesByIdService implements QuerySpeciesByIdUseCase {

    @Override
    public SpeciesDTO execute(SpeciesDTO speciesDTO) {
        return null;
    }
}
