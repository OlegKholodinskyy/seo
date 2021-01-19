package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by oleg on 29.08.2020.
 */
public class StartPageSeo {

    private WebDriver driver;

    public StartPageSeo(WebDriver driver) {
        this.driver = driver;
    }

    private static String email;
    private static String pass;

    @FindBy(xpath = "//span[@class='btn-h1']")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@placeholder='E-mail']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//form[@id='enter']//button")
    private WebElement enterButton;

    //@FindBy(xpath = "//button[contains(text(),'Log in')]")
    @FindBy(xpath = "//div[@id='cpt44']/following-sibling::button")
    private WebElement logInButton;

    public void clickSignInButton() {
        System.out.println("SeoSprint:doAutorize:clickSignInButton");
        signInButton.click();
    }

    public void fillEmailField(String email) {
        emailField.sendKeys(email);
    }

    public void fillPassField(String pass) {
        passwordField.sendKeys(pass);
    }

    public void clickLogInButton() {
        System.out.println("SeoSprint:doAutorize:clickLogInButton");
        logInButton.click();
    }


}