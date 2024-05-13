@HomeWork
Feature: Mouse Action Movements

  Scenario: Practice
    Given User is on Practice Page
    When User increments LEFT counter 7 times
    Then User verify that the LEFT counter increments by 7
    When User increments RIGHT counter 5 times
    Then User verify that the RIGHT counter is incremented by 5

  Scenario: Verify Mouse Over and Mouse Out Functionality
    Given User is on Practice Page
    When User moves the mouse over the grey zone
    Then User verify that the LEFT counter is incremented by 1
    When User moves the mouse out of the grey zone
    Then User verify that the LEFT counter is incremented by 2

  Scenario: Verify Red Zone Interaction
    Given User is on Practice Page
    When User moves the mouse in red zone
    Then User verify that the LEFT counter is incremented by 1
    When User moves the mouse out from red zone
    Then User verify that the LEFT counter is incremented by 2

  Scenario: Verify Mouse Leave Functionality
    Given User is on Practice Page
    When User moves the mouse over the grey rectangle on the right
    Then User verify that the counter does not increment
    When User moves the mouse out of the grey rectangle
    Then User verify that the RIGHT counter is incremented by 1