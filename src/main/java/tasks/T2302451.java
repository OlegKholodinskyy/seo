package tasks;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by oleg on 06.12.2020.
 */
public class T2302451 extends Task {

    String taskId;
    WebDriver driver;

    public T2302451(String taskId, WebDriver driver) {
        this.taskId = taskId;
        this.driver = driver;
    }


    public StringBuilder work(Logger log) {
        String linkFacebook = "https://www.facebook.com/JonUikNo1";
     //   String linkInsideFacebook = "//div[@id='jsc_c_v']//a[contains(@href, '://')]";

        String linkInsideFacebook = "//*[contains(@href, 'https://l.facebook.com/l.php')]";

        ((JavascriptExecutor) driver).executeScript("window.open()");
        navigatorHelper.switchToLastTab(driver);
        driver.get(linkFacebook);
        navigatorHelper.switchToLastTab(driver);
        skipErrorMessage(driver);

        String listOfResultXPath = "//div[@class='vc_btn3-container vc_btn3-inline']/a";
        StringBuilder sbResult = new TaskSerchOnly(driver).doTaskSerchOnly(linkInsideFacebook, listOfResultXPath, log);
        return sbResult;
    }


}