package net.plyse.api.google.places.exception;

/**
 * @author Raphael Dichler on 29.06.2022.
 */
public class NoPageTokenExistsException extends RuntimeException {

    public NoPageTokenExistsException(String message) {
        super(message);
    }
}
