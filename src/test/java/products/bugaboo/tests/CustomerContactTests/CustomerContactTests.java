package products.bugaboo.tests.CustomerContactTests;

import products.bugaboo.pages.CustomerContactPages.CustomerContactFaqsPages;
import products.bugaboo.pages.CustomerContactPages.CustomerContactPages;

import static org.testng.Assert.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BaseClass;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;


public class CustomerContactTests extends BaseClass {
    private CustomerContactPages customerContactPages = new CustomerContactPages();

    private CustomerContactFaqsPages customerContactFaqsPages = new CustomerContactFaqsPages();

    @BeforeMethod
    public void setUpMethod(){
        driver.get(ConfigurationReader.getProperty("bugaboo.url"));

        customerContactPages.clickOnAcceptAllCookies();

        BrowserUtils.pageVerification("Consumer Contact", driver.getTitle());
    }

    @AfterMethod
    public void clearCookies(){
        driver.manage().deleteAllCookies();
    }

    @Test
    public void fillOrderFormPositiveTest(){
        customerContactFaqsPages.clickSelectQuestions();

        customerContactFaqsPages.clickOrderQuestion();

        customerContactFaqsPages.clickNextBtn();

        customerContactPages.oneUploadFile();

        customerContactPages.oneUploadFileOk();

        customerContactPages.oneSelectCountry("CountriesList.US");

        customerContactPages.fillFormOne();

        customerContactPages.clickOneNextBtn();

        assertTrue(customerContactPages.isThankyouDisplayed(), "Form filled and success");
    }

    @Test
    public void fillOrderFormNegativeTest(){
        customerContactFaqsPages.clickSelectQuestions();

        customerContactFaqsPages.clickOrderQuestion();

        customerContactFaqsPages.doubleClickNextBtn();

        assertTrue(customerContactFaqsPages.isFormPageNotDisplayed()
                , "User did not land on form page");
    }

    @Test
    public void fillOrderFormInvalidEmailNegativeTest(){
        customerContactFaqsPages.clickSelectQuestions();

        customerContactFaqsPages.clickOrderQuestion();

        customerContactFaqsPages.clickNextBtn();

        customerContactPages.fillFormOneInvalidEmail();

        customerContactPages.clickOneNextBtn();

        assertTrue(customerContactPages.isOneEmailInvalid(),"User inputs invalid email");
    }

    @Test
    public void fillOrderFormNotSameEmailNegativeTest(){
        customerContactFaqsPages.clickSelectQuestions();

        customerContactFaqsPages.clickOrderQuestion();

        customerContactFaqsPages.clickNextBtn();

        customerContactPages.fillFormOneNotSameEmail();

        customerContactPages.clickOneNextBtn();

        assertTrue(customerContactPages.isNotSameEmail()
                ,"User inputs not matching emails");
    }
}
