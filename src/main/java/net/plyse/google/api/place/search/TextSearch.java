package net.plyse.google.api.place.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import lombok.AllArgsConstructor;
import net.plyse.google.api.place.exchange.DataExchange;
import net.plyse.google.api.place.model.RequestParameter;
import net.plyse.google.api.place.model.TextSearchRequest;
import net.plyse.google.api.place.model.TextSearchResponse;

import java.io.IOException;

@AllArgsConstructor
public class TextSearch implements Search<TextSearchResponse, TextSearchRequest> {

    private final DataExchange dataExchange;
    private final ObjectReader READER = new ObjectMapper().readerFor(TextSearchResponse.class);

    @Override
    public TextSearchResponse search(TextSearchRequest request) throws IOException {
        String body = dataExchange.executeGetRequest(request.getUrl());
        return READER.readValue(body, TextSearchResponse.class);
    }

    public TextSearchResponse nextPage(String token) throws IOException {
        TextSearchRequest request = new TextSearchRequest("")
                .addParameter(RequestParameter.PAGE_TOKE, token);
        return search(request);
    }

}
