package net.plyse.google.api.place.model;

import net.plyse.google.api.place.exception.MissingParameterException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Raphael Dichler on 17.09.2022.
 */
class TextSearchRequestTest {

    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/place/textsearch/" ;

    private final String TEXT_SEARCH_BASE_URL = BASE_URL + Utility.OUTPUT_FORMAT + "&key=" + Utility.API_KEY;



    @Test
    void urlQueryOnlyTest() {
        TextSearchRequest textSearchRequest = new TextSearchRequest("query");
        assertEquals(TEXT_SEARCH_BASE_URL + "&query=query", textSearchRequest.getUrl());
    }

    @Test
    void completeUrlTest() {
        TextSearchRequest t = new TextSearchRequest("query2");
        assertEquals(TEXT_SEARCH_BASE_URL + "&query=query2", t.getUrl());
    }

    @Test
    void missingQueryParameterTextSearchTest() {
        assertThrows(MissingParameterException.class, () -> new TextSearchRequest(""));
        assertThrows(MissingParameterException.class, () -> new TextSearchRequest(null));
    }

    static Stream<Arguments> textSearchTest() {
        return Stream.of(
                Arguments.of(new TextSearchRequest("query"),new String[]{"&query=query"}),
                Arguments.of(new TextSearchRequest("query")
                        .addParameter(RequestParameter.QUERY, "tmp"), new String[]{"&query=tmp"}),
                Arguments.of(new TextSearchRequest("query")
                        .addParameter(RequestParameter.MAX_PRICE, 2), new String[]{"&query=query", "&maxprice=2"}),
                Arguments.of(new TextSearchRequest("query")
                        .addParameter(RequestParameter.OPEN_NOW, true), new String[]{"&query=query", "&opennow=true"}),
                Arguments.of(new TextSearchRequest("query").
                        addParameter(RequestParameter.LOCATION, new LatLngLiteral(5,6)), new String[]{"&location=5.0%2C6.0", "&query=query"}),
                Arguments.of(new TextSearchRequest("query").
                        addParameter(RequestParameter.LOCATION, 5,6), new String[]{"&location=5.0%2C6.0", "&query=query"})
        );
    }

    @ParameterizedTest
    @MethodSource({"textSearchTest"})
    void urlTest(Request request, String[] containingParameter) {
        String url = request.getUrl();
        for (String s : containingParameter) {
            assertTrue(url.contains(s));
        }
    }


}