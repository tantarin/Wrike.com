package Pages;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.UUID;

public class SubmitPage {

    @FindBy(xpath = "//button[text()='Very interested']")
    private WebElement buttonVeryInterested;

    @FindBy(xpath = "//button[text()='Just looking']")
    private WebElement buttonJustLooking;

    @FindBy(xpath = "//button[text()='1–5']")
    private WebElement button1_5;

    @FindBy(xpath = "//button[text()='6–15']")
    private WebElement button6_15;

    @FindBy(xpath = "//button[text()='16–25']")
    private WebElement button16_25;

    @FindBy(xpath = "//button[text()='26–50']")
    private WebElement button26_50;

    @FindBy(xpath = "//button[text()='50+']")
    private WebElement button50plus;

    @FindBy(xpath = "//button[text()='Yes']")
    private WebElement buttonYes;

    @FindBy(xpath = "//button[text()='No']")
    private WebElement buttonNo;

    @FindBy(xpath = "//button[text()='Submit results']")
    private WebElement buttonSubmitResults;

    @FindBy(xpath = "//h3[text()='Thanks for helping us out!']")
    private WebElement h3CompletedSubmit;

    @FindBy(xpath = "//a[@href='https://twitter.com/wrike']")
    private WebElement twitterIcon;

    public SubmitPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Step
    @DisplayName("Submit")
    public void submit() throws InterruptedException {
        int randomInterested = (int) (Math.random()*1);
        int randomTeam = (int) (Math.random()*4);
        int randomFollow = (int) (Math.random()*1);

        if(randomInterested == 0) this.buttonVeryInterested.click();
        if(randomInterested == 1) this.buttonJustLooking.click();

        if(randomTeam == 0) this.button1_5.click();
        if(randomTeam == 1) this.button6_15.click();
        if(randomTeam == 2) this.button16_25.click();
        if(randomTeam == 3) this.button26_50.click();
        if(randomTeam == 4) this.button50plus.click();

        if(randomFollow == 0) this.buttonYes.click();
        if(randomFollow == 1) this.buttonYes.click();

        this.buttonSubmitResults.click();
        Thread.sleep(4000);

        Assert.assertEquals(true, h3CompletedSubmit.isDisplayed());
        Assert.assertEquals(true, twitterIcon.isDisplayed());
    }
    //endregion
}