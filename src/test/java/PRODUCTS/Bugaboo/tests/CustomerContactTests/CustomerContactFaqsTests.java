package PRODUCTS.Bugaboo.tests.CustomerContactTests;

import PRODUCTS.Bugaboo.pages.CustomerContactPages.CustomerContactFaqsPages;
import PRODUCTS.Bugaboo.pages.CustomerContactPages.CustomerContactPages;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BaseClass;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CustomerContactFaqsTests extends BaseClass {
    private CustomerContactPages customerContactPages = new CustomerContactPages();
    private CustomerContactFaqsPages customerContactFaqsPages = new CustomerContactFaqsPages();

    @BeforeMethod
    public void setUpMethod() {
        driver.get(ConfigurationReader.getProperty("bugaboo.url"));

        customerContactPages.clickOnAcceptAllCookies();

        BrowserUtils.pageVerification("Consumer Contact", driver.getTitle());
    }

    @Test
    public void selectFirstQuestionAndClickFirstFaqsPositiveTest(){
        customerContactFaqsPages.clickSelectQuestions();
        customerContactFaqsPages.clickOrderQuestion();

        assertEquals(customerContactFaqsPages.getTextOfQuestions(), "Delivery, Return or Refund"
                , "Failed to select question");

        customerContactFaqsPages.clickFaqOrderOne();

        String actPattern = "Pretty Perfect products can be returned in the";
        String expPattern = customerContactFaqsPages.getTextOfFaqOne();

        assertTrue(expPattern.contains(actPattern), "Failed to click element");
    }

    @Test
    public void selectFirstQuestionAndClickSecondFaqsPositiveTest(){
        customerContactFaqsPages.clickSelectQuestions();
        customerContactFaqsPages.clickOrderQuestion();

        String actualText = customerContactFaqsPages.getTextOfQuestions();
        String expectedText = "Delivery, Return or Refund";

        assertEquals(actualText, expectedText, "Selected question text does not match the expected text.");

        customerContactFaqsPages.clickFaqOrderTwo();

        String actPattern = "Our aim is to have your pram delivered within 7 working days";
        String expPattern = customerContactFaqsPages.getTextOfFaqTwo();

        assertTrue(expPattern.contains(actPattern), "Failed to click element");
    }

    @Test
    public void selectFirstQuestionAndClickThirdFaqsPositiveTest(){
        customerContactFaqsPages.clickSelectQuestions();
        customerContactFaqsPages.clickOrderQuestion();

        String actualText = customerContactFaqsPages.getTextOfQuestions();
        String expectedText = "Delivery, Return or Refund";

        assertEquals(actualText, expectedText, "Selected question text does not match the expected text.");

        customerContactFaqsPages.clickFaqOrderThree();

        String actPattern = "There is no difference in return policy";
        String expPattern = customerContactFaqsPages.getTextOfFaqThree();

        assertTrue(expPattern.contains(actPattern), "Failed to click element");
    }

    @Test
    public void selectFirstQuestionAndClickFourthFaqsPositiveTest(){
        customerContactFaqsPages.clickSelectQuestions();
        customerContactFaqsPages.clickOrderQuestion();

        String actualText = customerContactFaqsPages.getTextOfQuestions();
        String expectedText = "Delivery, Return or Refund";

        assertEquals(actualText, expectedText, "Selected question text does not match the expected text.");

        customerContactFaqsPages.clickFaqOrderFour();

        String actPattern = "Orders over $500 require a delivery signature";
        String expPattern = customerContactFaqsPages.getTextOfFaqFour();

        assertTrue(expPattern.contains(actPattern), "Failed to click element");
    }

    @Test
    public void selectFirstQuestionAndClickFifthFaqsPositiveTest(){
        customerContactFaqsPages.clickSelectQuestions();
        customerContactFaqsPages.clickOrderQuestion();

        String actualText = customerContactFaqsPages.getTextOfQuestions();
        String expectedText = "Delivery, Return or Refund";

        assertEquals(actualText, expectedText, "Selected question text does not match the expected text.");

        customerContactFaqsPages.clickFaqOrderFive();

        String actPattern = "Unfortunately, we do not have a process";
        String expPattern = customerContactFaqsPages.getTextOfFaqFive();

        assertTrue(expPattern.contains(actPattern), "Failed to click element");
    }

    @Test
    public void selectFirstQuestionAndClickSixthFaqsPositiveTest(){
        customerContactFaqsPages.clickSelectQuestions();
        customerContactFaqsPages.clickOrderQuestion();

        String actualText = customerContactFaqsPages.getTextOfQuestions();
        String expectedText = "Delivery, Return or Refund";

        assertEquals(actualText, expectedText, "Selected question text does not match the expected text.");

        customerContactFaqsPages.clickFaqOrderSix();

        String actPattern = "Go to bugaboo.mp-returns.com";
        String expPattern = customerContactFaqsPages.getTextOfFaqSix();

        assertTrue(expPattern.contains(actPattern), "Failed to click element");
    }

    @Test
    public void selectFirstQuestionAndClickAllFaqsPositiveTest() {
        customerContactFaqsPages.clickSelectQuestions();
        customerContactFaqsPages.clickOrderQuestion();

        String actualText = customerContactFaqsPages.getTextOfQuestions();
        String expectedText = "Delivery, Return or Refund";

        assertEquals(actualText, expectedText, "Selected question text does not match the expected text.");

        customerContactFaqsPages.clickFaqOrderOne();
        customerContactFaqsPages.clickFaqOrderTwo();
        customerContactFaqsPages.clickFaqOrderThree();
        customerContactFaqsPages.clickFaqOrderFour();
        customerContactFaqsPages.clickFaqOrderFive();
        customerContactFaqsPages.clickFaqOrderSix();

        String actPattern = "Go to bugaboo.mp-returns.com, log in using your Bugaboo order number, your ZIP code, or email address, and follow the steps to select which products you’d like to return and the reason for returning them.";
        String expPattern = customerContactFaqsPages.getTextOfFaqSix();

        assertTrue(expPattern.contains(actPattern), "Failed to click all 6 elements");
    }

    @Test
    public void clickingNextWithoutChoosingQuestionNegativeTest() {
        customerContactFaqsPages.clickNextBtn();

        assertTrue(customerContactFaqsPages.isErrorMessageDisplayed(), "Error message when next page without choosing a question.");
    }
}