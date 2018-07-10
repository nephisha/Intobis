Feature: Portal

  @intobis @reset
  Scenario Outline: Verify Portal Links
    Given I launch the Intobis website
    And I navigate to Product Portals
    When I click on the "<available link>"
    Then I should be taken to the link homepage with "<title>"

    Examples:
    |available link |                           title                                    |
    #|www.booking.com|Booking.com: 1,940,680 hotels worldwide. 158+ million hotel reviews.|
    |www.agoda.com  |Official Agoda.com: Book Hotels for Cheap, up to 80% Off!           |