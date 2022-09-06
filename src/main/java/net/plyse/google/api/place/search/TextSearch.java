package net.plyse.google.api.place.search;


import lombok.AllArgsConstructor;
import net.plyse.google.api.place.model.request.TextSearchRequest;
import net.plyse.google.api.place.exchange.DataExchange;
import net.plyse.google.api.place.model.TextSearchResponse;

import java.io.IOException;

@AllArgsConstructor
public class TextSearch extends Search<TextSearchRequest, TextSearchResponse> {

    private final DataExchange<TextSearchRequest, TextSearchResponse> dataExchange;

    @Override
    public TextSearchResponse search(TextSearchRequest textSearchRequest) throws IOException {
        return dataExchange.getRequest(textSearchRequest);
    }
}
