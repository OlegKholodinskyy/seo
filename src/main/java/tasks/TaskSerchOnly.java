package tasks;

import helpers.NavigatorHelper;
import helpers.PageKeeper;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;

import java.util.List;

/**
 * Created by oleg on 29.09.2020.
 */
public class TaskSerchOnly {

    WebDriver driver;
    NavigatorHelper navigatorHelper = new NavigatorHelper(driver);

    public TaskSerchOnly(WebDriver driver) {
        this.driver = driver;
    }

    public StringBuilder doTaskSerchOnly(String url, String listOfResultXPath, Logger log, int count) {
        StringBuilder sb = new StringBuilder("");
        WebElement element = driver.findElement(By.xpath(url));
        navigatorHelper.timeout(5, 10);
        try {
            element.click();
            log.info("link from facebook click succesfully");
        } catch (ElementNotInteractableException e) {
            log.error("link from facebook not found. try another link");
            driver.findElement(By.xpath("(//a[contains(@href, 'https://l.facebook.com/l.php')])[2]")).click();
            log.info("link from facebook click succesfully");
        }

        navigatorHelper.switchToLastTab(driver);

        PageKeeper.getInstance().addPageToMap("Search", driver.getWindowHandle());
        sb.append(driver.getCurrentUrl());
        log.info("Add to StringBuffer : " + driver.getCurrentUrl() + "\n");
        sb.append("\n");

//        List<WebElement> listOfResult = driver.findElements(By.xpath("//div[@class='vc_btn3-container vc_btn3-inline']/a"));
//        List<WebElement> listOfResult = driver.findElements(By.xpath("//a[contains(@href, 'https://cse.google.com')]"));    // 2419756

        List<WebElement> listOfResult = driver.findElements(By.xpath(listOfResultXPath));
     //   String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);

        for (int i = 0; i < count; i++) {
            navigatorHelper.timeout(5, 6);


            driver.findElement(By.xpath("//input[@id='gsc-i-id1']")).clear();
            driver.findElement(By.xpath("//input[@id='gsc-i-id1']")).sendKeys(listOfResult.get(i).getText());
            driver.findElement(By.xpath("//button[@class='gsc-search-button gsc-search-button-v2']")).click();
            navigatorHelper.switchToLastTab(driver);


          //  listOfResult.get(i).sendKeys(selectLinkOpeninNewTab);

            sb.append(driver.getCurrentUrl() + "\n");
            log.info("Add to StringBuffer : " + driver.getCurrentUrl() + "\n");

            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
            navigatorHelper.timeout(25, 45);
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);
            navigatorHelper.timeout(3, 5);
            driver.close();
            navigatorHelper.switchToLastTab(driver);
        }
        return sb;
    }

}