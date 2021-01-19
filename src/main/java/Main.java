import helpers.NavigatorHelper;
import org.openqa.selenium.BuildInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.StartPageSeo;
import pages.SurfPageSeo;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

/**
 * Created by oleg on 23.11.2020.
 */
@SuppressWarnings("Since15")
public class Main {

    static StartPageSeo startPageSeo;
    static SurfPageSeo surfPageSeo;
    static Map<String, String> pages = new HashMap<String, String>();
    private static final Logger log = Logger.getLogger(Main.class);


    public static void main(String[] a) throws Exception {

//todo  for test only
        Scanner scan = new Scanner(System.in);
        System.out.print("Press any key to continue . . . ");
        scan.nextLine();

        String path = new File("").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", path + "/chromedriver.exe");

        //   System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--disable-blink-features");
        options.addArguments("--disable-blink-features=AutomationControlled");

//        String chrome_path = "C:\\Users\\oleg\\AppData\\Local\\Google\\Chrome\\User Data\\";
//        options.addArguments("user-data-dir="+ chrome_path);

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //NavigatorHelper navigatorHelper = new NavigatorHelper(driver);

        //System.out.println("All Properties: "+System.getProperties().toString());

        BuildInfo info = new BuildInfo();
        String infoString = info.toString();
        System.out.println("BuildInfo:  " + infoString);

        SeoSprint seoSprint = new SeoSprint(driver);
        seoSprint.doAutorize();
        log.info("doAutorize");
        log.error("error");

        seoSprint.doAutorizeFacebook();
        log.info("doAutorizeFacebook");


        seoSprint.doTasks(log);

        System.out.println("job done!");
    }
}
