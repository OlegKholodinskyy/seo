package tasks;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

/**
 * Created by oleg on 06.12.2020.
 */
public class T2266359 extends Task {

    String taskId;
    WebDriver driver;

    public T2266359(String taskId, WebDriver driver) {
        this.taskId = taskId;
        this.driver = driver;
    }


    public StringBuilder work(Logger log) {
        String linkFacebook = "https://www.facebook.com/Guy-Julius-Caesar-116122016461538";
        //String linkInsideFacebook = "//div[@id='jsc_c_s']//a[contains(@href, '://')]";
        String linkInsideFacebook = "(//a[contains(@href, 'https://l.facebook.com/l.php')])[2]";
        ((JavascriptExecutor) driver).executeScript("window.open()");
        navigatorHelper.switchToLastTab(driver);
        driver.get(linkFacebook);
        navigatorHelper.switchToLastTab(driver);
        try {
            skipErrorMessage(driver);
        } catch (Exception e){
            System.out.println("Exception skipErrorMessage();");
        }

        String listOfResultXPath = "//div[@class='vc_btn3-container vc_btn3-inline']/a";
        StringBuilder sbResult = new TaskSerchOnly(driver).doTaskSerchOnly(linkInsideFacebook, listOfResultXPath, log);
        return sbResult;
    }
}
