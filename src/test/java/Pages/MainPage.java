package Pages;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.UUID;

public class MainPage {
    @FindBy(xpath="//div[@class='wg-header__grid']//form[@data-hash='sticky_header']/button[@type='submit']")
    private WebElement getStartedButton;

    @FindBy(xpath="//label[@class='modal-form-trial__label']/input[@placeholder='Enter your business email']")
    private WebElement emailInput;

    @FindBy(xpath="//label[@class='modal-form-trial__label']/button[@type='submit']")
    private WebElement createAccountButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Step
    @DisplayName("Started register")
    public void started() throws InterruptedException {
        String email = UUID.randomUUID().toString().substring(4) + "+wpt@wriketask.qaa";
        this.getStartedButton.click();
        this.emailInput.sendKeys(email);
        this.createAccountButton.click();

        Thread.sleep(4000);
    }
    //endregion
}