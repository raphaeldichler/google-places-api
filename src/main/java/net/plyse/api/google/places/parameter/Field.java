package net.plyse.api.google.places.parameter;

/**
 * @author Raphael Dichler on 28.06.2022.
 */
public enum Field implements RequestField {

    ADDRESS_COMPONENT("address_component"),
    ADDRESS("adr_address"),
    BUSINESS_STATUS("business_status"),
    FORMATTED_ADDRESS("formatted_address"),
    VIEWPORT("geometry/viewport"),
    LOCATION("geometry/location"),
    ICON("icon"),
    ICON_MASK_BASE_URI("icon_mask_base_uri"),
    ICON_BACKGROUND_COLOR("icon_background_color\t"),
    NAME("name"),
    PHOTOS("photos"),
    PLACE_ID("place_id"),
    PLUS_CODE("plus_code"),
    TYPE("type"),
    URL("url"),
    UTC_OFFSET("utc_offset"),
    VICINITY("vicinity"),

    // Contact
    FORMATTED_PHONE_NUMBER("formatted_phone_number"),
    INTERNATIONAL_PHONE_NUMBER("international_phone_number"),
    OPENING_HOURS("opening_hours"),
    WEBSITE("website"),

    //Atmosphere
    PRICE_LEVEL("price_level"),
    RATING("rating"),
    REVIEWS("reviews"),
    USER_RATINGS_TOTAL("user_ratings_total");

    private final String type;

    Field(String type) {
        this.type = type;
    }

    @Override
    public String toUrlValue() {
        return type;
    }

}
