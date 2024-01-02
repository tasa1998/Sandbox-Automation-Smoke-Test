Feature: Creation and issuance of Personal Auto policies
  As a user, I should be able to issue Personal Auto policies for different vehicle types and with different test data.

  Background:
    Given the user opens the sandbox

  @PersonalAuto @Smoke
  Scenario Outline: Smoke test Personal Auto - <Row Num Personal Auto>

  This scenario tests the process of filling in all required fields to issue a Personal Auto insurance policy for different test data.

    Given load data from Auto excel file "<File Name>", "<Row Num Personal Auto>","<Row Num Customer>","<Row Num Vehicle>"
    And  user logs in as Agency Producer
    And user create new customer
    And user register quote
    And user fill in policy information Personal Auto
    And user fill in driver page
    And user fill in vehicle page
    And user fill in coverage page
    When user refer to UW

    Then user logs in as Senior UW
    And user search for quote
    And user approve referrals

    And  user logs in as Agency Producer
    And user search for quote
    And user binds quote

    When user create an Endorsement "<File Name>","<Endorsement Data Num>"
    And user add vehicle on Endorsement "<File Name>", "<Vehicle To Add Row Num>"
    Then user process and Endorsement


    Examples:
      | File Name                  | Row Num Personal Auto | Row Num Customer | Row Num Vehicle | Vehicle To Add Row Num |Endorsement Data Num|
      | src/TestData/TestData.xlsx | 0                     | 0                | 0               | 1                      |0                   |
