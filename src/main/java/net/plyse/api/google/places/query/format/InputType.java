package net.plyse.api.google.places.query.format;

/**
 * @author Raphael Dichler on 28.06.2022.
 */
public enum InputType  {

    PHONE_NUMBER("phonenumber"),
    TEXT_QUERY("textquery");

    private final String type;

    InputType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

    public String toUrlValue() {
        return "inputtype=" + type;
    }
}
