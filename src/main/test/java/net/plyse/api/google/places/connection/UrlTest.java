package net.plyse.api.google.places.connection;

import net.plyse.api.google.places.exception.InvalidRequestParameter;
import net.plyse.api.google.places.query.field.AtmosphereData;
import net.plyse.api.google.places.query.field.BasicData;
import net.plyse.api.google.places.query.field.ContactData;
import net.plyse.api.google.places.query.field.DataField;
import net.plyse.api.google.places.query.format.OutputType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UrlTest {

//    private static final List<DataField> DATA_FIELDS;
//
//    static {
//        DATA_FIELDS = getAllImplementationOfDataField();
//    }
//
//    private static List<DataField> getAllImplementationOfDataField() {
//        List<DataField> list = new ArrayList<>(50);
//
//        Collections.addAll(list, BasicData.values());
//        Collections.addAll(list, AtmosphereData.values());
//        Collections.addAll(list, ContactData.values());
//
//        return list;
//    }
//
//    static Stream<Arguments> changeDataFieldFail() {
//        List<Arguments> arguments = new ArrayList<>(DATA_FIELDS.size());
//
//        for (DataField currentData : DATA_FIELDS) {
//            Set<DataField> dataFields = new HashSet<>();
//            arguments.add(Arguments
//                    .of(new RequestUrl(RequestUrl.BaseUrl.FIND_PLACE, OutputType.JSON, new HashSet<>(), dataFields),
//                            currentData, false, currentData.toUrlValue()));
//        }
//
//        return arguments.stream();
//    }
//
//    static Stream<Arguments> addDataFieldFail() {
//        List<Arguments> arguments = new ArrayList<>(DATA_FIELDS.size());
//
//        for (DataField currentData : DATA_FIELDS) {
//            Set<DataField> dataFields = new HashSet<>();
//            dataFields.add(currentData);
//            arguments.add(Arguments
//                    .of(new RequestUrl(RequestUrl.BaseUrl.FIND_PLACE, OutputType.JSON, new HashSet<>(), dataFields),
//                            currentData, false, currentData.toUrlValue()));
//        }
//
//        return arguments.stream();
//    }
//
//    static Stream<Arguments> addDataFieldSuccess() {
//        List<Arguments> arguments = new ArrayList<>(DATA_FIELDS.size());
//
//        for (DataField currentData : DATA_FIELDS) {
//            Set<DataField> dataFields = new HashSet<>();
//            arguments.add(Arguments
//                    .of(new RequestUrl(RequestUrl.BaseUrl.FIND_PLACE, OutputType.JSON, new HashSet<>(), dataFields),
//                            currentData, true));
//        }
//
//
//        return arguments.stream();
//    }
//
//    @ParameterizedTest
//    @MethodSource({"addDataFieldSuccess", "addDataFieldFail"})
//    void testAddDataFieldUrl(Url url, DataField addedField, boolean expectedResultAdded) {
//        assertEquals(expectedResultAdded,
//                url.addDataField(addedField));
//        String urlS = url.getUrl();
//        assertTrue(
//                urlS.contains(addedField.toUrlValue()));
//    }
//
//    @ParameterizedTest
//    @MethodSource({ "changeDataFieldFail"})
//    void testChangeDataFieldUrl(Url url, DataField changedField, boolean isSucceed, String expectedResultChanged) {
//        assertEquals(isSucceed,
//                url.changeDataField(changedField));
//        if (!isSucceed) {
//            assertFalse(url.getUrl().contains(expectedResultChanged));
//        } else {
//            assertTrue(url.getUrl().contains(expectedResultChanged));
//        }
//    }
//
//    @Test
//    void testAddInvalidDataField() {
//        Set<DataField> addressComponent = Set.of(
//                BasicData.ADDRESS_COMPONENT, BasicData.ADDRESS, BasicData.TYPE, BasicData.URL, BasicData.UTC_OFFSET,
//                BasicData.VICINITY, ContactData.WEBSITE, ContactData.FORMATTED_PHONE_NUMBER,
//                ContactData.INTERNATIONAL_PHONE_NUMBER, AtmosphereData.REVIEWS
//        );
//
//
//
//        for (DataField dataField : addressComponent) {
//            FindPlace.RequestBuilder requestBuilderFindPlace = new FindPlace.RequestBuilder("query");
//            TextSearch.RequestBuilder requestBuilderTextSearch = new TextSearch.RequestBuilder("query");
//
//
//            assertThrows(InvalidRequestParameter.class, () -> requestBuilderFindPlace.addDataField(dataField));
//            assertThrows(InvalidRequestParameter.class, () -> requestBuilderTextSearch.addDataField(dataField));
//        }
//
//    }

}