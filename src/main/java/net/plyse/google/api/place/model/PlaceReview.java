package net.plyse.google.api.place.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlaceReview {

    @JsonProperty("author_name")
    private String author_name;
    private int rating;
    @JsonProperty("relative_time_description")
    private String relative_time_description;
    private long time;
    @JsonProperty("author_url")
    private String author_url;
    private String language;
    @JsonProperty("profile_photo_url")
    private String profile_photo_url;
    private String text;

}
