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
public class TextSearchResponse implements Response {

    @JsonProperty("html_attributions")
    private String[] html_attributions;
    private Place[] results;
    private PlacesSearchStatus status;
    private String errorMessage;
    private String[] infoMessages;
    private String next_page_token;

}
