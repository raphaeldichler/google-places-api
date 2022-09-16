package net.plyse.google.api.place.exception;

/**
 * Thrown when no Output format has been defined in config.properties.
 *
 * @author Raphael Dichler on 16.09.2022.
 */
public class OutputFormatNotFoundException extends RuntimeException {

    public OutputFormatNotFoundException() {
    }

    public OutputFormatNotFoundException(String message) {
        super(message);
    }
}
