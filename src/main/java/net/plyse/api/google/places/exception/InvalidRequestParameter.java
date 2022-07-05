package net.plyse.api.google.places.exception;

/**
 * Is thrown if a parameter of a request is passed which is not allowed.
 *
 * @author Raphael Dichler on 28.06.2022.
 */
public class InvalidRequestParameter extends RuntimeException {

    public InvalidRequestParameter(String message) {
        super(message);
    }

}
