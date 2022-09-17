package net.plyse.google.api.place.search;

import net.plyse.google.api.place.model.Response;

import java.io.IOException;

/**
 * @author Raphael Dichler on 17.09.2022.
 */
public interface PageSearch<V extends Response> {

    V search(String pageToken) throws IOException;

}
