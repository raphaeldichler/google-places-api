package net.plyse.api.google.places.exchange;

import okhttp3.OkHttpClient;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class OkHttp3Strategy implements DataExchangeStrategy<T> {

    private static final OkHttp3Strategy INSTANCE = new OkHttp3Strategy();

    private final OkHttpClient client;

    public static OkHttp3Strategy getInstance() {
        return INSTANCE;
    }

    private OkHttp3Strategy() {
        this.client = new OkHttpClient();
    }

    @Override
    public T getRequest(URL url) {
        throw new NotImplementedException();
    }

}
