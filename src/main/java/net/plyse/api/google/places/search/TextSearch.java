package net.plyse.api.google.places.search;

import net.plyse.api.google.places.filter.Filter;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class TextSearch<T> extends Searchable<T> implements PageSearchable<T> {


    @Override
    public void nextPage(T t) {
        throw new NotImplementedException();
    }

    @Override
    public final void search(T t, String query) {
        throw new NotImplementedException();
    }

    @Override
    public void filter(T t, Filter filter) {

    }

}
