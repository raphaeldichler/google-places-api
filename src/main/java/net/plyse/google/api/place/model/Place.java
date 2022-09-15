package net.plyse.google.api.place.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Place {

    private List<AddressComponent> addressComponents;
    private String adr_address;
    private String business_status;
    private String formatted_address;
    private String formatted_phone_number;
    private Geometry geometry;
    private String icon;
    private String icon_background_color;
    private String icon_mask_base_uri;
    private String international_phone_number;
    private String name;
    private PlaceOpeningHours opening_hours;
    private boolean permanently_closed;
    private List<PlacePhoto> photos;
    private String place_id;
    private PlusCode plus_code;
    private int price_level;
    private float rating;
    private String reference;
    private List<PlaceReview> reviews;
    private List<String> types;
    private String url;
    private int user_ratings_total;
    private int utc_offset;
    private String vicinity;
    private String website;

}
