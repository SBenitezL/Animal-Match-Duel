package com.animal_match_duel.backend.infraestructure.input.exception.own;

import com.animal_match_duel.backend.infraestructure.input.exception.structure.ErrorCode;

import lombok.Getter;

@Getter
public class NoDataException extends RuntimeException {
    private final String messageKey;
    private final String code;

    public NoDataException(ErrorCode code) {
        this.code = code.getCode();
        this.messageKey = code.getMessageKey();
    }

    public NoDataException(final String message) {
        super(message);
        this.code = ErrorCode.NO_DATA.getCode();
        this.messageKey = ErrorCode.NO_DATA.getMessageKey();
    }
}
