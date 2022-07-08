package net.plyse.api.google.places.search;

import net.plyse.api.google.places.filter.Filter;

import java.util.concurrent.ConcurrentHashMap;

public class UserManagement<T> {

    private ConcurrentHashMap<T, Filter> filterMap;

}
