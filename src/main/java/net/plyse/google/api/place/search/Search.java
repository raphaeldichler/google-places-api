package net.plyse.google.api.place.search;


import net.plyse.google.api.place.model.Request;
import net.plyse.google.api.place.model.Response;

import java.io.IOException;

public interface Search<V extends Response, K extends Request> {

    V search(K request) throws IOException;


}
