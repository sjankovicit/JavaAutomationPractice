package utils;

import driver.EnvironmentFactory;

public class Global_Vars {
    //Define timeout in seconds
    public static final int DEFAULT_EXPLICIT_TIMEOUT = 20;

    public static final String USERNAME = "testUsername";
    public static final String PASSWORD = "testPassword";


    public static final String URL = EnvironmentFactory.setEnvType();


}
