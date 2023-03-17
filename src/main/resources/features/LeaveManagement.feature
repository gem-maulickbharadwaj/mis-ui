#Author: shubham.kumar@geminisolutions.com
#Keyword: Leave Management

@leaveManagement
Feature: MIS - Leave Management

  Background: Login to MIS
    Given Login to MIS with Username shubham.kumar and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then User should be navigated to MIS homepage

  Scenario Outline: Navigate to Leave Management > Comp Off tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed

    Examples:
      | parentTab        | childTab | tab      | heading                                                  |
      | Leave Management | Apply    | Comp Off | Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Navigate to Leave Management > Apply tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed

    Examples:
      | parentTab        | childTab | tab   | heading                                                  |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Navigate to Leave Management > LWP Change Request tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed

    Examples:
      | parentTab        | childTab | tab                | heading                                                  |
      | Leave Management | Apply    | LWP Change Request | Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Navigate to Leave Management > Out of Duty/Tour tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed

    Examples:
      | parentTab        | childTab | tab           | heading                                                  |
      | Leave Management | Apply    | Out Duty/Tour | Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Navigate to Leave Management > WFH tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed

    Examples:
      | parentTab        | childTab | tab            | heading                                                  |
      | Leave Management | Apply    | Work From Home | Apply Leave / WFH / Comp Off / Out Duty / Change Request |