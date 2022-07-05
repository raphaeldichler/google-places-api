package net.plyse.api.google.places.query.parameter;


/**
 * @author Raphael Dichler on 28.06.2022.
 */
public enum LanguageParameter implements Parameter {

    GERMAN("de"),
    ENGLISH("en");

    // TODO: add other lang: https://developers.google.com/maps/faq#languagesupport

    private final String type;

    LanguageParameter(String type) {
        this.type = type;
    }

    @Override
    public String toUrlValue() {
        return "language=" + type;
    }
}
