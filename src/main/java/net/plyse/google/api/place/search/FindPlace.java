package net.plyse.google.api.place.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import lombok.AllArgsConstructor;
import net.plyse.google.api.place.exchange.DataExchange;
import net.plyse.google.api.place.model.FindPlaceRequest;
import net.plyse.google.api.place.model.FindPlaceResponse;

import java.io.IOException;
@AllArgsConstructor
public class FindPlace implements Search<FindPlaceResponse, FindPlaceRequest> {

    private final DataExchange dataExchange;
    private final ObjectReader reader = new ObjectMapper().readerFor(FindPlaceResponse.class);

    @Override
    public FindPlaceResponse search(FindPlaceRequest request) throws IOException {
        String body = dataExchange.executeGetRequest(request.getUrl());
        return reader.readValue(body, FindPlaceResponse.class);
    }

}
