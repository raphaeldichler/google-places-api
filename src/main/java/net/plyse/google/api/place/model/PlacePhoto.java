package net.plyse.google.api.place.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
public class PlacePhoto {

    private int height;
    private String[] html_attributions;
    private String photo_reference;
    private int width;

}
