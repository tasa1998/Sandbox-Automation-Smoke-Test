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
    Then user logs out from the application

    And user logs in as Senior UW
    And user search for quote
    When user approve referrals
    Then user logs out from the application

    And  user logs in as Agency Producer
    And user search for quote
    When user binds quote
    Then user logs out from the application

    And user logs in as Senior UW
    And user create diary "<File Name>","<Diary Num>"

    When user create an Endorsement "<File Name>","<Endorsement Data Num>"
    And user add vehicle on Endorsement "<File Name>", "<Vehicle To Add Row Num>"
    Then user process an Endorsement

    And user start cancellation "<File Name>","<Cancellation Data Num>"
    And user process cancellation

    And user start reinstatement "<File Name>","<Reinstatement Data Num>"
    And user process reinstatement

    When user create an OOS Endorsement "<File Name>","<OOS Endorsement Data Num>"
    And user add driver on OOS Endorsement "<File Name>", "<Driver To Add Row Num>"
    Then user process an OOS Endorsement

    And user roll forward rolled back transaction

    And user start renewal
    And user process renewal

    Examples:
      | File Name                  | Row Num Personal Auto | Row Num Customer | Row Num Vehicle | Vehicle To Add Row Num | Endorsement Data Num | Diary Num | Cancellation Data Num | Reinstatement Data Num | OOS Endorsement Data Num | Driver To Add Row Num |
      | src/TestData/TestData.xlsx | 0                     | 0                | 0               | 1                      | 0                    | 0         | 0                     | 0                      | 1                        | 1                     |
