package net.plyse.api.google.places.search;

import net.plyse.api.google.places.filter.Filter;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @param <T>
 */
public class TextSearch<T> extends Searchable<T> implements PageSearchable<T> {

    private static final TextSearch INSTANCE = new TextSearch();

    private TextSearch() {
    }


    public static TextSearch getInstance() {
        return INSTANCE;
    }

    @Override
    public void nextPage(T t) {
        throw new NotImplementedException();
    }

    @Override
    public void search(T t, String query) {

    }

    @Override
    public void filter(T t, Filter filter) {

    }

}
