@all @memo
Feature: Add to Memo

  As a user
  I would like to add an ad to Memo
  So I can access it faster later

  Scenario: Add ads to memo from list
    When user adds 3 ads to memo from list
    Then success pop-up should be visible
    When opens memo section
    Then the ads should be available in Memo section

  Scenario: Add ads to memo from advanced search
    Given user has made advanced search "vw"
    When user adds 5 ads to memo from search results
    Then success pop-up should be visible
    When opens memo section
    Then the ads should be available in Memo section

  Scenario: Add an ad to memo from ad itself
    Given user has opened an ad
    When user adds the ad to memo
    Then success pop-up should be visible
    When opens memo section
    Then the ads should be available in Memo section