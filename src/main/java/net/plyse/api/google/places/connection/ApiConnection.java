package net.plyse.api.google.places.connection;

import okhttp3.*;

import java.io.IOException;

/**
 * @author Raphael Dichler on 28.06.2022.
 */
public abstract class ApiConnection {

    private final OkHttpClient client = new OkHttpClient().newBuilder().build();

    protected Response executeSync(Request request) throws IOException {
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.out.println(response.body().string());
//                throw new IOException("Unexpected code " + response);
            }

            System.out.println("Server: " + response.header("Server"));
            System.out.println("Date: " + response.header("Date"));
            System.out.println("Vary: " + response.headers("Vary"));
            return response;
        }
    }

}
