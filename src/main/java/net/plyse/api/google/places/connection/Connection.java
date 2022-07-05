package net.plyse.api.google.places.connection;

import net.plyse.api.google.places.query.format.OutputType;

public interface Connection {

    /**
     * Performs a request to the API.
     * @return Returns the result of the request. The format is determined by the {@link OutputType}.
     */
    String execute();

}
