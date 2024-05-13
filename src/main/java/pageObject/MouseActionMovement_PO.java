package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.Global_Vars;

public class MouseActionMovement_PO extends Base_PO{

    private @FindBy (css = "div[class='out overout'] div")
    WebElement outOverout;

    private @FindBy (css = "div[class='out enterleave'] div")
    WebElement outEnterleave;

    private @FindBy (css = "span[id='counterOne']")
    WebElement inRectangleLeftCounter;

    private @FindBy (css = "span[id='counterTwo']")
    WebElement inRectangleRightCounter;

    private @FindBy (css = "h2[id='content']")
    WebElement header;


    public int leftCounter(){
        return Integer.parseInt(inRectangleLeftCounter.getText());
    }

    public int rightCounter(){
        return Integer.parseInt(inRectangleRightCounter.getText());
    }

    public void goToPracticePage(){
        navigateTo_URL(Global_Vars.URL);
    }

    public void incrementLeftCounter(int counter){
        for(int i = 1; i <= counter; i++){
            moveMouseTo(outOverout, 0, 0);
            moveMouseTo(header, 0, 0);
        }
    }

    public void counterIncrementForLeftCounter(int counter){
        printLine("Number for the LEFT counter is " + leftCounter());
        Assert.assertEquals(leftCounter(), counter);
    }

    public void incrementRightCounter(int counter){
        for(int i = 1; i <= counter; i++){
            moveMouseTo(outEnterleave, 0, 0);
            moveMouseTo(header, 0, 0);
        }
    }

    public void counterIncrementForRightCounter(int counter){
        printLine("Number for the RIGHT counter is " + rightCounter());
        Assert.assertEquals(rightCounter(), counter);
    }

    public void mouseOverToLeftGrayZoneFromRedZone(){
        moveMouseTo(outOverout, 0,0);
        moveMouseTo(outOverout, 150,0);
    }

    public void verifyLeftCounter(int number){
        printLine("Number for the LEFT counter is " + leftCounter());
        Assert.assertEquals(leftCounter(), number);
    }

    public void mouseOutOfLeftGrayZone(){
        moveMouseTo(outOverout, 150, 0);
        moveMouseTo(header, 0, 0);
    }

    public void mouseInRedZone(){
        moveMouseTo(outOverout, 150,0);
        moveMouseTo(outOverout, 0,0);
    }

    public void mouseOverToRightGrayZone(){
        moveMouseTo(outEnterleave, 150, 0);
    }

    public void verifyIfCounterIsZero(){
        printLine("Number for the Right counter is " + rightCounter());
        Assert.assertEquals(rightCounter(), 0);
    }

    public void mouseOutOfRightGrayZone(){
        moveMouseTo(header, 0, 0);
    }

}
