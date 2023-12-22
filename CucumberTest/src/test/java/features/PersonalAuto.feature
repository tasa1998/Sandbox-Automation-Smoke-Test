Feature: Creation and issuance of Personal Auto policies
  As a user, I should be able to issue Personal Auto policies for different vehicle types and with different test data.

  Background:
    Given the user opens the sandbox

  @PersonalAuto @Smoke
  Scenario Outline: Smoke test Personal Auto - <Row Num Personal Auto>

  This scenario tests the process of filling in all required fields to issue a Personal Auto insurance policy for different test data.

    Given load data from Auto excel file "<File Name>", "<Row Num Personal Auto>","<Row Num Customer>","<Row Num Home Page>"
    And  user logs in
    And user create new customer
    And user register quote
    And user fill in policy information Personal Auto
    And user fill in driver page
    And user fill in vehicle page
    And user fill in coverage page
#   Then verify that the appropriate referral is displayed
    When user binds quote
    Then verify that the policy has been issued


    Examples:
      | File Name                      | Row Num Personal Auto | Row Num Customer | Row Num Home Page |
      | src/TestData/AutoTestData.xlsx | 0                     | 1                | 0                 |
      | src/TestData/AutoTestData.xlsx | 2                     | 2                | 0                 |
      | src/TestData/AutoTestData.xlsx | 3                     | 4                | 0                 |
      | src/TestData/AutoTestData.xlsx | 6                     | 6                | 0                 |
      | src/TestData/AutoTestData.xlsx | 7                     | 7                | 18                |


  @PersonalAuto @Regression
  Scenario Outline: Smoke test Personal Auto <Row Num Personal Auto>

  This scenario tests the process of filling in all required fields to issue a Personal Auto insurance policy for multiple types of vehicles and incidents.

    Given load data from Auto excel file "<File Name>", "<Row Num Personal Auto>","<Row Num Customer>","<Row Num Home Page>"
    And user logs in
    When user create new customer
    And user register quote
    And user fill in policy information Personal Auto
    And user fill in driver page with incidents
    And user fill in vehicle page with extra vehicle
    And user fill in coverage page
    And user override underwriting referral
#   Then verify that the appropriate referral is displayed
    When user binds quote
    Then verify that the policy has been issued


    Examples:
      | File Name                      | Row Num Personal Auto | Row Num Customer | Row Num Home Page |
      | src/TestData/AutoTestData.xlsx | 0                     | 1                | 0                 |
      | src/TestData/AutoTestData.xlsx | 1                     | 3                | 0                 |