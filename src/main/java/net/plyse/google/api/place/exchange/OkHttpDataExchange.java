package net.plyse.google.api.place.exchange;

import org.springframework.stereotype.Service;

import java.net.URL;

@Service
public class OkHttpDataExchange implements DataExchange {

    private static String OUTPUT_TYPE;

    @Override
    public String getRequest(URL url) {
        return null;
    }

}
