package com.co.ias.Birds.species.aplication.services;

import com.co.ias.Birds.infraestructure.models.SpeciesDTO;
import com.co.ias.Birds.species.aplication.domain.Species;
import com.co.ias.Birds.species.aplication.domain.valueObjs.SpeciesCountry;
import com.co.ias.Birds.species.aplication.domain.valueObjs.SpeciesDescription;
import com.co.ias.Birds.species.aplication.domain.valueObjs.SpeciesName;
import com.co.ias.Birds.species.aplication.ports.output.SpeciesRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateSpeciesUseCase implements com.co.ias.Birds.species.aplication.ports.input.CreateSpeciesUseCase {

    private final SpeciesRepository speciesRepository;

    public CreateSpeciesUseCase(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    @Override
    public SpeciesDTO execute(SpeciesDTO speciesDTO){

        Species species = new Species( null,
                new SpeciesName(speciesDTO.getName()),
                new SpeciesCountry(speciesDTO.getCountry()),
                new SpeciesDescription(speciesDTO.getDescription()));


        speciesRepository.store(species);

        return speciesDTO;
    }

}
