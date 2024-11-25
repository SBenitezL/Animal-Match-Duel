package com.animal_match_duel.backend.infraestructure.input.exception.structure;

import java.util.ResourceBundle;

import com.animal_match_duel.backend.infraestructure.configuration.locator.LocalContextHolder;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    GENERIC_ERROR("GC-0001"),
    ENTITY_NOT_FOUND("GC-0002"),
    ENTITY_EXISTS("GC-0003"),
    BUSINESS_RULE_VIOLATION("GC-0004"),
    NO_DATA("GC-0005"),
    BAD_FORMAT("GC-0006"),
    CONECTION_ERROR("GC-0007");

    private final String code;

    public String getMessage() {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", LocalContextHolder.getLocal());
        return bundle.getString(this.name());
    }
}
