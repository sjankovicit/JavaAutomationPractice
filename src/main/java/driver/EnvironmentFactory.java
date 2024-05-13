package driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentFactory {
    private static String envType() {
        String envType = null;

        final String globalPath = new File("").getAbsolutePath();

        try {
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream(globalPath + "/src/main/java/properties/config.properties");
            properties.load(file);
            envType = properties.getProperty("env").toLowerCase().trim();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return envType;
    }

    public static String setEnvType(){
        String environment = null;
        switch (envType()) {
            case "int" -> {
                environment = "https://automationtesting.co.uk/mouse.html";
            }
            case "pp" -> {
                environment = "https://www.facebook.com";
            }
            case "dev" -> {
                environment = "https://www.instagram.com";
            }
        }
        return environment;
    }






}
