package products.bugaboo.tests.CustomerContactTests;

import products.bugaboo.pages.CustomerContactPages.CustomerContactFaqsPages;
import products.bugaboo.pages.CustomerContactPages.CustomerContactPages;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BaseClass;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;

import static org.testng.Assert.*;

public class CustomerContactFaqsTests extends BaseClass {
    private CustomerContactPages customerContactPages = new CustomerContactPages();
    private CustomerContactFaqsPages customerContactFaqsPages = new CustomerContactFaqsPages();

    @BeforeMethod
    public void setUpMethod() {
        driver.get(ConfigurationReader.getProperty("bugaboo.url"));

        customerContactPages.clickOnAcceptAllCookies();

        BrowserUtils.pageVerification("Consumer Contact", driver.getTitle());
    }

    @AfterMethod
    public void clearCookies(){
        driver.manage().deleteAllCookies();
    }

    @Test
    public void selectFirstQuestionAndClickFirstFaqsPositiveTest(){
        customerContactFaqsPages.clickSelectQuestions();
        customerContactFaqsPages.clickOrderQuestion();

        assertEquals(customerContactFaqsPages.getTextOfQuestions(), "Delivery, Return or Refund"
                , "Selected question text does not match the expected text.");

        customerContactFaqsPages.clickFaqOrderOne();

        assertTrue(customerContactFaqsPages.getTextOfFaqOne().contains("Pretty Perfect products")
                , "Failed to click element");
    }

    @Test(priority = 1)
    public void selectFirstQuestionAndClickSecondFaqsPositiveTest(){
        customerContactFaqsPages.clickSelectQuestions();
        customerContactFaqsPages.clickOrderQuestion();

        assertEquals(customerContactFaqsPages.getTextOfQuestions(), "Delivery, Return or Refund"
                , "Selected question text does not match the expected text.");

        customerContactFaqsPages.clickFaqOrderTwo();

        assertTrue(customerContactFaqsPages.getTextOfFaqTwo().contains("Our aim is to have")
                , "Failed to click element");
    }

    @Test(priority = 1)
    public void selectFirstQuestionAndClickThirdFaqsPositiveTest(){
        customerContactFaqsPages.clickSelectQuestions();
        customerContactFaqsPages.clickOrderQuestion();

        assertEquals(customerContactFaqsPages.getTextOfQuestions(), "Delivery, Return or Refund"
                , "Selected question text does not match the expected text.");

        customerContactFaqsPages.clickFaqOrderThree();

        assertTrue(customerContactFaqsPages.getTextOfFaqThree().contains("There is no difference")
                , "Failed to click element");
    }

    @Test(priority = 1)
    public void selectFirstQuestionAndClickFourthFaqsPositiveTest(){
        customerContactFaqsPages.clickSelectQuestions();
        customerContactFaqsPages.clickOrderQuestion();

        assertEquals(customerContactFaqsPages.getTextOfQuestions(), "Delivery, Return or Refund"
                , "Selected question text does not match the expected text.");

        customerContactFaqsPages.clickFaqOrderFour();

        assertTrue(customerContactFaqsPages.getTextOfFaqFour().contains("Orders over $500")
                , "Failed to click element");
    }

    @Test(priority = 1)
    public void selectFirstQuestionAndClickFifthFaqsPositiveTest(){
        customerContactFaqsPages.clickSelectQuestions();
        customerContactFaqsPages.clickOrderQuestion();

        assertEquals(customerContactFaqsPages.getTextOfQuestions(), "Delivery, Return or Refund"
                , "Selected question text does not match the expected text.");

        customerContactFaqsPages.clickFaqOrderFive();

        assertTrue(customerContactFaqsPages.getTextOfFaqFive().contains("Unfortunately, we do not")
                , "Failed to click element");
    }

    @Test(priority = 1)
    public void selectFirstQuestionAndClickSixthFaqsPositiveTest(){
        customerContactFaqsPages.clickSelectQuestions();
        customerContactFaqsPages.clickOrderQuestion();

        assertEquals(customerContactFaqsPages.getTextOfQuestions(), "Delivery, Return or Refund"
                , "Selected question text does not match the expected text.");

        customerContactFaqsPages.clickFaqOrderSix();

        assertTrue(customerContactFaqsPages.getTextOfFaqSix().contains("Go to bugaboo.mp-returns.com")
                , "Failed to click element");
    }

    @Test(priority = 1)
    public void selectFirstQuestionAndClickAllFaqsPositiveTest() {
        customerContactFaqsPages.clickSelectQuestions();
        customerContactFaqsPages.clickOrderQuestion();

        assertEquals(customerContactFaqsPages.getTextOfQuestions(), "Delivery, Return or Refund"
                , "Selected question text does not match the expected text.");

        customerContactFaqsPages.clickFaqOrderOne();
        customerContactFaqsPages.clickFaqOrderTwo();
        customerContactFaqsPages.clickFaqOrderThree();
        customerContactFaqsPages.clickFaqOrderFour();
        customerContactFaqsPages.clickFaqOrderFive();
        customerContactFaqsPages.clickFaqOrderSix();

        assertTrue(customerContactFaqsPages.getTextOfFaqSix().contains("Go to bugaboo")
                , "Failed to click all 6 elements");
    }

    @Test
    public void clickingNextWithoutChoosingQuestionNegativeTest() {
        customerContactFaqsPages.clickNextBtn();

        assertTrue(customerContactFaqsPages.isErrorMessageDisplayed()
                , "Error message when next page without choosing a question.");
    }
}