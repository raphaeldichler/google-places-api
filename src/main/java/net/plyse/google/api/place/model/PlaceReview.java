package net.plyse.google.api.place.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlaceReview {

    private String authorName;
    private int rating;
    private String relativeTimeDescription;
    private long time;
    private String authorUrl;
    private String language;
    private String profilePhotoUrl;
    private String text;

}
