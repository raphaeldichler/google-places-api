package net.plyse.api.google.places.util;

import java.io.IOException;

public final class Properties {

    public static final String API_KEY;
    private static final java.util.Properties PROPERTIES;
    private static final String PROPERTY_KEY_FOR_API_KEY = "net.plyse.google.api.key";


    static {
        PROPERTIES = new java.util.Properties();
        try {
            PROPERTIES.load(Properties.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Cloud not found the config.properties in the resources folder");
        }

        API_KEY = loadApiKey();

        if (API_KEY == null) {
            throw new RuntimeException("Cloud not found the property key for the API-Key. (should be "
                    +PROPERTY_KEY_FOR_API_KEY + "=YOUR_API_KEY)");
        }
    }

    private static String loadApiKey() {
        return PROPERTIES.getProperty(PROPERTY_KEY_FOR_API_KEY);
    }

    private Properties() {
        throw new IllegalCallerException("PropertyLoader cannot be instantiated.");
    }

}
