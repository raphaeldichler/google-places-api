package net.plyse.google.api.place.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Place {

    private List<AddressComponent> addressComponents;
    private String adrAddress;
    private String businessStatus;
    private String formattedAddress;
    private String formattedPhoneNumber;
    private Geometry geometry;
    private String icon;
    private String iconBackgroundColor;
    private String iconMaskBaseUri;
    private String internationalPhoneNumber;
    private String name;
    private PlaceOpeningHours openingHours;
    private List<PlacePhoto> photos;
    private String placeId;
    private PlusCode plusCode;
    private int priceLevel;
    private float rating;
    private List<PlaceReview> reviews;
    private List<String> types;
    private String url;
    private int userRatingsTotal;
    private int utcOffset;
    private String vicinity;
    private String website;

}
