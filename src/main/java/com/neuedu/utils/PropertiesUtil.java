package com.neuedu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
   private static final String FILEPATH="properties/conf.properties";
    public static String getValue(String key){
        Properties properties=new Properties();
       InputStream inputStream= PropertiesUtil.class.getClassLoader().getResourceAsStream(FILEPATH);

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return   properties.getProperty(key);
    }
    public static String getValue(String filePath,String key){
        Properties properties=new Properties();
        InputStream inputStream= PropertiesUtil.class.getClassLoader().getResourceAsStream(filePath);

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return   properties.getProperty(key);
    }

}
