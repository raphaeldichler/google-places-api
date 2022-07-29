package net.plyse.google.api.place.exchange;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Service
public class OkHttpDataExchange implements DataExchange {

    private final OkHttpClient httpClient = new OkHttpClient();

    @Override
    public String getRequest(String url) throws IOException {
        Request getRequest = new Request.Builder()
                .url(url)
                .build();

        try (Response response = httpClient.newCall(getRequest).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }

}
