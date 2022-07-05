package net.plyse.api.google.places.connection;

import okhttp3.OkHttpClient;


public class OkHttp3RequestHandler {

    //TODO: Apply strategy pattern to change how to handle requests
    private final OkHttpClient httpClient;

    private OkHttp3RequestHandler() {
        this.httpClient = new OkHttpClient();
    }

    public static class Builder {



        public OkHttp3RequestHandler build() {
            return new OkHttp3RequestHandler();
        }


    }


}
