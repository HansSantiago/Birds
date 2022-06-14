package com.co.ias.Birds.infraestructure.controller;

import com.co.ias.Birds.infraestructure.models.ApplicationError;
import com.co.ias.Birds.infraestructure.models.SpeciesDTO;
import com.co.ias.Birds.species.aplication.domain.Species;
import com.co.ias.Birds.species.aplication.ports.input.CreateSpeciesUseCase;
import com.co.ias.Birds.species.aplication.ports.input.QuerySpeciesByIdUseCase;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

public class SpeciesController {
    private final CreateSpeciesUseCase createSpeciesUseCase;
    private final QuerySpeciesByIdUseCase querySpeciesByIdUseCase;


    public SpeciesController(CreateSpeciesUseCase createSpeciesUseCase, QuerySpeciesByIdUseCase querySpeciesByIdUseCase) {
        this.createSpeciesUseCase = createSpeciesUseCase;
        this.querySpeciesByIdUseCase = querySpeciesByIdUseCase;
    }

    @RequestMapping(value =  "/species", method = RequestMethod.POST)
    public ResponseEntity<?> createService(@RequestBody SpeciesDTO speciesDTO) {
        try {
           SpeciesDTO speciesDTOOutput = createSpeciesUseCase.execute(speciesDTO);
           return ResponseEntity.ok(speciesDTOOutput);
        } catch (IllegalArgumentException|NullPointerException error) {
            ApplicationError applicationError = new ApplicationError("InputDataValidationError", "Bad input data", Map.of("error", error.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        } catch (Exception e) {
            ApplicationError applicationError = new ApplicationError("Error 505", "conctat support", Map.of());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }
}
