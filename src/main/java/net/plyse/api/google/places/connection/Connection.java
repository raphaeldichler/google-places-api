package net.plyse.api.google.places.connection;

/**
 * @author Raphael Dichler on 28.06.2022.
 */
public interface Connection {

    void setUrl(String url);

    String getUrl();

    void load();

}
