package net.plyse.google.api.place.search;


import net.plyse.google.api.place.model.Request;
import net.plyse.google.api.place.model.Response;

import java.io.IOException;

public abstract class Search<K extends Request, V extends Response> {

    public abstract V search(K request) throws IOException;


}
