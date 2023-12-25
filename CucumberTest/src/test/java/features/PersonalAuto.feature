Feature: Creation and issuance of Personal Auto policies
  As a user, I should be able to issue Personal Auto policies for different vehicle types and with different test data.

  Background:
    Given the user opens the sandbox

  @PersonalAuto @Smoke
  Scenario Outline: Smoke test Personal Auto - <Row Num Personal Auto>

  This scenario tests the process of filling in all required fields to issue a Personal Auto insurance policy for different test data.

    Given load data from Auto excel file "<File Name>", "<Row Num Personal Auto>","<Row Num Customer>","<Row Num Vehicle>"
    And  user logs in
    And user create new customer
    And user register quote
    And user fill in policy information Personal Auto
    And user fill in driver page
    And user fill in vehicle page
    And user fill in coverage page
#   Then verify that the appropriate referral is displayed
    When user refer to UW
    Then verify that the policy has been issued


    Examples:
      | File Name                  | Row Num Personal Auto | Row Num Customer | Row Num Vehicle |
      | src/TestData/TestData.xlsx | 0                     | 0                | 0               |
