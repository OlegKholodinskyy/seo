import helpers.LoginHelper;
import helpers.NavigatorHelper;
import helpers.PageKeeper;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import pages.*;
import tasks.*;

import java.util.*;
import java.util.List;

@SuppressWarnings("Since15")
public class SeoSprint {

    private WebDriver driver;
    static StartPageSeo startPageSeo;
    static SurfPageSeo surfPageSeo;
    NavigatorHelper navigatorHelper = new NavigatorHelper(driver);


    public SeoSprint(WebDriver driver) {
        this.driver = driver;
    }


    public void doAutorize() {
        driver.get("https://seosprint.net/");

        LoginHelper loginHelper = new LoginHelper();
        PageKeeper.getInstance().getPages().put("seosprintStartPage", driver.getWindowHandle());
        startPageSeo = PageFactory.initElements(driver, StartPageSeo.class);
        startPageSeo.clickSignInButton();
        startPageSeo.fillEmailField(loginHelper.getLoginSeo());
        startPageSeo.fillPassField(loginHelper.getPassSeo());
        navigatorHelper.timeout(10, 15);
        startPageSeo.clickLogInButton();
    }


    public void doTasks(Logger log) {

        List<String> listStringTasks = prepredTaskList();

        for (String taskId : listStringTasks) {
            if (taskId.equals("taskline_2268848")) {
                try {
                    T2268848 t2268848 = new T2268848(taskId, driver);
                    t2268848.startTask(driver, taskId, log);
                    StringBuilder sb = t2268848.work(log);
                    t2268848.endTask(driver, taskId, sb, log);
                } catch (Exception e) {
                    log.error("Exception " + "\n" + e.getMessage());
                    navigatorHelper.closeAllTabsExceptSome(driver, "seoFavoriteTaskPage");
                    driver.get("https://seosprint.net/earn-task-fav");
                }
            }

            if (taskId.equals("taskline_2302451")) {
                try {
                    T2302451 t2302451 = new T2302451(taskId, driver);
                    t2302451.startTask(driver, taskId, log);
                    StringBuilder sb = t2302451.work(log);
                    t2302451.endTask(driver, taskId, sb, log);
                } catch (Exception e) {
                    log.error("Exception " + "\n" + e.getMessage());
                    navigatorHelper.closeAllTabsExceptSome(driver, "seoFavoriteTaskPage");
                    driver.get("https://seosprint.net/earn-task-fav");
                }
            }
            if (taskId.equals("taskline_2266359")) {
                try {
                    T2266359 t2266359 = new T2266359(taskId, driver);
                    t2266359.startTask(driver, taskId, log);
                    StringBuilder sb = t2266359.work(log);
                    t2266359.endTask(driver, taskId, sb, log);
                } catch (Exception e) {
                    log.error("Exception " + "\n" + e.getMessage());
                    navigatorHelper.closeAllTabsExceptSome(driver, "seoFavoriteTaskPage");
                    driver.get("https://seosprint.net/earn-task-fav");
                }
            }
            if (taskId.equals("taskline_2261354")) {
                try {
                    T2261354 t2261354 = new T2261354(taskId, driver);
                    t2261354.startTask(driver, taskId, log);
                    StringBuilder sb = t2261354.work(log);
                    t2261354.endTask(driver, taskId, sb, log);
                } catch (Exception e) {
                    log.error("Exception " + "\n" + e.getMessage());
                    navigatorHelper.closeAllTabsExceptSome(driver, "seoFavoriteTaskPage");
                    driver.get("https://seosprint.net/earn-task-fav");
                }
            }
            if (taskId.equals("taskline_2254951")) {
                try {
                    T2254951 t2254951 = new T2254951(taskId, driver);
                    t2254951.startTask(driver, taskId, log);
                    StringBuilder sb = t2254951.work(log);
                    t2254951.endTask(driver, taskId, sb, log);
                } catch (Exception e) {
                    log.error("Exception " + "\n" + e.getMessage());
                    navigatorHelper.closeAllTabsExceptSome(driver, "seoFavoriteTaskPage");
                    driver.get("https://seosprint.net/earn-task-fav");
                }
            }

            if (taskId.equals("taskline_2419756")) {
                try {
                    T2419756 t2419756 = new T2419756(driver, taskId);
                    t2419756.startTask(driver, taskId, log);
                    StringBuilder sb = t2419756.work(log);
                    t2419756.endTask(driver, taskId, sb, log);
                } catch (Exception e) {
                    log.error("Exception " + "\n" + e.getMessage());
                    navigatorHelper.closeAllTabsExceptSome(driver, "seoFavoriteTaskPage");
                    driver.get("https://seosprint.net/earn-task-fav");
                }
            }

            if (taskId.equals("taskline_2441472")) {
                try {
                    T2441472 t2441472 = new T2441472(taskId, driver);
                    t2441472.startTask(driver, taskId, log);
                    StringBuilder sb = t2441472.work(log);
                    t2441472.endTask(driver, taskId, sb, log);
                } catch (Exception e) {
                    log.error("Exception " + "\n" + e.getMessage());
                    navigatorHelper.closeAllTabsExceptSome(driver, "seoFavoriteTaskPage");
                    driver.get("https://seosprint.net/earn-task-fav");
                }
            }

            if (taskId.equals("taskline_2302469")) {
                try {
                    T2302469 t2302469 = new T2302469(taskId, driver);
                    t2302469.startTask(driver, taskId, log);
                    StringBuilder sb = t2302469.work(log);
                    t2302469.endTask(driver, taskId, sb, log);
                } catch (Exception e) {
                    log.error("Exception " + "\n" + e.getMessage());
                    navigatorHelper.closeAllTabsExceptSome(driver, "seoFavoriteTaskPage");
                    navigatorHelper.closeAllTabsExceptSome(driver, "seoFavoriteTaskPage");
                    driver.get("https://seosprint.net/earn-task-fav");
                }
            }
            if (taskId.equals("taskline_2261614")) {
                try {
                    T2261614 t2261614 = new T2261614(taskId, driver);
                    t2261614.startTask(driver, taskId, log);
                    StringBuilder sb = t2261614.work(log);
                    t2261614.endTask(driver, taskId, sb, log);
                } catch (Exception e) {
                    log.error("Exception " + "\n" + e.getMessage());
                    navigatorHelper.closeAllTabsExceptSome(driver, "seoFavoriteTaskPage");
                    driver.get("https://seosprint.net/earn-task-fav");
                }
            }
            if (taskId.equals("taskline_2266368")) {
                try {
                    T2266368 t2266368 = new T2266368(taskId, driver);
                    t2266368.startTask(driver, taskId, log);
                    StringBuilder sb = t2266368.work(log);
                    t2266368.endTask(driver, taskId, sb, log);
                } catch (Exception e) {
                    log.error("Exception " + "\n" + e.getMessage());
                    navigatorHelper.closeAllTabsExceptSome(driver, "seoFavoriteTaskPage");
                    driver.get("https://seosprint.net/earn-task-fav");
                }
            }
            if (taskId.equals("taskline_2254959")) {
                try {
                    T2254959 t2254959 = new T2254959(taskId, driver);
                    t2254959.startTask(driver, taskId, log);
                    StringBuilder sb = t2254959.work(log);
                    t2254959.endTask(driver, taskId, sb, log);
                } catch (Exception e) {
                    log.error("Exception " + "\n" + e.getMessage());
                    navigatorHelper.closeAllTabsExceptSome(driver, "seoFavoriteTaskPage");
                    driver.get("https://seosprint.net/earn-task-fav");
                }
            }
            if (taskId.equals("taskline_2304608")) {
                try {
                    T2304608 t2304608 = new T2304608(taskId, driver);
                    t2304608.startTask(driver, taskId, log);
                    StringBuilder sb = t2304608.work(log);
                    t2304608.endTask(driver, taskId, sb, log);
                } catch (Exception e) {
                    log.error("Exception " + "\n" + e.getMessage());
                    navigatorHelper.closeAllTabsExceptSome(driver, "seoFavoriteTaskPage");
                    driver.get("https://seosprint.net/earn-task-fav");
                }
            }

        }
    }


