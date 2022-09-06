package net.plyse.google.api.place.search;


import lombok.AllArgsConstructor;
import net.plyse.google.api.place.controller.request.TextSearchRequest;
import net.plyse.google.api.place.exchange.DataExchange;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class TextSearch extends Search<TextSearchRequest> {

    private final DataExchange dataExchange;

    @Override
    public String search(TextSearchRequest textSearchRequest) throws IOException {
        return null;
    }
}
