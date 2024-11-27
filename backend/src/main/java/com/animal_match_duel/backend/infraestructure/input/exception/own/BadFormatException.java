package com.animal_match_duel.backend.infraestructure.input.exception.own;

import com.animal_match_duel.backend.infraestructure.input.exception.structure.ErrorCode;

import lombok.Getter;

@Getter
public class BadFormatException extends RuntimeException {
    private final String messageKey;
    private final String code;

    public BadFormatException(ErrorCode code) {
        this.code = code.getCode();
        this.messageKey = code.getMessageKey();
    }

    public BadFormatException(final String message) {
        super(message);
        this.code = ErrorCode.BAD_FORMAT.getCode();
        this.messageKey = ErrorCode.BAD_FORMAT.getMessageKey();
    }
}
