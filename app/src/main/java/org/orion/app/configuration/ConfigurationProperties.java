package org.orion.app.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigurationProperties {

    Logger logger = LoggerFactory.getLogger(ConfigurationProperties.class);

    Map<String, String> values = new HashMap<>();

    InputStream inputStream;

    public Map<String, String> getValues() throws IOException {

        try{

            Properties prop = new Properties();

            String propFilename = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFilename);

            if(inputStream != null) {

                prop.load(inputStream);

            }else {
                throw new FileNotFoundException("property file " + propFilename + "' not found in the classpath");
            }

            String user = prop.getProperty("user");
            values.put("user",user);

            String password = prop.getProperty("password");
            values.put("password",password);

        }catch (Exception e) {

            logger.info("Problème dans la lecture du fichier config",e);

        }finally {

            inputStream.close();
        }

        return values;

    }
}
