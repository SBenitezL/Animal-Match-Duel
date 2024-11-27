package com.animal_match_duel.backend.infraestructure.input.exception.own;

import com.animal_match_duel.backend.infraestructure.input.exception.structure.ErrorCode;

import lombok.Getter;

@Getter
public class ConectionErrorException extends RuntimeException {
    private final String messageKey;
    private final String code;

    public ConectionErrorException(ErrorCode code) {
        this.code = code.getCode();
        this.messageKey = code.getMessageKey();
    }

    public ConectionErrorException(final String message) {
        super(message);
        this.code = ErrorCode.CONECTION_ERROR.getCode();
        this.messageKey = ErrorCode.CONECTION_ERROR.getMessageKey();
    }
}
