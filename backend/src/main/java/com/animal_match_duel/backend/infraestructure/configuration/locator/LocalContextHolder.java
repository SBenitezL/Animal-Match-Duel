/**Configure a locator */
package com.animal_match_duel.backend.infraestructure.configuration.locator;

import java.util.Locale;

/**
 * Class that hold the Local value of the request
 */
public class LocalContextHolder {
    /**
     * Atribute with the global context
     */
    private static final ThreadLocal<Locale> localHolder = new ThreadLocal<>();

    /**
     * Set the local value in the actual context
     * 
     * @param locale value of Local header
     */
    public static void setLocales(Locale locale) {
        localHolder.set(locale);
    }

    /**
     * Get the actual local context
     * 
     * @return locale value of current request.
     */
    public static Locale getLocal() {
        return localHolder.get();
    }
}
