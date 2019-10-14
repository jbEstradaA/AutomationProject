$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/automationPractice/ContactUs.feature");
formatter.feature({
  "name": "Contact Us",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify that the CUSTOMER SERVICE form be displayed successfully",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user be in the automation practice principal web page",
  "keyword": "Given "
});
formatter.match({
  "location": "CustomerServiceSteps.theUserBeInTheAutomationPracticePrincipalWebPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "do click in the contact us button",
  "keyword": "When "
});
formatter.match({
  "location": "CustomerServiceSteps.doClickInTheContactUsButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the CUSTOMER SERVICE form must be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "CustomerServiceSteps.theCUSTOMERSERVICEFromMustBeDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify that a description message is displayed when the user select the subject type CUSTOMER SERVICE",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "The user is in the CONTACT US section",
  "keyword": "Given "
});
formatter.match({
  "location": "CustomerServiceSteps.theUserIsInTheCONTACTUSSection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The user click on subject select control",
  "keyword": "When "
});
formatter.match({
  "location": "CustomerServiceSteps.theUserClickOnSubjectSelectControl()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The user select the subject type \"Customer service\"",
  "keyword": "And "
});
formatter.match({
  "location": "CustomerServiceSteps.theUserSelectTheSubjectType(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The description message \"For any question about a product, an order\" must be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "CustomerServiceSteps.theDescriptionMessageMustBeDisplayed(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify that a description message is displayed when the user select the subject type WEBMASTER",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "The user is in the CONTACT US section",
  "keyword": "Given "
});
formatter.match({
  "location": "CustomerServiceSteps.theUserIsInTheCONTACTUSSection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The user click on subject select control",
  "keyword": "When "
});
formatter.match({
  "location": "CustomerServiceSteps.theUserClickOnSubjectSelectControl()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The user select the subject type \"Webmaster\"",
  "keyword": "And "
});
formatter.match({
  "location": "CustomerServiceSteps.theUserSelectTheSubjectType(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The description message \"If a technical problem occurs on this website\" must be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "CustomerServiceSteps.theDescriptionMessageMustBeDisplayed(String)"
});
formatter.result({
  "status": "passed"
});
});