package tasks;

import helpers.LinkHolder;
import helpers.NavigatorHelper;
import helpers.PageKeeper;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;

import java.util.*;

/**
 * Created by oleg on 06.12.2020.
 */
public class TaskWithExploreSite {
    WebDriver driver;
    NavigatorHelper navigatorHelper;
    StringBuilder sb = new StringBuilder("");

    public TaskWithExploreSite(WebDriver driver) {
        this.driver = driver;
        navigatorHelper = new NavigatorHelper(driver);
    }


    public List<String> buildSearchResultInStringPresentation(String url, String searchBlock) {
        //open link in facebook
        navigatorHelper.timeout(5, 10);
        try {
            driver.findElement(By.xpath(url)).click();
        } catch (Exception e) {
            System.out.println("Exception TaskSearchOnly");
            driver.findElement(By.xpath("(//a[contains(@href, 'https://l.facebook.com/l.php')])[2]")).click();
        }
        navigatorHelper.switchToLastTab(driver);
        navigatorHelper.timeout(7, 15);

        PageKeeper.getInstance().addPageToMap("Search", driver.getWindowHandle());
        sb.append(driver.getCurrentUrl()).append("\n");

        List<WebElement> searchResult = driver.findElements(By.xpath(searchBlock));

        List<String> searchResultInStringPresentation = new ArrayList<String>();
        for (WebElement e : searchResult) {
            searchResultInStringPresentation.add(e.getText());
        }
        return searchResultInStringPresentation;
    }


    public StringBuilder doCircleSearh(LinkHolder linkHolder, List<String> searchResultInStringPresentation, Logger log) {
        StringBuilder resultBilder = new StringBuilder("");
        resultBilder.append(driver.getCurrentUrl() + "\n");    // добавити сторінку з що відкрилася з посиланя на фейсбуці
        log.info("Append into StringBuilder : + " + driver.getCurrentUrl() + "\n");
        StringBuilder result = step1(linkHolder, searchResultInStringPresentation, log);
        resultBilder.append(result + "\n");
        log.info("Append into StringBuilder : + " + result + "\n");

        //   System.out.println("StringBuilder doCircleSearh : " + resultBilder);
        return resultBilder;

    }

    private StringBuilder step1(LinkHolder linkHolder, List<String> searchResultInStringPresentation, Logger log) {
        int count = 0;
        StringBuilder tempBuilder = new StringBuilder("");
        while (count < 11) {
            String randomKey = linkHolder.getRandomKey();
            log.info("randomKey : " + randomKey);

            String trimRandomKey = randomKey.trim();
            if (searchResultInStringPresentation.contains(trimRandomKey)) {
                log.info("  !!!  searchResultInStringPresentation contains : " + trimRandomKey);
                doSearh(trimRandomKey);
                String aferDoSearch = driver.getCurrentUrl();
                StringBuilder res = goStep2(linkHolder, trimRandomKey, log);
                if (res == null) {
                    // linkHolder do NOT contains any sites from result of search
                    driver.navigate().back();
                    res = new StringBuilder("");
                    continue;
                } else {
                    // linkHolder CONTAINS any sites from result of search
                    tempBuilder.append(aferDoSearch).append(res).append("\n");
                    //   System.out.println("StringBuilder step1 : " + tempBuilder);
                    return tempBuilder;
                }
            } else {

                log.info("  !!!  searchResultInStringPresentation DO NOT  !!!!   contains : " + "*" + trimRandomKey + "*");
//
//                System.out.println("For check : ");
//                System.out.println("searchResultInStringPresentation:");
//                for (String s : searchResultInStringPresentation) {
//                    System.out.println(s);
//                }
//                System.out.println("randomKey :" + trimRandomKey);
//                System.out.println("END   For check : ");
                count++;
            }
        }
        return null;
    }

