Feature: Labcorp Career Job Search and Validation

  Scenario Outline: Search for QA Test Automation Developer job and validate details
    Given I launch the Lab corp website
    When I click on the Careers link
    And I search for "<jobTitleSearch>"
    And I select the job from the search results
    Then I validate the job title, job location, and job ID
    And I validate the first sentence of the third paragraph under Description Introduction
    And I validate the second bullet point under Management Support
    And I validate the third requirement as "<requirement>"
    And I validate the first suggested automation tool contains "<tool>"
    When I click Apply Now
    Then I return to the Job Search page
    Examples:
      | jobTitleSearch               | requirement                                                        | tool     |  |
      | Test Master Analyst  | 5+ years of experience in QA automation development and scripting. | Selenium |  |