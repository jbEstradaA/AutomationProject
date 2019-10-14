Feature: Contact Us

  Scenario: Verify that the CUSTOMER SERVICE form be displayed successfully
    Given the user be in the automation practice principal web page
    When do click in the contact us button
    Then the CUSTOMER SERVICE form must be displayed

  Scenario:	Verify that a description message is displayed when the user select the subject type CUSTOMER SERVICE
    Given The user is in the CONTACT US section
    When The user click on subject select control
    And The user select the subject type "Customer service"
    Then The description message "For any question about a product, an order" must be displayed

  Scenario: Verify that a description message is displayed when the user select the subject type WEBMASTER
    Given The user is in the CONTACT US section
    When The user click on subject select control
    And The user select the subject type "Webmaster"
    Then The description message "If a technical problem occurs on this website" must be displayed