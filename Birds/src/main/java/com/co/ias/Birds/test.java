package com.co.ias.Birds;

import com.co.ias.Birds.infraestructure.models.SpeciesDTO;
import com.co.ias.Birds.species.aplication.domain.Species;
import com.co.ias.Birds.species.aplication.domain.valueObjs.SpeciesCountry;
import com.co.ias.Birds.species.aplication.domain.valueObjs.SpeciesDescription;
import com.co.ias.Birds.species.aplication.domain.valueObjs.SpeciesId;
import com.co.ias.Birds.species.aplication.domain.valueObjs.SpeciesName;

public class test {
    public static void main(String[] args) {
        try {
            Species species = new Species(
                    new SpeciesId(1L),
                    new SpeciesName("Canario"),
                    new SpeciesCountry("Islas canarias"),
                    new SpeciesDescription("Description")
            );
            System.out.println(species.toString());
        } catch (NullPointerException|IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }

        SpeciesDTO speciesDTO = new SpeciesDTO(1L, "Canario", "Islas canarias", "Description");
        Species species = speciesDTO.toDomain();
        System.out.println("to domain" + species);

        SpeciesDTO speciesDTO1 = SpeciesDTO.fromDomain(species);
        System.out.println("from domain" + speciesDTO1);
    }
}
