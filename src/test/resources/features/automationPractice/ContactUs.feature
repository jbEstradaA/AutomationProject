Feature: Contact Us

  Scenario: Verify that the CUSTOMER SERVICE form be displayed successfully
    Given the user be in the automation practice principal web page
    When do click in the contact us button
    Then the CUSTOMER SERVICE from must be displayed

  Scenario:	Verify that a description message is displayed when the user select the subject type CUSTOMER SERVICE
    Given The user is in the CONTACT US section
    When The user click on subject heading control
    And The user select the subject type "Customer service"
    Then Verify that description message "For any question about a product, an order" must be displayed

  Scenario: Verify that a description message is displayed when the user select the subject type WEBMASTER
    Given The user is in the CONTACT US section
    When The user click on subject heading control
    And The user select the subject type "Webmaster"
    Then Verify that description message "If a technical problem occurs on this website" must be displayed