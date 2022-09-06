package net.plyse.google.api.place.search;

import net.plyse.google.api.place.exchange.DataExchange;

import java.io.IOException;

public abstract class Search<T, K> {

    protected DataExchange<T, K> dataExchange;

    public abstract K search(T t) throws IOException;


}
