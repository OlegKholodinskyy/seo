package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by oleg on 08.09.2020.
 */
public class SurfPageSeo {

    @FindBy(xpath = "//div[@id='block-main']")
    private WebElement mainBlockWithSurf;



    public List<WebElement> getSurfBlocks() {
        List<WebElement> surfBlocks = mainBlockWithSurf.findElements(By.xpath(".//div[@class='adv-line']"));
        List<WebElement> surfBlocksHight = mainBlockWithSurf.findElements(By.xpath(".//div[@class='adv-line-high']"));
        surfBlocks.addAll(surfBlocksHight);

        try {
//            surfBlocks = mainBlockWithSurf.findElements(By.xpath("./div[@class='adv-line']"));
//            surfBlocksHight = mainBlockWithSurf.findElements(By.xpath("./div[@class='adv-line-high']"));

        } catch (StaleElementReferenceException e) {
            System.out.println(e.getCause());
            System.out.println(getClass().getName());
            System.out.println("StaleElementReferenceException  0");
        }
        return surfBlocks;
    }
}
