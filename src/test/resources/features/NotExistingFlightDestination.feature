Feature: User selects the non-existing destination
  As a booking.com user I can set non-existing destination
  So Application should suggest some existing one

  Scenario Outline: Non-existing Start point is selected for flight
    Given I navigate to "<url>"
    When I select language "<language>" on Home page
    And I navigate to Flights page
    And I set Start point "<start>" on the Flight page
    Then I assert that Start point "<start>" is not available in suggested list on Flight page


    Examples:
      | url                    | language | start    |
      |https://www.booking.com |   USA    | Pechkino |