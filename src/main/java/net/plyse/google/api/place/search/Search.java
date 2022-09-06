package net.plyse.google.api.place.search;

import net.plyse.google.api.place.exchange.DataExchange;
import okhttp3.HttpUrl;

import java.io.IOException;

public abstract class Search<T> {

    protected DataExchange dataExchange;

    public abstract String search(T t) throws IOException;


}
