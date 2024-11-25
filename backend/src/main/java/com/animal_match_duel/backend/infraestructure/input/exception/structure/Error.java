/**Package that define the own exception structure */
package com.animal_match_duel.backend.infraestructure.input.exception.structure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Error class: Define the structure of response messages.
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Error {
    /** Own Error code */
    private String errorCode;
    /** Personalice message error */
    private String message;
    /** Error response code {@code 4xx} or {@code 5xx} */
    private Integer httpCode;
    /** Endpoint called */
    @Accessors(chain = true)
    private String url;
    /** Http Method used */
    @Accessors(chain = true)
    private String method;
}
