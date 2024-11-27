package com.animal_match_duel.backend.application.output.formatter;

/**
 * Esta interfaz define los métodos para formatear y manejar excepciones y
 * mensajes de error
 */
public interface ExceptionFormatterIntPort {
    /**
     * Give format to response Entity Not Found.
     * 
     * @param message personalized messaged error.
     */
    void returnResponseEntityNotFound(String message);
}
