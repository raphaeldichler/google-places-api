package net.plyse.google.api.place.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PlacesSearchStatus {

    // todo: https://developers.google.com/maps/documentation/places/web-service/search-text#PlacesSearchStatus
    private String statusCode;

}