    private List<String> prepredTaskList() {

        navigatorHelper.timeout(3, 5);
        TaskPageSeo taskPageSeo = PageFactory.initElements(driver, TaskPageSeo.class);
        driver.get("https://seosprint.net/earn-task-fav");
        PageKeeper.getInstance().addPageToMap("seoFavoriteTaskPage", driver.getWindowHandle());

        List<WebElement> taskList = taskPageSeo.getTaskList();
        System.out.println("tasklist.size = " + taskList.size());

        List<String> listStringTasks = new ArrayList<String>();
        for (WebElement tsk : taskList) {
            listStringTasks.add(tsk.getAttribute("id"));
        }

        // re-sort tasks
        Collections.shuffle(listStringTasks);
        // end re-sort tasks


        return listStringTasks;
    }


    public void doAutorizeFacebook() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        navigatorHelper.switchToLastTab(driver);
        driver.get("https://www.facebook.com/");
        navigatorHelper.switchToLastTab(driver);
        // start facebook login
        LoginHelper loginHelper = new LoginHelper();

        WebElement loginField = driver.findElement(By.xpath("//input[@id='email']"));
        loginField.sendKeys(loginHelper.getLoginFacebook());
        WebElement passField = driver.findElement(By.xpath("//input[@id='pass']"));
        passField.sendKeys(loginHelper.getPassFacebook());
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        System.out.println("SeoSprint:doAutorizeFacebook:clickButtonSubmit");
        button.click();
        navigatorHelper.timeout(5, 7);
        driver.close();

        driver.switchTo().window(PageKeeper.getInstance().getPages().get("seosprintStartPage"));
        //end facebook login

    }
}