package com.animal_match_duel.backend.infraestructure.input.exception.own;

import com.animal_match_duel.backend.infraestructure.input.exception.structure.ErrorCode;

import lombok.Getter;

@Getter
public class EntityExistException extends RuntimeException {
    private final String messageKey;
    private final String code;

    public EntityExistException(ErrorCode code) {
        this.code = code.getCode();
        this.messageKey = code.getMessageKey();
    }

    public EntityExistException(final String message) {
        super(message);
        this.code = ErrorCode.ENTITY_EXISTS.getCode();
        this.messageKey = ErrorCode.ENTITY_EXISTS.getMessageKey();
    }

}
