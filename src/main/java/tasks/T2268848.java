package tasks;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by oleg on 24.12.2020.
 */
public class T2268848 extends Task {

        String taskId;
        WebDriver driver;

        public T2268848 (String taskId, WebDriver driver) {
            this.taskId = taskId;
            this.driver = driver;
        }


        public StringBuilder work(Logger log) {

            String linkInsideFacebook = "//*[contains(@href, 'https://l.facebook.com/l.php')]";
//            ((JavascriptExecutor) driver).executeScript("window.open()");
//            navigatorHelper.switchToLastTab(driver);
//            driver.get(linkFacebook);
            navigatorHelper.switchToLastTab(driver);
            skipErrorMessage(driver);

            String listOfResultXPath = "//a[contains(@href,'https://cse.google.com/cse?cx=')]";
            StringBuilder sbResult = new TaskSerchOnly(driver).doTaskSerchOnly(linkInsideFacebook, listOfResultXPath,log,6);
            return sbResult;
        }
    }

