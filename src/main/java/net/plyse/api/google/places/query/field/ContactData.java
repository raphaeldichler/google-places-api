package net.plyse.api.google.places.query.field;

public enum ContactData implements DataField {

    FORMATTED_PHONE_NUMBER("formatted_phone_number"),
    INTERNATIONAL_PHONE_NUMBER("international_phone_number"),
    OPENING_HOURS("opening_hours"),
    WEBSITE("website");

    private final String type;

    ContactData(String type) {
        this.type = type;
    }

    @Override
    public String toUrlValue() {
        return type;
    }

}
