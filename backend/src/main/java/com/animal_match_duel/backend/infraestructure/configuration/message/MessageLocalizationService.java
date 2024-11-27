package com.animal_match_duel.backend.infraestructure.configuration.message;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class MessageLocalizationService {
    private final MessageSource messageSource;

    public MessageLocalizationService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String key, Locale locale) {
        return this.messageSource.getMessage(key, null, locale);
    }
}
