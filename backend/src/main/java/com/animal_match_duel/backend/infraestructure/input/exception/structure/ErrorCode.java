package com.animal_match_duel.backend.infraestructure.input.exception.structure;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    GENERIC_ERROR("GC-0001", "error.generic_error.default"),
    ENTITY_NOT_FOUND("GC-0002", "error.entity_not_found.default"),
    ENTITY_EXISTS("GC-0003", "error.entity_exist.default"),
    BUSINESS_RULE_VIOLATION("GC-0004", "error.business_rule_violation.default"),
    NO_DATA("GC-0005", "error.no_data.default"),
    BAD_FORMAT("GC-0006", "error.bad_format.default"),
    CONECTION_ERROR("GC-0007", "error.conection_error.default");

    private final String code;
    private final String messageKey;
}
