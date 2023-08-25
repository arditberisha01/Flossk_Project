package products.bugaboo.pages.CustomerContactPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BasePage;

import static utilities.BrowserUtils.*;
import static utilities.WaitUtils.*;

public class CustomerContactFaqsPages extends BasePage {

    @FindBy(xpath = "//span[contains(text(), \"Please choose a question\")]")
    private WebElement errorText;

    @FindBy(xpath = "//button[@id='combobox-button-22']")
    private WebElement selectQuestions;

    @FindBy(xpath = "//button[@class='slds-button slds-button_brand']")
    private WebElement nextBtn;

    @FindBy(xpath = "//span[@title='Delivery, Return or Refund']")
    private WebElement orderQuestion;

    @FindBy(xpath = "(//h2[@class='slds-accordion__summary-heading'][1])")
    private WebElement faqOrderOne;

    @FindBy(xpath = "//span[contains(text(),\"How will I be contacted for a delivery appointment?\")]")
    private WebElement faqOrderTwo;

    @FindBy(xpath = "//span[contains(text(),\"Is there a different return policy\")]")
    private WebElement faqOrderThree;

    @FindBy(xpath = "//span[contains(text(),\"What is your expected shipping timeline?\")]")
    private WebElement faqOrderFour;

    @FindBy(xpath = "//span[contains(text(),\"Can I exchange my product?\")]")
    private WebElement faqOrderFive;

    @FindBy(xpath = "//span[contains(text(),\"How can I return a product?\")]")
    private WebElement faqOrderSix;

    @FindBy(xpath = "//span[contains(text(), \"Pretty Perfect products\")]")
    private WebElement faqOrderOneText;

    @FindBy(xpath = "//span[contains(text(), \"Our aim is to have your pram\")]")
    private WebElement faqOrderTwoText;

    @FindBy(xpath = "//span//p[contains(text(), \"There is no difference in return\")]")
    private WebElement faqOrderThreeText;

    @FindBy(xpath = "//span[contains(text(), \"All orders are processed within 1-3 business\")]")
    private WebElement faqOrderFourText;

    @FindBy(xpath = "//span[contains(text(), \"Unfortunately, we do not have a process\")]")
    private WebElement faqOrderFiveText;

    @FindBy(xpath = "//*[@id='lgt-accordion-section-49']//slot//span")
    private WebElement faqOrderSixText;



    public boolean isErrorMessageDisplayed(){
        waitUntilElmIsDisplayed(errorText);
        return errorText.isDisplayed();
    }



    public void clickSelectQuestions(){
        waitUntilElmIsClickable(selectQuestions);
        selectQuestions.click();
    }

    public String getTextOfQuestions(){
        return selectQuestions.getText();
    }

    public String getTextOfFaqOne(){
        return faqOrderOneText.getText();
    }

    public String getTextOfFaqTwo(){
        return faqOrderTwoText.getText();
    }

    public String getTextOfFaqThree(){
        return faqOrderThreeText.getText();
    }

    public String getTextOfFaqFour(){
        return faqOrderFourText.getText();
    }

    public String getTextOfFaqFive(){
        return faqOrderFiveText.getText();
    }

    public String getTextOfFaqSix(){
        return faqOrderSixText.getText();
    }

    public void clickFaqOrderOne(){
        waitUntilElmIsClickable(faqOrderOne);
        faqOrderOne.click();
    }

    public void clickFaqOrderTwo(){
        waitUntilElmIsClickable(faqOrderTwo);
        faqOrderTwo.click();
    }

    public void clickFaqOrderThree(){
        waitUntilElmIsClickable(faqOrderThree);
        faqOrderThree.click();
    }
    public void clickFaqOrderFour(){
        waitUntilElmIsClickable(faqOrderFour);
        faqOrderFour.click();
    }

    public void clickFaqOrderFive(){
        waitUntilElmIsClickable(faqOrderFive);
        faqOrderFive.click();
    }

    public void clickFaqOrderSix(){
        waitUntilElmIsClickable(faqOrderSix);
        faqOrderSix.click();
    }

    public void clickNextBtn(){
        waitUntilElmIsDisplayed(nextBtn);
        nextBtn.click();
    }

    public void doubleClickNextBtn(){
        doubleClick(nextBtn);
    }//webelement public return

    public void clickOrderQuestion(){
        waitUntilElmIsClickable(orderQuestion);
        orderQuestion.click();
    }

    public Boolean isFormPageNotDisplayed(){
        waitUntilElmIsDisplayed(nextBtn);
        return nextBtn.isDisplayed();
    }
}




