package net.plyse.google.api.place.exception;

/**
 * Thrown when no API key has been defined.
 *
 * @author Raphael Dichler on 17.07.2022.
 */
public class ApiKeyNotFoundException extends RuntimeException {

    public ApiKeyNotFoundException() {
    }

    public ApiKeyNotFoundException(String message) {
        super(message);
    }
}
