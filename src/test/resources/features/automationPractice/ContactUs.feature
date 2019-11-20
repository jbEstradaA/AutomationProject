Feature: Contact Us

  Scenario: Verify that the CUSTOMER SERVICE form be displayed successfully
    Given the user be in the automation practice principal web page
    When do click in the contact us button
    Then the CUSTOMER SERVICE from must be displayed

  Scenario:	Verify that a description message is displayed when the user select the subject type CUSTOMER SERVICE
    Given the user is in the CONTACT US section
    When the user click on subject heading control
    And the user select the subject type "Customer service"
    Then verify that description message "For any question about a product, an order" must be displayed

  Scenario: Verify that a description message is displayed when the user select the subject type WEBMASTER
    Given the user is in the CONTACT US section
    When the user click on subject heading control
    And the user select the subject type "Webmaster"
    Then verify that description message "If a technical problem occurs on this website" must be displayed

  Scenario Outline: Verify that the Email address field only allow an valid email account
    Given the user be in the automation practice principal web page
    When do click in the contact us button
    And the user enter an "<invalidEmail>" in the Email address field
    And the left the Email address field
    Then verify that the field Email address should show a validation
   Examples:
    | invalidEmail              |
    | 123123                    |
    | user$@gmailcom            |
    | user\"@gmail.com          |

