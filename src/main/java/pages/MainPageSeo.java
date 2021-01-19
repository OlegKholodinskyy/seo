package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageSeo {

    @FindBy(xpath = "//span[@class='note']")
    private WebElement currentSumm;

    @FindBy(xpath = "//a[@href='/earn-surf']")
    private WebElement surfRef;

    @FindBy(xpath = "//a[@href='/earn-task']")
    private WebElement taskRef;


    @FindBy(xpath = "//a[@id='nav-earn']")
    private WebElement earnBtn;

    public void clickEarnBtn() {
       earnBtn.click();
    }

    public String getCurrentSumm() {
        return currentSumm.getText();
    }

    public void clickSurfRef(WebDriver driver) {
        driver.get("https://seosprint.net/earn-surf");
    }

}
