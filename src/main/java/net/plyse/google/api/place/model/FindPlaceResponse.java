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
public class FindPlaceResponse implements Response {

    private Place[] candidates;
    private PlacesSearchStatus status;
    @JsonProperty("error_message")
    private String error_message;
    @JsonProperty("info_messages")
    private String[] info_messages;

}
