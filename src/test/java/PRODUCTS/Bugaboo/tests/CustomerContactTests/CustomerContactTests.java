package PRODUCTS.Bugaboo.tests.CustomerContactTests;

import PRODUCTS.Bugaboo.pages.CustomerContactPages.CustomerContactFaqsPages;
import PRODUCTS.Bugaboo.pages.CustomerContactPages.CustomerContactPages;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BaseClass;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.WaitUtils;

import java.util.List;

public class CustomerContactTests extends BaseClass {
    private CustomerContactPages customerContactPages = new CustomerContactPages();

    private CustomerContactFaqsPages customerContactFaqsPages = new CustomerContactFaqsPages();

    @BeforeMethod
    public void setUpMethod(){
        driver.get(ConfigurationReader.getProperty("bugaboo.url"));

        customerContactPages.clickOnAcceptAllCookies();

        BrowserUtils.pageVerification("Consumer Contact", driver.getTitle());
    }

    @Test
    public void fillOrderForm() throws InterruptedException {
        customerContactFaqsPages.clickSelectQuestions();

        customerContactFaqsPages.clickOrderQuestion();

        customerContactFaqsPages.clickNextBtn();
        Thread.sleep(3000);
        customerContactPages.solveCaptcha();
        customerContactPages.oneUploadFile();

        customerContactPages.oneUploadFileOk();

        customerContactPages.fillFormOne();

        customerContactPages.oneSelectCountry("CountriesList.US");
        //Thread.sleep(5000);

        //Thread.sleep(5000);

        //Thread.sleep(5000);
        customerContactPages.clickOneNextBtn();
        Thread.sleep(10000);

        assertTrue(customerContactPages.isThankyouDisplayed());
    }


}
