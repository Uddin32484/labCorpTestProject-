QA Automation Coding Test

Project Overview

This repository includes two automation solutions for the QA Coding Test using BDD principles:

UI Automation: Navigates www.labcorp.com to verify specific job details.

API Automation: Executes GET and POST requests using REST Assured and validates responses.

Project Structure

qa-automation-test/
├── README.md
├── pom.xml (for Java project)
├── src/
├── test/
├── java/
│   ├── stepdefinitions/
│   ├── runners/
│   ├── pages/
│   └── utilities/
└── resources/
├── features/
└── testdata/

Tech Stack

Java

Selenium WebDriver

Cucumber (BDD)

TestNG

REST Assured

Maven

Allure Reports

ChromeDriver

Prerequisites

Java 11+

Maven

Chrome Browser

IntelliJ or Eclipse

How to Run the Project

Step 1: Clone the Repository

git clone https://github.com/your-username/qa-automation-test.git
cd qa-automation-test

Step 2: Execute Test Cases

mvn clean test

Step 3: Generate Allure Report

mvn allure:report
mvn allure:serve

UI Test Automation: LabCorp Job Search

Feature File: labcorp_job_search.feature

Feature: LabCorp Career Page Job Verification
Scenario: Validate job details of a specific listing
Given User navigates to "https://www.labcorp.com"
When User clicks on the Careers link
And User searches for job title "QA Test Automation Developer"
And User clicks on the job listing
Then User verifies Job Title as "QA Test Automation Developer"
And User verifies Job Location as "Burlington, NC, United States"
And User verifies Job Id exists
And User verifies introduction third paragraph contains "test automation technology development"
And User verifies second bullet under Management Support as "Prepare test plans, budgets, and schedules."
And User verifies third requirement contains "5+ years of experience in QA automation development"
And User verifies first automation tool suggestion contains "Selenium"
When User clicks Apply Now
Then Job Title, Job Location, and Job ID should match
And User clicks Return to Job Search

API Automation: REST Assured

Feature File: rest_api_test.feature

Feature: API Automation using REST Assured

Scenario: GET request validation
Given API endpoint is "https://echo.free.beeceptor.com/sample-request?author=beeceptor"
When user sends GET request
Then response status should be 200
And response should contain path
And response should contain ip
And response should contain headers

Scenario: POST request validation
Given API endpoint is "http://echo.free.beeceptor.com/sample-request?author=beeceptor"
And user has valid payload for order creation
When user sends POST request
Then response status should be 200
And response should include correct order_id, customer, payment, and items

Notes

The Chrome browser must be installed and compatible with the WebDriver version.

REST Assured validations rely on predefined JSON keys in the response.

Test data should be placed under src/test/resources/testdata/ if needed.

Future Enhancements

Dockerize the framework

Add Cross-browser testing

Integrate into CI/CD pipelines (e.g., GitHub Actions)

Contact

Please reach out during the interview session for a walkthrough or questions related to the project

Author
Yub Uddin
Senior Software Developer in Test (SDET)
Email: yubuddin324841@gmail.com.com
LinkedIn: linkedin.com/in/yub32484
