package tasks;

import helpers.NavigatorHelper;
import helpers.PageKeeper;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import pages.TaskPageSeo;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;

import java.awt.*;
import java.util.List;

/**
 * Created by oleg on 30.11.2020.
 */
@SuppressWarnings("Since15")
public class Task {
    WebDriver driver;
    NavigatorHelper navigatorHelper = new NavigatorHelper(driver);
    TaskPageSeo taskPageSeo;

    public Task() {
        this.driver = driver;
    }

    public void startTask(WebDriver driver, String taskID, Logger log) {

        taskPageSeo = PageFactory.initElements(driver, TaskPageSeo.class);
        log.info("===================================================================");
        log.info(taskID);
        log.info("===================================================================");

        String formXPath = "//div[@id='" + taskID + "']";
        WebElement task = driver.findElement(By.xpath(formXPath));
        navigatorHelper.timeout(3, 5);
        task.findElement(By.xpath(".//a[@class='advmoder']")).click();   // натиснути на завданні
        navigatorHelper.switchToLastTab(driver);
        PageKeeper.getInstance().addPageToMap(taskID, driver.getWindowHandle());
        navigatorHelper.timeout(10, 15);

        List<WebElement> startWorking = driver.findElements(By.xpath("//form[@id='task-use']/following-sibling::div[@class='btn-dock']/span[@class='btn-ok']"));
        if (startWorking.size() > 0) {
            log.info("Task:startTask: press button startworking (span)");
            startWorking.get(0).click();// приступити до виконання
            navigatorHelper.timeout(1, 5);
        } else {
            List<WebElement> startWorkingList = driver.findElements(By.xpath("//form[@id='task-use']/following-sibling::div[@class='btn-dock']/a[@href]"));
            if (startWorkingList.size() > 0) {
                log.info("Task:startTask: press button startworking (a)");
                WebElement startWorkingA = startWorkingList.get(0);
                startWorkingA.click();
                navigatorHelper.timeout(7, 10);

            }
        }
        navigatorHelper.timeout(6, 8);
    }

    public void endTask(WebDriver driver, String taskID, StringBuilder sbResult, Logger log) {
        driver.switchTo().window(PageKeeper.getInstance().getPages().get(taskID));
        boolean chescker = checkerCorrectAnswer(sbResult);

        if (chescker) {
            // driver.findElement(By.xpath("//textarea[@id='task_report']")).sendKeys(sbResult);
            System.out.println("before pass task: ");
            System.out.println(sbResult);
            System.out.println("length : " + sbResult.length());
            WebElement textArea = null;
            try {
                driver.switchTo().frame("task_report_ifr");
                textArea = driver.findElement(By.xpath("//body[@id='tinymce']/p"));
            } catch (NoSuchFrameException n) {
                textArea = driver.findElement(By.xpath("//textarea[@id='task_report']"));
            }


            StringSelection stringSelection = new StringSelection(sbResult.toString());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);

            textArea.sendKeys(Keys.CONTROL + "v");

            driver.switchTo().defaultContent();
            try {
                driver.findElement(By.xpath("//span[@class='btn-ok']")).click();
            } catch (ElementClickInterceptedException ex) {
                System.out.println(ex.getMessage());
                navigatorHelper.timeout(3, 4);
                driver.findElement(By.xpath("//span[text() = 'Надіслати звіт'")).click();
            }
            try {
                makeNotify("tasks.Task done.");
            } catch (AWTException e) {
                e.printStackTrace();
            }
        } else {
            driver.findElement(By.xpath("//span[@class='btn-cancel']")).click();
        }
        navigatorHelper.timeout(20, 30);
        driver.switchTo().window(PageKeeper.getInstance().getPages().get("seoFavoriteTaskPage"));
        navigatorHelper.closeAllTabsExceptSome(driver, "seoFavoriteTaskPage");
    }

    private void makeNotify(String message) throws AWTException {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            java.awt.Image image = Toolkit.getDefaultToolkit().getImage("");
            TrayIcon trayIcon = new TrayIcon(image);
            tray.add(trayIcon);
            trayIcon.displayMessage("SeoSprint .", message,
                    TrayIcon.MessageType.INFO);
        }
    }

    private boolean checkerCorrectAnswer(StringBuilder sbResult) {

        if (sbResult.length() > 350) {
            return true;
        }
        return false;
    }

    public void skipErrorMessage(WebDriver driver) {
        List<WebElement> errorMessageSearcher = driver.findElements(By.xpath("//a[@action='cancel']"));
        if (errorMessageSearcher.size() > 0) {
            driver.findElement(By.xpath("//a[@action='cancel']")).click();
            navigatorHelper.timeout(5, 6);
        }
    }


}
