package net.plyse.google.api.place.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import lombok.AllArgsConstructor;
import net.plyse.google.api.place.exchange.DataExchange;
import net.plyse.google.api.place.model.Request;
import net.plyse.google.api.place.model.TextSearchRequest;
import net.plyse.google.api.place.model.TextSearchResponse;

import java.io.IOException;


@AllArgsConstructor
public class TextSearch implements Search<TextSearchResponse> {

    private final DataExchange dataExchange;
    private final ObjectReader READER = new ObjectMapper().readerFor(TextSearchResponse.class);

    @Override
    public TextSearchResponse search(Request request) throws IOException {
        String body = dataExchange.executeGetRequest(request.getUrl());
        return READER.readValue(body, TextSearchResponse.class);
    }

    public TextSearchResponse nextPage(String token) throws IOException {
        TextSearchRequest request = new TextSearchRequest();
        request.setQuery("");
        request.setPageToken(token);
        return search(request);
    }

}
