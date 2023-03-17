package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.mis.locators.LeaveManagementLocator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class LeaveManagementSteps {

    @Given("^Login to MIS with Username (.+) and password (.+)")
    public void login_to_mis_with_username_and_password(String user, String pass) {
        try {
            DriverAction.waitSec(5);
            if (DriverAction.isExist(LeaveManagementLocator.lgnusernm)) {
                DriverAction.typeText(LeaveManagementLocator.lgnusernm, user, "username");
            } else {
                GemTestReporter.addTestStep("Username", "Username field is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if (DriverAction.isExist(LeaveManagementLocator.lgnpwd)) {
                byte[] decodingString = Base64.decodeBase64(pass);
                String passwordDecoded = new String(decodingString);
                DriverAction.typeText(LeaveManagementLocator.lgnpwd, passwordDecoded);
            } else {
                GemTestReporter.addTestStep("Password", "Password field is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        } catch (Exception e) {
            GemTestReporter.addTestStep("EXCEPTION ERROR", "Getting exception while entering credentials", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @When("Click on Signin button")
    public void click_on_signin_button() {
        try {
            if (DriverAction.isExist(LeaveManagementLocator.sgnupbtn)) {
                DriverAction.click(LeaveManagementLocator.sgnupbtn, "sign in");
            } else {
                GemTestReporter.addTestStep("SignIn", "SignIn button is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @Then("User should be navigated to MIS homepage")
    public void navigateMisHomepage() {
        try {
            DriverAction.waitSec(8);
            String hidden = DriverAction.getAttributeName(LeaveManagementLocator.SkillPopup, "class");
            if (hidden.equalsIgnoreCase("modal fade in")) {
                if (DriverAction.isExist(LeaveManagementLocator.skillClosebtn)) {
                    DriverAction.click(LeaveManagementLocator.skillClosebtn, "Close button");
                } else {
                    GemTestReporter.addTestStep("Skill Close button", "Skill Close button is not present", STATUS.FAIL, DriverAction.takeSnapShot());
                }

            }
            presenceOfElement(LeaveManagementLocator.Location, 20);

            if (DriverAction.isExist(LeaveManagementLocator.Location) && DriverAction.isExist(LeaveManagementLocator.Dashboardheading)) {
                GemTestReporter.addTestStep("MIS Homepage", "User is on homepage of MIS", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("MIS Homepage", "User is not on homepage of MIS", STATUS.FAIL, DriverAction.takeSnapShot());

            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @And("User clicks on {string} sub tab of {string} tab in MIS")
    public void userClicksOnSubTabOfTabInMIS(String childTab, String parentTab) {
//        DriverAction.waitUntilElementAppear(By.xpath("//h3[@class='panel-title']"), 10);
        try {
            DriverAction.waitSec(3);
            DriverAction.waitUntilElementAppear(LeaveManagementLocator.menu_parentTabs(parentTab), 10);
            if (DriverAction.isExist(LeaveManagementLocator.menu_parentTabs(parentTab))) {
                DriverAction.click(LeaveManagementLocator.menu_parentTabs(parentTab), parentTab);
            } else {
                GemTestReporter.addTestStep("Error Occur", "Fail to click on " + parentTab, STATUS.FAIL,
                        DriverAction.takeSnapShot());
            }
            DriverAction.waitUntilElementAppear(LeaveManagementLocator.menu_parentTabs(parentTab), 10);
            if (DriverAction.isExist(LeaveManagementLocator.menu_childTabs(childTab))) {
                DriverAction.click(LeaveManagementLocator.menu_childTabs(childTab), childTab);
            } else {
                GemTestReporter.addTestStep("Error Occur", "Fail to click on " + childTab, STATUS.FAIL,
                        DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @And("Verify {string} of {string} tab")
    public void verifyOfTab(String expectedHeading, String childTab) {
        try {
            DriverAction.waitUntilElementAppear(LeaveManagementLocator.heading_Page, 10);
            String actualHeading = DriverAction.getElementText(LeaveManagementLocator.heading_Page);
            if (actualHeading.equals(expectedHeading)) {
                GemTestReporter.addTestStep("Verifying Heading",
                        "Heading matching passed.\nExpected Heading - " + expectedHeading +
                                "\nActual Heading - " + actualHeading, STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verifying Heading",
                        "Heading matching failed.\nExpected Heading - " + expectedHeading +
                                "\nActual Heading - " + actualHeading, STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @And("User clicks on {string} Tab")
    public void userClicksOnTab(String tabs) {
        try {
            DriverAction.waitSec(2);
            DriverAction.click(LeaveManagementLocator.navigation_tabs(tabs), tabs);
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @And("Verify {string} is displayed")
    public void verifyTabIsDisplayed(String tab) {
        try {
            DriverAction.waitSec(2);
            List<String> expectedFields = null;
            String id = null;
            switch (tab) {
                case "Leave":
                    id = "tabApplyLeave";
                    expectedFields = Arrays.asList("From*", "Till*", "Reason*", "Primary contact number*",
                            "Other contact number", "Availability on");
                    break;
                case "Work From Home":
                    id = "tabApplyWFH";
                    expectedFields = Arrays.asList("Date*", "Reason*", "Mobile No.*");
                    break;
                case "Comp Off":
                    id = "tabApplyCompOff";
                    expectedFields = Arrays.asList("Date*", "Reason*");
                    break;
                case "Out Duty/Tour":
                    id = "tabApplyOuting";
                    expectedFields = Arrays.asList("From*", "Till*", "Type *", "Reason*", "Primary contact " +
                            "number*", "Other contact number");
                    break;
                case "LWP Change Request":
                    id = "tabLWPChangeRequest";
                    expectedFields = Arrays.asList("In case of LWP marked by system", "Date:*", "Type of " +
                            "leave*", "Reason*");
                    break;
            }

            List<String> actualFields =
                    DriverAction.getElementsText(LeaveManagementLocator.title_LeaveFields(id));
            if (actualFields.equals(expectedFields)) {
                GemTestReporter.addTestStep("Verifying Fields",
                        "Fields matching passed.\nExpected Fields - " + expectedFields +
                                "\nActual Fields - " + actualFields, STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verifying Fields",
                        "Fields matching failed.\nExpected Fields - " + expectedFields +
                                "\nActual Fields - " + actualFields, STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    public void presenceOfElement(By elementXpath, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), time);
            wait.until(ExpectedConditions.presenceOfElementLocated(elementXpath));
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }
}
