package helpers;

import org.openqa.selenium.WebDriver;

import java.util.Random;

/**
 * Created by oleg on 26.11.2020.
 */
public class NavigatorHelper {
    private WebDriver driver;

    public NavigatorHelper(WebDriver driver) {
        this.driver = driver;
    }

    public static void switchToLastTab(WebDriver driver) {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
    }

    public static void timeout(int min, int max) {
        int diff = new Random().nextInt(max - min);
        int time = min + diff;
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            // do not check
        }
    }

    public  void closeAllTabsExceptSome (WebDriver driver, String windowsHenlde) {
        for(String handle : driver.getWindowHandles()) {
            if (!handle.equals(PageKeeper.getInstance().getPages().get(windowsHenlde))) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.switchTo().window(PageKeeper.getInstance().getPages().get(windowsHenlde));
    }


}
