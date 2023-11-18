Feature: Calculator Operations
  In order to verify that calculator operations work correctly
  As a user
  I want to test addition, subtraction, multiplication, and division

  Scenario: Addition
    Given I have a calculator presenter
    When I click on plus with arguments 1 and 2
    Then the result should be 3.0

  Scenario: Subtraction
    Given I have a calculator presenter
    When I click on minus with arguments 5 and 3
    Then the result should be 2.0

  Scenario: Multiplication
    Given I have a calculator presenter
    When I click on multiply with arguments 2 and 4
    Then the result should be 8.0

  Scenario: Division
    Given I have a calculator presenter
    When I click on divide with arguments 6 and 3
    Then the result should be 2.0

  Scenario: Division by Zero
    Given I have a calculator presenter
    And I set the second argument to 0
    When I click on divide with arguments 6 and 0
    Then an error should occur
