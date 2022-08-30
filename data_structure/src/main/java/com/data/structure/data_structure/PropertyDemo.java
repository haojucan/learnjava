package com.data.structure.data_structure;

import sun.misc.Cleaner;

import java.io.*;
import java.util.Properties;

import static java.lang.System.*;

public class PropertyDemo {
        private static Properties loadProperties(String propertiesFilename)
        {
            Properties prop = new Properties();
            ClassLoader loader = PropertyDemo.class.getClassLoader();

            try (InputStream stream = loader.getResourceAsStream(propertiesFilename))
            {
                if (stream == null) {
                    throw new FileNotFoundException();
                }
                prop.load(stream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return prop;
        }

        public static void main(String[] args)
        {
            String propertiesFilename = "test.properties";        // on classpath
            Properties prop = loadProperties(propertiesFilename);
            printProperties(prop);
        }

        public static void printProperties(Properties prop)
        {
            prop.stringPropertyNames().stream()
                    .map(key -> key + ":" + prop.getProperty(key))
                    .forEach(out::println);
        }
}
