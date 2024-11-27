package com.animal_match_duel.backend.infraestructure.input.exception.own;

import com.animal_match_duel.backend.infraestructure.input.exception.structure.ErrorCode;

import lombok.Getter;

@Getter
public class BusinessRuleViolationException extends RuntimeException {
    private final String messageKey;
    private final String code;

    public BusinessRuleViolationException(ErrorCode code) {
        this.code = code.getCode();
        this.messageKey = code.getMessageKey();
    }

    public BusinessRuleViolationException(final String message) {
        super(message);
        this.code = ErrorCode.BUSINESS_RULE_VIOLATION.getCode();
        this.messageKey = ErrorCode.BUSINESS_RULE_VIOLATION.getMessageKey();
    }
}
