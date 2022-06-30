package net.plyse.api.google.places.connection;

import okhttp3.Response;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;

public class NearbySearch implements Connection{

    private NearbySearch() {
        throw new IllegalCallerException();
    }

    @Override
    public String getUrl() {
        throw new NotImplementedException();
    }

    @Override
    public Response load() throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public void changeQuery(String query) {
        throw new NotImplementedException();
    }

}
