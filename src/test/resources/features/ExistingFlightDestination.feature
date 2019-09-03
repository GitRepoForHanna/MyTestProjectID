Feature: User selects the existing destination
  As a booking.com user I can set existing destination
  So Application should suggest this destination on help panel

  @ForRun
  Scenario Outline: Existing Start point is selected for flight
    Given I navigate to "<url>"
    When I select language "<language>" on Home page
    And I navigate to Flights page
    And I set Start point "<start>" on the Flight page
    Then I assert that Start point "<start_short_name>" is not available in suggested list on Flight page
    When I select Start point "<start_short_name>" on the Flight page
#    Then I assert that Start point is "<start_short_name>" on the Flight page


    Examples:
      | url                    | language | start | start_short_name |
      |https://www.booking.com |   USA    | Kiev  | Kiev (IEV)       |