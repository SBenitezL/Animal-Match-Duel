package com.animal_match_duel.backend.infraestructure.input.exception.own;

import com.animal_match_duel.backend.infraestructure.input.exception.structure.ErrorCode;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException {
    private final String messageKey;
    private final String code;

    public EntityNotFoundException(ErrorCode code) {
        this.code = code.getCode();
        this.messageKey = code.name();
    }

    public EntityNotFoundException(final String message) {
        super(message);
        this.code = ErrorCode.ENTITY_NOT_FOUND.getCode();
        this.messageKey = ErrorCode.ENTITY_NOT_FOUND.name();
    }

}
