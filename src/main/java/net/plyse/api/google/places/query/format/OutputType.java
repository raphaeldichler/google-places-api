package net.plyse.api.google.places.query.format;


/**
 * Indicates the format in which the request should be returned.
 * <br>
 * @author Raphael Dichler on 28.06.2022.
 */
public enum OutputType {

    JSON("json"),
    XML("xml");

    private final String type;

    OutputType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return type;
    }

}
