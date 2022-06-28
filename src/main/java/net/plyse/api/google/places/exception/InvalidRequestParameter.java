package net.plyse.api.google.places.exception;

/**
 * @author Raphael Dichler on 28.06.2022.
 */
public class InvalidRequestParameter extends RuntimeException {

    public InvalidRequestParameter(String message) {
        super(message);
    }

}
