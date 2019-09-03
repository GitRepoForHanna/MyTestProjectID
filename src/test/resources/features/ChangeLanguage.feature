Feature: Language and currency selection
  As a booking.com user I am able to change the Language and Currency

  Scenario Outline: Navigation to Booking.com test
  Given I navigate to "<url>"
    When I select language "<language>" on Home page
    When I select currency "<currency>" on Home page

    Examples:
      | url                    | language | currency       |
      |https://www.booking.com |   USA    | RUSSIAN_RUBLES |
