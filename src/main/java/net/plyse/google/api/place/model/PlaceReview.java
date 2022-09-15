package net.plyse.google.api.place.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PlaceReview {

    private String author_name;
    private int rating;
    private String relative_time_description;
    private long time;
    private String author_url;
    private String language;
    private String profile_photo_url;
    private String text;

}
