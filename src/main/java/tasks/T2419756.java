package tasks;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by oleg on 06.12.2020.
 */
public class T2419756  extends Task{
    String taskId;
    WebDriver driver;

    public T2419756(WebDriver driver,String taskId) {
        this.taskId = taskId;
        this.driver = driver;
    }

    public StringBuilder work(Logger log) {

        navigatorHelper.switchToLastTab(driver);
        String linkInsideFacebook = "(//a[contains(@href, 'https://l.facebook.com/l.php')])[2]";

        try {
            skipErrorMessage(driver);
        } catch (Exception e){
            System.out.println("Exception skipErrorMessage();");
        }

        String listOfResultXPath = "//a[contains(@href, 'https://cse.google.com')]";
        StringBuilder sbResult = new TaskSerchOnly(driver).doTaskSerchOnly(linkInsideFacebook, listOfResultXPath, log);
        return sbResult;
    }

}
