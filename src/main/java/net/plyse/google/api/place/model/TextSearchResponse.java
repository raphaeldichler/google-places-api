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
public class TextSearchResponse {

    private List<String> htmlAttributions;
    private List<Place> results;
    private PlacesSearchStatus status;
    private String errorMessage;
    private List<String> infoMessages;
    private String nextPageToken;

}
