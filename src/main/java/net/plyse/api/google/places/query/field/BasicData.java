package net.plyse.api.google.places.query.field;

public enum BasicData implements DataField {

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
    VICINITY("vicinity");

    private final String type;

    BasicData(String type) {
        this.type = type;
    }

    @Override
    public String toUrlValue() {
        return type;
    }

}
