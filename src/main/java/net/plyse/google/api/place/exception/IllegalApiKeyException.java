package net.plyse.google.api.place.exception;

/**
 * Thrown to indicate that the existing API key does not work.
 *
 * @author Raphael Dichler on 17.07.2022.
 */
public class IllegalApiKeyException extends RuntimeException {

    public IllegalApiKeyException() {
    }

    public IllegalApiKeyException(String message) {
        super(message);
    }

}
