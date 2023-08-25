package products.bugaboo.pages.CustomerContactPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BasePage;

import static utilities.BrowserUtils.*;
import static utilities.WaitUtils.*;


public class CustomerContactPages extends BasePage {

    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    private WebElement acceptAllCookies;

    @FindBy(xpath = "//*[@name='Order_Number']")
    private WebElement oneOrderNumber;

    @FindBy(xpath = "//*[@name='Item_Code']")
    private WebElement oneItemCode;

    @FindBy(xpath = "//*[@class='slds-textarea']")
    private WebElement oneDescription;

    @FindBy(xpath = "//*[@name='First_Name']")
    private WebElement oneFirstName;

    @FindBy(xpath = "//*[@name='Last_Name']")
    private WebElement oneLastName;

    @FindBy(xpath = "//*[@name='Email']")
    private WebElement oneEmail;

    @FindBy(xpath = "//*[@name='Verify_EMail']")
    private WebElement oneVerifyEmail;

    @FindBy(xpath = "//input[@class='slds-input slds-form-element']")
    private WebElement onePhoneNumber;

    @FindBy(xpath = "//*[@class='slds-select']")
    private WebElement oneCountry;

    @FindBy(xpath = "//*[@name='FileUpload_1']")
    private WebElement oneUpload;

    @FindBy(xpath = "//span[@class='slds-p-left--x-small']//button[@type='button']")
    private WebElement oneUploadOk;

    @FindBy(id = "vfFrame")
    private WebElement firstFrame;

    @FindBy(xpath = "//iframe[contains(@name,'a-')]")
    private WebElement oneCaptcha;

    @FindBy(xpath = "//button[@class='slds-button slds-button_brand']")
    private WebElement oneNextBtn;

    @FindBy(xpath = "//div[.='reCAPTCHA']/*[last()]")
    private WebElement oneClickCaptcha;

    @FindBy(xpath = "//*[contains(text(), 'Thank you')]")
    private WebElement thankYouPage;

    @FindBy(xpath = "//p[contains(text(),\"valid email\")]")
    private WebElement oneEmailInvalid;

    @FindBy(xpath = "//p[contains(text(),\"Email &\")]")
    private WebElement oneVerifyEmailSame;

    public void fillFormOne(){
        //waitFrameToBeAvailableAndSwitchToIt(firstFrame);
        switchToFrame(firstFrame);
        //waitFrameToBeAvailableAndSwitchToIt(oneCaptcha);
        switchToFrame(oneCaptcha);

        waitUntilElmIsClickable(oneClickCaptcha);
        oneClickCaptcha.click();

        switchToParentFrame();
        switchToParentFrame();

        String email = faker.internet().emailAddress();

        waitUntilElmIsClickable(oneOrderNumber);
        oneOrderNumber.sendKeys(faker.number().digits(7));

        oneItemCode.sendKeys(faker.number().digits(8));

        oneDescription.sendKeys(faker.book().publisher());

        oneFirstName.sendKeys(faker.name().firstName());

        oneLastName.sendKeys(faker.name().lastName());

        oneEmail.sendKeys(email);

        oneVerifyEmail.sendKeys(email);

        onePhoneNumber.sendKeys(faker.number().digits(10));
    }

    public void fillFormOneInvalidEmail(){
//        switchToFrame(firstFrame);
//        switchToFrame(oneCaptcha);
//
//        waitUntilElmIsClickable(oneClickCaptcha);
//        oneClickCaptcha.click();
//
//        switchToParentFrame();
//        switchToParentFrame();

        String email = "312312312";

        waitUntilElmIsClickable(oneOrderNumber);
        oneOrderNumber.sendKeys(faker.number().digits(7));

        oneItemCode.sendKeys(faker.book().publisher());

        oneDescription.sendKeys(faker.book().publisher());

        oneFirstName.sendKeys(faker.name().firstName());

        oneLastName.sendKeys(faker.name().lastName());

        oneEmail.sendKeys(email);

        oneVerifyEmail.sendKeys(email);

        onePhoneNumber.sendKeys(faker.number().digits(10));
    }

    public void fillFormOneNotSameEmail(){
//        switchToFrame(firstFrame);
//        switchToFrame(oneCaptcha);
//
//        waitUntilElmIsClickable(oneClickCaptcha);
//        oneClickCaptcha.click();
//
//        switchToParentFrame();
//        switchToParentFrame();

        waitUntilElmIsClickable(oneOrderNumber);
        oneOrderNumber.sendKeys(faker.number().digits(7));

        oneItemCode.sendKeys(faker.book().publisher());

        oneDescription.sendKeys(faker.book().publisher());

        oneFirstName.sendKeys(faker.name().firstName());

        oneLastName.sendKeys(faker.name().lastName());

        oneEmail.sendKeys(faker.internet().emailAddress());

        oneVerifyEmail.sendKeys(faker.internet().emailAddress());

        onePhoneNumber.sendKeys(faker.number().digits(10));
    }



    public void clickOneNextBtn(){
        waitUntilElmIsClickable(oneNextBtn);
        oneNextBtn.click();
    }


    public void oneSelectCountry(String str) {
        selectByValue(str, oneCountry);
    }

    public void oneUploadFile(){
        waitUntilElmIsDisplayed(oneUpload);
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
        waitUntilElmIsDisplayed(thankYouPage);
        return thankYouPage.isDisplayed();
    }

    public Boolean isOneEmailInvalid(){
        waitUntilElmIsDisplayed(oneEmailInvalid);
        return oneEmailInvalid.isDisplayed();
    }

    public Boolean isNotSameEmail(){
        waitUntilElmIsDisplayed(oneVerifyEmailSame);
        return oneVerifyEmailSame.isDisplayed();
    }
}
