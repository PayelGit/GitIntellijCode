
Feature: Test functionality of placing a product

@TC_01
Scenario: Verify whether user is able to place a product in Selenium practice page
  Given user is in SeleniumPractice page
  When user searches for a product
  And user process to checkout
  Then user verifies the product
  And user places an order


  @TC_02
  Scenario: Verify whether user is able to search a product in Selenium practice page
    Given user is in SeleniumPractice page
    When user searches for a product
    And user navigates to offer page and search the same product
    Then user verifies the product in both pages


#  @TC_03
#  Scenario: Verify whether user is able to search a product in Selenium practice page
#    Given user is in google page
#    When user starts the stopwatch


#  @TC_04
#  Scenario: Verify whether user is able to extract email from pdf
#    Given user is in emails extractor page
#    When user chooses file for email extraction
#    And user extract the emails and copies it
