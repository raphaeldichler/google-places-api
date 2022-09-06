package net.plyse.google.api.place.exchange;

import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OkHttpDataExchange<T, K> implements DataExchange<T, K> {

    private final OkHttpClient httpClient = new OkHttpClient();

    @Override
    public K getRequest(T url) throws IOException {
        /*
         Request getRequest = new Request.Builder()
                .url(url)
                .build();


        try (Response response = httpClient.newCall(getRequest).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
         */
        return null;
    }
}
