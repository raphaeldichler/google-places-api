package net.plyse.google.api.place.search;

import lombok.AllArgsConstructor;
import net.plyse.google.api.place.exchange.DataExchange;
import net.plyse.google.api.place.model.TextSearchRequest;
import net.plyse.google.api.place.model.TextSearchResponse;

import java.io.IOException;


@AllArgsConstructor
public class TextSearch extends Search<TextSearchRequest, TextSearchResponse> {

    private final DataExchange dataExchange;

    @Override
    public TextSearchResponse search(TextSearchRequest request) throws IOException {
        String body = dataExchange.getRequest(request.getUrl());
        // TODO create TextSearchResponse with body information
        return new TextSearchResponse();
    }

}
