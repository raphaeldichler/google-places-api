package net.plyse.google.api.place.search;

import lombok.AllArgsConstructor;
import net.plyse.google.api.place.exchange.DataExchange;
import net.plyse.google.api.place.model.FindPlaceResponse;
import net.plyse.google.api.place.model.Request;

import java.io.IOException;
@AllArgsConstructor
public class FindPlace implements Search<FindPlaceResponse> {

    private final DataExchange dataExchange;
    //private final ObjectReader READER = new ObjectMapper().readerFor(FindPlaceResponse.class);

    @Override
    public FindPlaceResponse search(Request request) throws IOException {
        String body = dataExchange.executeGetRequest(request.getUrl());
        return null;// READER.readValue(body, FindPlaceResponse.class);
    }




}
