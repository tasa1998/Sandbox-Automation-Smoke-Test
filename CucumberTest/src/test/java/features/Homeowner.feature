Feature: Creation and issuance of Homeowners policies

  As a user, I should be able to issue homeowners policies for different residence types and with different test data.

  Background:
    Given the user opens the sandbox

  @Homeowner @Smoke
  Scenario Outline: Smoke test Homeowners - <Row Num Homeowners>
  This scenario tests the process of filling in all required fields to issue a homeowners insurance policy for different residence types.

    Given load data from excel file "<File Name>", "<Row Num Homeowners>","<Row Num Customer>","<Row Num Home Page>"
    And user logs in
    And user create new customer
    And  user register quote
    And user fill in policy information
    And user fill in location coverage
    When user binds quote
    Then verify that the policy has been issued


    Examples:
      | File Name                            | Row Num Homeowners | Row Num Customer | Row Num Home Page |
      | src/TestData/HomeownersTestData.xlsx | 0                  | 1                | 2                 |
      | src/TestData/HomeownersTestData.xlsx | 2                  | 1                | 2                 |


  @Homeowner @Regression
  Scenario Outline: Regression test Homeowners - <Row Num Homeowners>
  This test scenario tests the issuance of policies with all mandatory fields filled in, additional coverages, and triggering of appropriate referrals.

    Given load data from excel file "<File Name>", "<Row Num Homeowners>","<Row Num Customer>","<Row Num Home Page>"
    And user logs in
    And user create new customer
    And user register quote
    And user fill in policy information
    And user fill in wind mitigation
    Then verify that the appropriate referral is displayed
    And user override underwriting referral
    When user binds quote
    Then verify that the policy has been issued


    Examples:
      | File Name                            | Row Num Homeowners | Row Num Customer | Row Num Home Page |
      | src/TestData/HomeownersTestData.xlsx | 4                  | 1                | 2                 |
      | src/TestData/HomeownersTestData.xlsx | 3                  | 1                | 2                 |
