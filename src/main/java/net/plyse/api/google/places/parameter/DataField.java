package net.plyse.api.google.places.parameter;

import net.plyse.api.google.places.connection.FindPlace;
import net.plyse.api.google.places.connection.NearbySearch;
import net.plyse.api.google.places.connection.TextSearch;
import net.plyse.api.google.places.exception.InvalidRequestParameter;

/**
 * {@link DataField} are parameters that can be added to an API request to get additional information.  <br>
 * Queries to PlaceSearch (aka {@link FindPlace}), NearbySearch (aka {@link NearbySearch}),
 * and TextSearch (aka {@link TextSearch}) allow all DataFields in {@link DataField}, except the following:
 * <ul>
 *     <li>{@link DataField#ADDRESS_COMPONENT}</li>
 *     <li>{@link DataField#ADDRESS}</li>
 *     <li>{@link DataField#FORMATTED_PHONE_NUMBER}</li>
 *     <li>{@link DataField#INTERNATIONAL_PHONE_NUMBER}</li>
 *     <li>{@link DataField#REVIEWS}</li>
 *     <li>{@link DataField#TYPE}</li>
 *     <li>{@link DataField#URL}</li>
 *     <li>{@link DataField#UTC_OFFSET}</li>
 *     <li>{@link DataField#VICINITY}</li>
 *     <li>{@link DataField#WEBSITE}</li>
 * </ul>
 * <p>
 * If one of the following parameters is added to {@link FindPlace}, {@link NearbySearch} or {@link TextSearch},
 * the error {@link InvalidRequestParameter} is thrown.
 * If you need this information, you have to request it via PlaceDetails.
 *
 * @author Raphael Dichler on 28.06.2022.
 */
public enum DataField implements RequestField {

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

    DataField(String type) {
        this.type = type;
    }

    @Override
    public String toUrlValue() {
        return type;
    }

}
