package net.plyse.google.api.place.model;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    private String[] html_attributions;
    private String photo_reference;
    private int width;

}
