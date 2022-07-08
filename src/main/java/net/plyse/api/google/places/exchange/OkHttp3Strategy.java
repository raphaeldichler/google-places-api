package net.plyse.api.google.places.exchange;

import okhttp3.OkHttpClient;

public class OkHttp3Strategy implements DataExchangeStrategy {

    private static final OkHttp3Strategy INSTANCE = new OkHttp3Strategy();

    private final OkHttpClient client;

    public static OkHttp3Strategy getInstance() {
        return INSTANCE;
    }

    private OkHttp3Strategy() {
        this.client = new OkHttpClient();
    }

    @Override
    public void getRequest(URL url) {
        throw new IllegalCallerException();
    }

}
