package tasks;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by oleg on 19.01.2021.
 */
public class T2441478 extends Task {
    String taskId;
    WebDriver driver;

    public T2441478(String taskId, WebDriver driver) {
        this.taskId = taskId;
        this.driver = driver;
    }


    public StringBuilder work(Logger log) {
        navigatorHelper.switchToLastTab(driver);
        String linkInsideFacebook = "//a[contains(@href, 'https://l.facebook.com/l.php')]";
       // String listOfResultXPath = "//div[@class='vc_btn3-container vc_btn3-inline']/a";
        String listOfResultXPath = "//div[@id='___gcse_0']/following-sibling::center//a";
        StringBuilder sbResult = new TaskSerchOnly(driver).doTaskSerchOnly(linkInsideFacebook, listOfResultXPath, log, 2);
        return sbResult;
    }
}
