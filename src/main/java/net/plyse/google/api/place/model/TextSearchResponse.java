package net.plyse.google.api.place.model;

import java.util.List;

public class TextSearchResponse {

    private List<String> htmlAttributions;
    private List<Place> results;
    private PlacesSearchStatus status;

    private String errorMessage;
    private List<String> infoMessages;
    private String nextPageToken;

}
