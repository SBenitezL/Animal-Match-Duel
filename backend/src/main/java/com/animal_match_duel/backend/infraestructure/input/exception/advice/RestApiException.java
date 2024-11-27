package com.animal_match_duel.backend.infraestructure.input.exception.advice;

import java.util.Locale;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.animal_match_duel.backend.infraestructure.configuration.message.MessageLocalizationService;
import com.animal_match_duel.backend.infraestructure.input.exception.own.EntityNotFoundException;
import com.animal_match_duel.backend.infraestructure.input.exception.structure.Error;
import com.animal_match_duel.backend.infraestructure.input.exception.structure.ErrorCode;
import com.animal_match_duel.backend.infraestructure.input.exception.structure.ErrorUtils;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestApiException {

    private final MessageLocalizationService localizationService;

    public RestApiException(MessageLocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Error> handleEntityNotFoundException(final HttpServletRequest req,
            final EntityNotFoundException ex, final Locale locale) {
        final Error error = ErrorUtils.createError(
                ErrorCode.ENTITY_NOT_FOUND.getCode(),
                String.format("%s, %s",
                        localizationService.getMessage(ErrorCode.ENTITY_NOT_FOUND.getMessageKey(), locale),
                        localizationService.getMessage(ex.getMessage(), locale)),
                HttpStatus.NOT_FOUND.value())
                .setUrl(req.getRequestURL().toString())
                .setMethod(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
