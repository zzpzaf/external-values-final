package com.zzpzaf.se.devxperiences.posts.externalvalues.Properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UnmanagedProperties {


    private static Properties uProperties = new Properties();
    private static String resourceFileName;
    private static String resourceFileNameDefault = "uMessages.properties";



    public static String getUMessage(String key) {
        //System.out.println(" ===>>> Unmanaged Bean Messages!!!");

        if (uProperties.containsKey(key)) {
            //System.out.println(" ===>>> Message is existing !!!");
            return uProperties.getProperty(key);
        }

        resourceFileName = resourceFileNameDefault;
        //System.out.println(" ===>>> Resource File Name: " + resourceFileName + "file");
        try {
          //System.out.println(" ===>>> Loading external Properties File: " +  resourceFileName); 
          uProperties = loadUProperties(resourceFileName);
        } catch (IOException e) {
          //System.out.println(" ===>>> Error reading the " + resourceFileName + "file");
        }
        return uProperties.getProperty(key);
    }

    public static String getUMessage(String resFile, String key)  {
        if (!resFile.trim().isEmpty()) {
          resourceFileName = resFile;
        }  
        
        try {
          uProperties = loadUProperties(resourceFileName);
        } catch (IOException e) {
          //System.out.println(" ===>>> Error reading the " + resourceFileName + "file");
        }

      return uProperties.getProperty(key);
    }




    private static Properties loadUProperties(String resourceFileName) throws IOException {

        //Properties uProperties = new Properties();
      
            InputStream inputStream = UnmanagedProperties.class
            .getClassLoader()
            .getResourceAsStream(resourceFileName);

        uProperties.load(inputStream);
        
        inputStream.close();
        
        return uProperties;



        
    }
    
}
