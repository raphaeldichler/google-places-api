package net.plyse.google.api.place.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FindPlaceResponse implements Response {

    private Place[] candidates;
    private PlacesSearchStatus status;
    private String error_message;
    private String[] info_messages;

}
