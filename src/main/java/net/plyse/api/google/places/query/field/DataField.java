package net.plyse.api.google.places.query.field;

import net.plyse.api.google.places.connection.FindPlace;
import net.plyse.api.google.places.connection.NearbySearch;
import net.plyse.api.google.places.connection.TextSearch;
import net.plyse.api.google.places.exception.InvalidRequestParameter;

/**
 * {@link AtmosphereData} are parameters that can be added to an API request to get additional information.  <br>
 * Queries to PlaceSearch (aka {@link FindPlace}), NearbySearch (aka {@link NearbySearch}),
 * and TextSearch (aka {@link TextSearch}) allow all DataFields in, except the following:
 * <ul>
 *     //todo: add
 * </ul>
 * <p>
 * If one of the following parameters is added to {@link FindPlace}, {@link NearbySearch} or {@link TextSearch},
 * the error {@link InvalidRequestParameter} is thrown.
 * If you need this information, you have to request it via PlaceDetails.
 *
 * @author Raphael Dichler on 28.06.2022.
 */
public interface DataField {

    String toUrlValue();

}
