package com.animal_match_duel.backend.infraestructure.input.exception.advice;

import java.util.Locale;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.animal_match_duel.backend.infraestructure.configuration.message.MessageLocalizationService;
import com.animal_match_duel.backend.infraestructure.input.exception.own.BadFormatException;
import com.animal_match_duel.backend.infraestructure.input.exception.own.BusinessRuleViolationException;
import com.animal_match_duel.backend.infraestructure.input.exception.own.ConectionErrorException;
import com.animal_match_duel.backend.infraestructure.input.exception.own.EntityExistException;
import com.animal_match_duel.backend.infraestructure.input.exception.own.EntityNotFoundException;
import com.animal_match_duel.backend.infraestructure.input.exception.own.NoDataException;
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

    @ExceptionHandler(BadFormatException.class)
    public ResponseEntity<Error> handleBadFormatException(final HttpServletRequest req, final BadFormatException ex,
            final Locale locale) {
        final Error error = ErrorUtils.createError(
                ErrorCode.BAD_FORMAT.getCode(),
                String.format("%s, %s",
                        localizationService.getMessage(ErrorCode.BAD_FORMAT.getMessageKey(), locale),
                        localizationService.getMessage(ex.getMessage(), locale)),
                HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessRuleViolationException.class)
    public ResponseEntity<Error> handleBusinessRuleViolationException(final HttpServletRequest req,
            final BusinessRuleViolationException ex,
            final Locale locale) {
        final Error error = ErrorUtils.createError(
                ErrorCode.BUSINESS_RULE_VIOLATION.getCode(),
                String.format("%s, %s",
                        localizationService.getMessage(ErrorCode.BUSINESS_RULE_VIOLATION.getMessageKey(), locale),
                        localizationService.getMessage(ex.getMessage(), locale)),
                HttpStatus.NOT_ACCEPTABLE.value());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ConectionErrorException.class)
    public ResponseEntity<Error> handleConectionErrorException(final HttpServletRequest req,
            final ConectionErrorException ex,
            final Locale locale) {
        final Error error = ErrorUtils.createError(
                ErrorCode.CONECTION_ERROR.getCode(),
                String.format("%s, %s",
                        localizationService.getMessage(ErrorCode.CONECTION_ERROR.getMessageKey(), locale),
                        localizationService.getMessage(ex.getMessage(), locale)),
                HttpStatus.SERVICE_UNAVAILABLE.value());
        return new ResponseEntity<>(error, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(EntityExistException.class)
    public ResponseEntity<Error> handleEntityExistException(final HttpServletRequest req,
            final EntityExistException ex,
            final Locale locale) {
        final Error error = ErrorUtils.createError(
                ErrorCode.ENTITY_EXISTS.getCode(),
                String.format("%s, %s",
                        localizationService.getMessage(ErrorCode.ENTITY_EXISTS.getMessageKey(), locale),
                        localizationService.getMessage(ex.getMessage(), locale)),
                HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
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

    @ExceptionHandler(NoDataException.class)
    public ResponseEntity<Error> handleNoDataException(final HttpServletRequest req,
            final NoDataException ex,
            final Locale locale) {
        final Error error = ErrorUtils.createError(
                ErrorCode.ENTITY_EXISTS.getCode(),
                String.format("%s, %s",
                        localizationService.getMessage(ErrorCode.NO_DATA.getMessageKey(), locale),
                        localizationService.getMessage(ex.getMessage(), locale)),
                HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
