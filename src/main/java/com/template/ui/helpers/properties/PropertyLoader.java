package com.template.ui.helpers.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import static com.template.ui.helpers.properties.PropertySource.USER;


public class PropertyLoader {

    private static Properties prop = new Properties();


    private static Properties preloadProperties(PropertySource source) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream resourceStream = loader.getResourceAsStream(source.sourceFile)) {
            Properties properties = new Properties();
            properties.load(resourceStream);
            prop.put(source, properties);
            return properties;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidPropertiesFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String loadUserDataProperty(String propertyName) {
        Properties properties = (Properties) prop.get(USER);
        if (properties == null)
            properties = preloadProperties(USER);
        String property = properties.getProperty(propertyName);
        if (property == null) {
            return "No property file found";
        } else {
            return property;
        }
    }
}

