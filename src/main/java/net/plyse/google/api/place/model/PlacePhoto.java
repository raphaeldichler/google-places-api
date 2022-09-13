package net.plyse.google.api.place.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlacePhoto {

    private int height;
    @JsonProperty("html_attributions")
    private String[] html_attributions;
    @JsonProperty("photo_reference")
    private String photo_reference;
    private int width;

}