    private StringBuilder goStep2(LinkHolder linkHolder, String randomKey, Logger log) {
        List<String> resultSearchBlocksInStringPresentation = fillResultSearchInStringPresentation();

        int count = 0;
        while (count < 5) {
            String randomResult = linkHolder.getRandomResulrSite(randomKey);
            //  System.out.println(" randomResult  " + randomResult);
            log.info("step2:  randomResult  " + randomResult);
            for (String s : resultSearchBlocksInStringPresentation) {
                log.info("step2:  resultSearchBlocksInStringPresentation  " + s);
                if (s.contains(randomResult)) {
                    //  (в сиску з результатів пошуку (www.)   міститься рандомний результат і більше не перебирати)
                    String xpathLinkPresentetion = "//a[contains(text(),\"" + randomResult + "\" )]";
                    //    driver.switchTo().frame("master-1");
                    WebElement e = driver.findElement(By.xpath(xpathLinkPresentetion));
                    e.click();
                    navigatorHelper.switchToLastTab(driver);
                    PageKeeper.getInstance().addPageToMap("ParcedSite", driver.getWindowHandle());
                    sb.append(driver.getCurrentUrl()).append("\n");

                    String[] links = linkHolder.getlinks(randomKey, randomResult);
                    StringBuilder r = doSurfSite(links, sb);
                    //      System.out.println("StringBuilder goStep2 : " + r);
                    return r;
                }
            }
            count++;
        }
        return null;
    }


    private void doSearh(String randomKey) {
        driver.findElement(By.xpath("//input[@id='gsc-i-id1']")).clear();
        driver.findElement(By.xpath("//input[@id='gsc-i-id1']")).sendKeys(randomKey);
        driver.findElement(By.xpath("//button[@class='gsc-search-button gsc-search-button-v2']")).click();
        navigatorHelper.switchToLastTab(driver);
    }


    private List<String> fillResultSearchInStringPresentation() {
        //тут ми вже відкрили віконечко з результатами пошуків
        try {
            driver.switchTo().frame("master-1");
        } catch (Exception e) {
            // to do nothing
        }
        List<WebElement> resultSerchBlocks = driver.findElements(By.xpath("//div[@id='adBlock']/div//a[contains(text(), 'www.')]"));
        List<String> resultSearchBlocksInStringPresentation = new ArrayList<String>();
        //заповнюємо масив результатів що висвітило в пошуковику  ;
        for (WebElement e : resultSerchBlocks) {
            resultSearchBlocksInStringPresentation.add(e.getText());
        }
        return resultSearchBlocksInStringPresentation;
    }
/*
    private String getCrossSearchResult(List<String> resultSearchBlocksInStringPresentation, String randomResult, LinkHolder linkHolder, String randonLink) {
//        int count = 0;
//        while (count < 5) {
        for (String oneRes : resultSearchBlocksInStringPresentation) {
            if (oneRes.contains(randomResult)) {
                return randomResult;
            }
        }
//            randomResult = linkHolder.getRandomResulrSite(randonLink);
//            count++;
//        }
        return null;
    }
*/
    private StringBuilder doSurfSite(String[] links, StringBuilder resultBilder) {

        List<String> randomSetLinks = buildRandomArrLinks(links);

        for (String s : randomSetLinks) {

            String xpathLinkPresentetion = "//a[contains(@href,\"" + s + "\" )]";

            System.out.println("Class TaskWithExploreSite : " + "Merhod doSurfSite : " + " xpathLinkPresentetion : z" + xpathLinkPresentetion);

            List<WebElement> e = driver.findElements(By.xpath(xpathLinkPresentetion));
            for (WebElement elem : e) {
                if (elem.isEnabled() && elem.isDisplayed()) {
                    String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
                    try {
                        elem.sendKeys(selectLinkOpeninNewTab);
                        navigatorHelper.switchToLastTab(driver);
                        resultBilder.append(driver.getCurrentUrl()).append("\n");
                        navigatorHelper.timeout(15, 36);
                        driver.close();
                        break;
                    } catch (ElementNotInteractableException ex) {
                        System.out.println(ex.getCause());
                        System.out.println(ex.getStackTrace());
                        System.out.print(getClass().getCanonicalName());
                        System.out.println(ex.getMessage());
                    }
                }
            }

            driver.switchTo().window(PageKeeper.getInstance().getPages().get("ParcedSite"));

        }
        return resultBilder;
    }

    private static List<String> buildRandomArrLinks(String[] links) {
        List<String> list = new LinkedList<String>(Arrays.asList(links));
        list.remove(0);

        Collections.shuffle(list);

        List<String> outputArrayList = new ArrayList<String>();
        for (int i = 4; i > 0; i--) {
            outputArrayList.add(list.get(i));
        }

        return outputArrayList;
    }

/*
    public StringBuilder getStringBuilder() {
        return sb;
    }
    */
}
