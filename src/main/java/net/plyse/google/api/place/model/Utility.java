package net.plyse.google.api.place.model;

import net.plyse.google.api.place.exception.ApiKeyNotFoundException;
import net.plyse.google.api.place.exception.OutputFormatNotFoundException;

import java.io.IOException;
import java.util.Properties;

final class Utility {

    private final static String CONFIG_FILE_NAME = "config.properties";
    private final static String OUTPUT_FORMAT_PROPERTY = "google.api.places.output";
    private final static String API_KEY_PROPERTY = "google.api.places.api-key";

    static String API_KEY;
    static String OUTPUT_FORMAT;


    static {
        Properties prop = new Properties();
        try {
            prop.load(Utility.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME));
            OUTPUT_FORMAT = prop.getProperty(OUTPUT_FORMAT_PROPERTY);
            API_KEY = prop.getProperty(API_KEY_PROPERTY);

            if (API_KEY == null) {
                throw new ApiKeyNotFoundException();
            }
            if (OUTPUT_FORMAT == null) {
                throw new OutputFormatNotFoundException();
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }



}
