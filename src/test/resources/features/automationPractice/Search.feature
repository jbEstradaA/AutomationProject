Feature: SearchFunctionalities

  Scenario: do search in the database
    Given the user be in the automation practice principal web page
    When enter the text "Blouse" in the search text box
    And click in the search button
    Then verify that the search word "Blouse" is displayed in the results

