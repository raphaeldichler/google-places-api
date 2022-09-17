package net.plyse.google.api.place.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import lombok.AllArgsConstructor;
import net.plyse.google.api.place.exchange.DataExchange;
import net.plyse.google.api.place.model.TextSearchRequest;
import net.plyse.google.api.place.model.TextSearchRequestParameter;
import net.plyse.google.api.place.model.TextSearchResponse;

import java.io.IOException;

@AllArgsConstructor
public class TextSearch implements Search<TextSearchResponse, TextSearchRequest>, PageSearch<TextSearchResponse> {

    private final DataExchange dataExchange;
    private final ObjectReader READER = new ObjectMapper().readerFor(TextSearchResponse.class);

    @Override
    public TextSearchResponse search(TextSearchRequest request) throws IOException {
        String body = dataExchange.executeGetRequest(request.getUrl());
        return READER.readValue(body, TextSearchResponse.class);
    }

    @Override
    public TextSearchResponse search(String pageToken) throws IOException {
        TextSearchRequest request = new TextSearchRequest("-")
                .addParameter(TextSearchRequestParameter.PAGE_TOKE, pageToken);
        return search(request);
    }

}
