package net.plyse.google.api.place.search;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import lombok.AllArgsConstructor;
import net.plyse.google.api.place.exchange.DataExchange;
import net.plyse.google.api.place.model.NearbySearchRequest;
import net.plyse.google.api.place.model.NearbySearchResponse;

import java.io.IOException;

/**
 * @author Raphael Dichler on 17.09.2022.
 */
@AllArgsConstructor
public class NearbySearch implements Search<NearbySearchResponse, NearbySearchRequest>, PageSearch<NearbySearchResponse> {

    private final DataExchange dataExchange;
    private final ObjectReader READER = new ObjectMapper().readerFor(NearbySearchResponse.class);

    @Override
    public NearbySearchResponse search(NearbySearchRequest request) throws IOException {
        String body = dataExchange.executeGetRequest(request.getUrl());
        return READER.readValue(body, NearbySearchResponse.class);
    }

    @Override
    public NearbySearchResponse search(String pageToken) throws IOException {
        NearbySearchRequest request;
        return null;
    }
}
