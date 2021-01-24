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
 * Created by oleg on 19.01.2021.
 */
public class T2436990 extends Task{
    String taskId;
    WebDriver driver;
    NavigatorHelper navigatorHelper;

    public T2436990(String taskId, WebDriver driver) {
        this.taskId = taskId;
        this.driver = driver;
        navigatorHelper = new NavigatorHelper(driver);
    }

    public StringBuilder work(Logger log) {
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

       // String url ="//a[contains(@href, 'https://l.facebook.com/l.php')]";
        String url = "//a[@rel='nofollow noopener']";
        String searchBlock = "//div[@id='___gcse_0']/following-sibling::center//a";
        //  String searchBlock = "((//div[@id='td-outer-wrap']/div)[2]//div[@id])[7]//a";

        TaskWithExploreSite taskWithExploreSite = new TaskWithExploreSite(driver);
        List<String> searchResultInStringPresentation = taskWithExploreSite.buildSearchResultInStringPresentation(url, searchBlock);

        LinkHolder linkHolder = LinkHolder.getInstance();
        //   linkHolder.buildMap();
        return  taskWithExploreSite.doCircleSearh(linkHolder, searchResultInStringPresentation, log);
    }
}
