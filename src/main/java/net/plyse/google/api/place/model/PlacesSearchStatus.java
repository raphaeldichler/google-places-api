package net.plyse.google.api.place.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlacesSearchStatus {

    // todo: https://developers.google.com/maps/documentation/places/web-service/search-text#PlacesSearchStatus
    private String statusCode;

}
