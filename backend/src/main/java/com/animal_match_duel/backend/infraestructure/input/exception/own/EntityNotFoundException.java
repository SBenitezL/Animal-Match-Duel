package com.animal_match_duel.backend.infraestructure.input.exception.own;

import java.util.Locale;

import com.animal_match_duel.backend.infraestructure.input.exception.structure.ErrorCode;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException {
    private final String messageKey;
    private final String code;
    private final Locale locale;

    public EntityNotFoundException(Locale locale, ErrorCode code) {
        this.locale = locale;
        this.code = code.getCode();
        this.messageKey = code.getMessage();
    }

    public EntityNotFoundException(Locale locale, final String message) {
        super(message);
        this.locale = locale;
        this.code = ErrorCode.ENTITY_NOT_FOUND.getCode();
        this.messageKey = ErrorCode.ENTITY_NOT_FOUND.getMessage();
    }

}
