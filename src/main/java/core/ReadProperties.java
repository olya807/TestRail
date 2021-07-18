package core;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    protected Properties properties;

    public ReadProperties() {

        properties = new Properties();

        try {

            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {

        return properties.getProperty("baseUrl");
    }

    public String getBrowser() {

        return properties.getProperty("browser");
    }

    public String getUserName() {

        return properties.getProperty("userName");
    }

    public String getPassword() {

        return properties.getProperty("password");
    }

    public int getTimeout() {

        return Integer.parseInt(properties.getProperty("timeout"));
    }

    public boolean getHeadless() {

        return Boolean.parseBoolean(properties.getProperty("headless"));
    }
}
