package net.plyse.api.google.places.search;

import net.plyse.api.google.places.filter.Filter;

public abstract class Searchable<T> {

    protected UserManagement<T> userManagement;

    public abstract void search(T t, String query);
    public abstract void filter(T t, Filter filter);

}
