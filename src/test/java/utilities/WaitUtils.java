package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitUtils extends BaseClass{

    public static void waitUntilElmIsDisplayed(By elm){
        wait.until(ExpectedConditions.presenceOfElementLocated(elm));
    }

    public static void waitUntilElmIsDisplayed(WebElement elm){
        wait.until(ExpectedConditions.elementToBeClickable(elm));
    }

    public static void waitUntilElmIsVisible(By elm){
        wait.until(ExpectedConditions.visibilityOfElementLocated(elm));
    }


    public static void waitUntilElmIsInvisible(By elm){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elm));
    }

    public static void waitUntilElmIsClickable(WebElement elm){
        wait.until(ExpectedConditions.elementToBeClickable(elm));
    }

    public static void waitFrameToBeAvailableAndSwitchToIt(WebElement elm){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(elm));
    }




    //non visibility condition
    //enabled?
    public static void sleep(int sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
