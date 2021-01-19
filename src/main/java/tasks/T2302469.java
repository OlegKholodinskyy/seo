package tasks;

import helpers.LinkHolder;
import helpers.NavigatorHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by oleg on 06.12.2020.
 */
public class T2302469  extends Task{
    String taskId;
    WebDriver driver;
    NavigatorHelper navigatorHelper;

    public T2302469(String taskId, WebDriver driver) {
        this.taskId = taskId;
        this.driver = driver;
        navigatorHelper = new NavigatorHelper(driver);
    }


    public StringBuilder work(Logger log) {
        String linkFacebook = "https://www.facebook.com/Amazuum-111317737013784/";
        ((JavascriptExecutor) driver).executeScript("window.open()");
        navigatorHelper.switchToLastTab(driver);
        driver.get(linkFacebook);
        navigatorHelper.switchToLastTab(driver);
        checkIfFacebookThrowError();

        StringBuilder sb = workByTask(log);
        return sb;
    }

    private void checkIfFacebookThrowError() {
        List<WebElement> errorMessageSearcher = driver.findElements(By.xpath("//a[@action='cancel']"));
        if (errorMessageSearcher.size() > 0) {
            driver.findElement(By.xpath("//a[@action='cancel']")).click();
            navigatorHelper.timeout(5, 6);
        }
    }

    public StringBuilder workByTask(Logger log) {

        String url = "//a[contains(@href, 'https://l.facebook.com/l.php')]";
        String searchBlock = "//a[contains(@href, 'https://cse.google.com')]";
     //   String searchBlock = "((//div[@id='td-outer-wrap']/div)[2]//div[@id])[6]//a";

        TaskWithExploreSite taskWithExploreSite = new TaskWithExploreSite(driver);
        List<String> searchResultInStringPresentation = taskWithExploreSite.buildSearchResultInStringPresentation(url, searchBlock);

        LinkHolder linkHolder = new LinkHolder();
        linkHolder.buildMap();

        return  taskWithExploreSite.doCircleSearh(linkHolder, searchResultInStringPresentation, log);
    }
}

