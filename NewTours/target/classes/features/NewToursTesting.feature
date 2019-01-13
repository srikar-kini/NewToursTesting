Feature: The NewTours website is used for flight bookings.

  Scenario: Validate that an unregistered user cannot login in to the NewTours website.
    Given I am a web user who navigates to the NewTours website
    When I provide an unregistered user details
    And I click on the sign-in button
    Then I shouldn't be allowed to login and the booking page should not be displayed

  Scenario Outline: Validate that the web user is able to perform flight bookings
    Given I am a web user who navigates to the NewTours website
    When I provide valid username as "testuser120119" and password as "Welcome1!"
    Then the user successfully logs in and is able to see the bookings page
    And provides "<Departing From>" , "<On Month>" , "<On Day>"
    And provides "<Arriving In>" , "<Returning Month>" , "<Returning Day>" , "<Airline>"
    Then the user is able to successfully make the booking
    Examples:
      | Departing From | On Month | On Day | Arriving In | Returning Month | Returning Day | Airline             |
      | Acapulco       | November | 10     | Frankfurt   | November        | 17            | Blue Skies Airlines |
      | London         | December | 20     | New York    | December        | 30            | Unified Airlines    |

  Scenario: Validate that the NewTours application requires the Origin and Destination locations to be different
    Given I am a web user who navigates to the NewTours website
    When I provide valid username as "testuser120119" and password as "Welcome1!"
    Then the user successfully logs in and is able to see the bookings page
    And when the user chooses the same location for origin and destination
    Then the web application doesn't let the user to proceed with booking
