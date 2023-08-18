package PRODUCTS.Bugaboo.pages.CustomerContactPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BasePage;

import static utilities.BrowserUtils.*;
import static utilities.WaitUtils.*;


public class CustomerContactPages extends BasePage {

    @FindBy(xpath = "//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")
    private WebElement acceptAllCookies;

    @FindBy(id = "input-108")
    private WebElement oneOrderNumber;

    @FindBy(id = "input-112")
    private WebElement oneItemCode;

    @FindBy(xpath = "//div//textarea[@id='input-118']")
    private WebElement oneDescription;

    @FindBy(id = "input-122")
    private WebElement oneFirstName;

    @FindBy(id = "input-126")
    private WebElement oneLastName;

    @FindBy(id = "input-130")
    private WebElement oneEmail;

    @FindBy(id = "input-134")
    private WebElement oneVerifyEmail;

    @FindBy(xpath = "//input[@class='slds-input slds-form-element']")
    private WebElement onePhoneNumber;

    @FindBy(id = "select-137")
    private WebElement oneCountry;

    @FindBy(id = "input-file-139")
    private WebElement oneUpload;

    @FindBy(xpath = "//span[@class='slds-p-left--x-small']//button[@type='button']")
    private WebElement oneUploadOk;

    @FindBy(xpath = "//iframe[@id='vfFrame']")
    private WebElement firstFrame;

    @FindBy(xpath = "//iframe[contains(@name,'a-')]")
    private WebElement oneCaptcha;

    @FindBy(xpath = "//button[@class='slds-button slds-button_brand']")
    private WebElement oneNextBtn;

    @FindBy(xpath = "//div[.='reCAPTCHA']/*[last()]")
    private WebElement oneClickCaptcha;

    @FindBy(xpath = "//*[contains(text(), 'Thank you')]")
    private WebElement thankYouPage;



    public void fillFormOne(){

        String email = faker.internet().emailAddress();

        waitUntilElmIsClickable(oneOrderNumber);
        oneOrderNumber.sendKeys(faker.number().digits(7));

        waitUntilElmIsClickable(oneItemCode);
        oneItemCode.sendKeys(faker.book().publisher());

        waitUntilElmIsClickable(oneDescription);
        oneDescription.sendKeys(faker.book().publisher());

        waitUntilElmIsClickable(oneFirstName);
        oneFirstName.sendKeys(faker.name().firstName());

        waitUntilElmIsClickable(oneLastName);
        oneLastName.sendKeys(faker.name().lastName());

        waitUntilElmIsClickable(oneEmail);
        oneEmail.sendKeys(email);

        waitUntilElmIsClickable(oneVerifyEmail);
        oneVerifyEmail.sendKeys(email);

        waitUntilElmIsClickable(onePhoneNumber);
        onePhoneNumber.sendKeys(faker.number().digits(10));
    }


    public void solveCaptcha(){

        switchToFrame(firstFrame);
        switchToFrame(oneCaptcha);

        waitUntilElmIsClickable(oneClickCaptcha);
        oneClickCaptcha.click();

        switchToParentFrame();
        switchToParentFrame();
    }


    public void clickOneNextBtn(){
        waitUntilElmIsClickable(oneNextBtn);
        oneNextBtn.click();
    }


    public void oneSelectCountry(String str) {

        selectByValue(str, oneCountry);
    }

    public void oneUploadFile(){
        String path = System.getProperty("user.home") + "/IdeaProjects/Flossk_Project_Testing/upload.txt";
        oneUpload.sendKeys(path);

    }

    public void oneUploadFileOk(){
        waitUntilElmIsClickable(oneUploadOk);
        oneUploadOk.click();
    }


    public void clickOnAcceptAllCookies(){
        waitUntilElmIsClickable(acceptAllCookies);
        acceptAllCookies.click();
    }

    public Boolean isThankyouDisplayed(){
        return thankYouPage.isDisplayed();
    }


}
