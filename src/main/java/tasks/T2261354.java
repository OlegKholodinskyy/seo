package tasks;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by oleg on 06.12.2020.
 */
public class T2261354 extends Task{
    String taskId;
    WebDriver driver;

    public T2261354(String taskId, WebDriver driver) {
        this.taskId = taskId;
        this.driver = driver;
    }


    public StringBuilder work(Logger log) {
        String linkFacebook = "https://www.facebook.com/Mrs-Kasper-Don-104424587633678";
      //  String linkInsideFacebook = "(//div[@id='jsc_c_w']//a[contains(@href, '://')])[2]";
        String linkInsideFacebook = "(//a[contains(@href, 'https://l.facebook.com/l.php')])[2]";
        ((JavascriptExecutor) driver).executeScript("window.open()");
        navigatorHelper.switchToLastTab(driver);
        driver.get(linkFacebook);
        navigatorHelper.switchToLastTab(driver);
        try {
            skipErrorMessage(driver);
        } catch (Exception e){
            log.error("Exception skipErrorMessage();");
        }
        String listOfResultXPath = "//div[@class='vc_btn3-container vc_btn3-inline']/a";
        StringBuilder sbResult = new TaskSerchOnly(driver).doTaskSerchOnly(linkInsideFacebook, listOfResultXPath, log,6);
        return sbResult;
    }
}
