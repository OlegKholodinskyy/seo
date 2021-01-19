package helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by oleg on 24.05.2020.
 */
public class LoginHelper {

    private static String loginSeo;
    private static String passSeo;
    private static String loginFacebook;
    private static String passFacebook;

    public LoginHelper() {
    }

    public static String getLoginSeo() {
        return loginSeo;
    }
    public static String getPassSeo() {
        return passSeo;
    }
    public static String getLoginFacebook() {
        return loginFacebook;
    }
    public static String getPassFacebook() {
        return passFacebook;
    }


    static {
        Properties property = new Properties();
        FileInputStream fis;

        String path = new File("").getAbsolutePath();
        String pathToProperties = (path + "/login.properties");

        try {

            fis = new FileInputStream(pathToProperties);
            property.load(fis);

            loginSeo = property.getProperty("loginSeo");
            passSeo = property.getProperty("passSeo");
            loginFacebook = property.getProperty("loginFacebook");
            passFacebook = property.getProperty("passFacebook");

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }

}