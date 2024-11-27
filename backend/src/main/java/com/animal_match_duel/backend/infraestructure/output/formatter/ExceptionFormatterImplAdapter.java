package com.animal_match_duel.backend.infraestructure.output.formatter;

import org.springframework.stereotype.Service;

import com.animal_match_duel.backend.application.output.formatter.ExceptionFormatterIntPort;
import com.animal_match_duel.backend.infraestructure.input.exception.own.EntityNotFoundException;

@Service
public class ExceptionFormatterImplAdapter implements ExceptionFormatterIntPort {

    @Override
    public void returnResponseEntityNotFound(String message) {
        EntityNotFoundException ex = new EntityNotFoundException(message);
        throw ex;
    }

}
