Feature: BuyCart

  @tag
  Scenario Outline: Verify that the products with discount offer can be adding to buy cart
    Given the user be in the automation practice principal web page
    When do click on women menu
    And do click on dresses sub category button
    And choose the view to list mode
    And add the products with "Reduced price!" offer to the buy cart
    And the user check out the buy cart summary
    Then verify that the following products should be displayed into Shopping cart
    |Products|
    |Printed Summer Dress|
    |Printed Chiffon Dress|
    Examples:
    |     firstProduct              |     secondProduct     |
    | Printed Summer Dress          | Printed Chiffon Dress |
