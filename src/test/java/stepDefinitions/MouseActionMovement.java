package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Base_PO;
import pageObject.MouseActionMovement_PO;

public class MouseActionMovement extends Base_PO {
    MouseActionMovement_PO mouseActionMovement_po = new MouseActionMovement_PO();

    @Given("User is on Practice Page")
    public void userIsOnPracticePage(){
        mouseActionMovement_po.goToPracticePage();
    }

    @When("User increments LEFT counter {int} times")
    public void userMovesOverLeftGrayZone(int counter) {
        mouseActionMovement_po.incrementLeftCounter(counter);
    }

    @Then("User verify that the LEFT counter increments by {int}")
    public void userVerifyThatTheLeftCounterIncrementsBy(int counter) {
        mouseActionMovement_po.counterIncrementForLeftCounter(counter);
    }

    @When("User increments RIGHT counter {int} times")
    public void userMovesOverRightGrayZone(int counter) {
        mouseActionMovement_po.incrementRightCounter(counter);
    }

    @Then("User verify that the RIGHT counter is incremented by {int}")
    public void userVerifyThatTheRightCounterIncrementsBy(int counter) {
        mouseActionMovement_po.counterIncrementForRightCounter(counter);
    }

    @When("User moves the mouse over the grey zone")
    public void userMovesTheMouseOverTheGreyZone() {
        mouseActionMovement_po.mouseOverToLeftGrayZoneFromRedZone();
    }

    @Then("User verify that the LEFT counter is incremented by {int}")
    public void userVerifyThatTheLEFTCounterIsIncrementedBy(int number) {
        mouseActionMovement_po.verifyLeftCounter(number);
    }

    @When("User moves the mouse out of the grey zone")
    public void userMovesTheMouseOutOfTheGreyZone() {
        mouseActionMovement_po.mouseOutOfLeftGrayZone();
    }

    @When("User moves the mouse in red zone")
    public void userMoviesTheMouseInRedZone() {
        mouseActionMovement_po.mouseInRedZone();
    }

    @When("User moves the mouse out from red zone")
    public void userMoviesTheMouseOutFromRedZone() {
        mouseActionMovement_po.mouseOverToLeftGrayZoneFromRedZone();
    }


    @When("User moves the mouse over the grey rectangle on the right")
    public void userMovesTheMouseOverTheGreyRectangleOnTheRight() {
        mouseActionMovement_po.mouseOverToRightGrayZone();
    }

    @Then("User verify that the counter does not increment")
    public void userVerifyThatTheCounterDoesNotIncrement() {
        mouseActionMovement_po.verifyIfCounterIsZero();
    }

    @When("User moves the mouse out of the grey rectangle")
    public void userMovesTheMouseOutOfTheGreyRectangle() {
        mouseActionMovement_po.mouseOutOfRightGrayZone();
    }
}
