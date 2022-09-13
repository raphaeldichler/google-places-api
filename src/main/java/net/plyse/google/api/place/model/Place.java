package net.plyse.google.api.place.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Place {

    private List<AddressComponent> addressComponents;
    @JsonProperty("adr_address")
    private String adr_address;
    @JsonProperty("business_status")
    private String business_status;
    @JsonProperty("formatted_address")
    private String formatted_address;
    @JsonProperty("formatted_phone_number")
    private String formatted_phone_number;
    private Geometry geometry;
    private String icon;
    @JsonProperty("icon_background_color")
    private String icon_background_color;
    @JsonProperty("icon_mask_base_uri")
    private String icon_mask_base_uri;
    @JsonProperty("international_phone_number")
    private String international_phone_number;
    private String name;
    @JsonProperty("opening_hours")
    private PlaceOpeningHours opening_hours;
    @JsonProperty("permanently_closed")
    private boolean permanently_closed;
    private List<PlacePhoto> photos;
    @JsonProperty("place_id")
    private String place_id;
    @JsonProperty("plus_code")
    private PlusCode plus_code;
    @JsonProperty("price_level")
    private int price_level;
    private float rating;
    private String reference;
    private List<PlaceReview> reviews;
    private List<String> types;
    private String url;
    @JsonProperty("user_ratings_total")
    private int user_ratings_total;
    @JsonProperty("utc_offset")
    private int utc_offset;
    private String vicinity;
    private String website;

}
