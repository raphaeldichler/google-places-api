package net.plyse.google.api.place.model;

import java.util.List;
import java.util.Optional;

public class TextSearchResponse {

    private List<String> htmlAttributions;
    private List<Place> results;
    private PlacesSearchStatus status;
    private Optional<String> errorMessage;
    private Optional<List<String>> infoMessages;
    private Optional<String> nextPageToken;

}
