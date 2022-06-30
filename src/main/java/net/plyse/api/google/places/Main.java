package net.plyse.api.google.places;

import net.plyse.api.google.places.connection.FindPlace;
import net.plyse.api.google.places.query.field.BasicData;
import net.plyse.api.google.places.query.field.DataField;
import net.plyse.api.google.places.query.format.OutputType;
import net.plyse.api.google.places.query.parameter.LanguageParameter;

/**
 * @author Raphael Dichler on 28.06.2022.
 */
public class Main {

    public static void main(String[] args) {


        FindPlace findPlace = new FindPlace.RequestBuilder(OutputType.JSON)
                .addParameter(LanguageParameter.ENGLISH)
                .addDataField(BasicData.FORMATTED_ADDRESS)
                .build();

        findPlace.execute();

    }


}
