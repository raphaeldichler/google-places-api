package net.plyse.api.google.places.parameter;


/**
 * @author Raphael Dichler on 28.06.2022.
 */
public enum Language implements RequestPair {

    GERMAN("de"),
    ENGLISH("en");

    // TODO: add other lang: https://developers.google.com/maps/faq#languagesupport

    private final String type;
    private static final String KEY = "language=";

    Language(String type) {
        this.type = type;
    }

    @Override
    public String toUrlValue() {
        return KEY + type;
    }

}
