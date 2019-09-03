Feature: Search car for renting
  As a booking.com user I am able to find car for renting
  So I can set destination and date and get some cars are suggested

  Scenario Outline: Car Renting
    Given I navigate to "<url>"
    When I navigate to Car Renting page
    And I set parameters for car renting search on Car Renting page
        | destination | full_destination                                    | checkInDate | checkOutDate |
        | Berlin      | Berlin Tegel Airport, Berlin Federal State, Germany | 25/09/2019  | 08/10/2019   |
    And I click Search button on Car Renting page


    Examples:
       | url                     |
       | https://www.booking.com |



  Scenario Outline: Car Renting 2
    Given I navigate to "<url>"
    When I navigate to Car Renting page
    And I set destination "<destination>" on Car Renting page
    And I select destination "<full_destination>" in the dropdown on Car Renting page
    And I set check in date "<checkInDate>" on Car Renting page
    And I set check out date "<checkOutDate>" on Car Renting page
    And I click Search button on Car Renting page

    Examples:
      | url                     | destination | full_destination                                    | checkInDate | checkOutDate |
      | https://www.booking.com | London      | London, Greater London, United Kingdom              | 13/09/2019  | 15/09/2019   |
      | https://www.booking.com | Berlin      | Berlin Tegel Airport, Berlin Federal State, Germany | 25/09/2019  | 08/10/2019   |