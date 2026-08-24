# QA Practice UI Tests

<p align="center">
  <img src="images/qa-practice.png" alt="QA Practice UI Tests" width="350">
</p>

## About the project

UI test automation project for the QA Practice web application.

The project covers main user scenarios and demonstrates UI test automation using Java, Selenide, JUnit 5, Gradle, Allure Report, Allure TestOps, Jenkins and Selenoid.

## Technology Stack

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange">
  <img src="https://img.shields.io/badge/Selenide-7-green">
  <img src="https://img.shields.io/badge/JUnit-5-blue">
  <img src="https://img.shields.io/badge/Gradle-8-green">
  <img src="https://img.shields.io/badge/Allure-Report-yellow">
  <img src="https://img.shields.io/badge/Jenkins-CI%2FCD-red">
</p>

## Test Scenarios

- Successful login with valid credentials
- Login with invalid credentials
- Login validation with empty required fields
- Web form submission
- UI element validation

## Running Tests

Run tests locally:

```bash
./gradlew clean test
```

Generate Allure Report:

```bash
./gradlew allureReport
```

Open Allure Report:

```bash
./gradlew allureServe
```

## Jenkins

The project is integrated with Jenkins CI for remote test execution.

### [Open Jenkins Job](https://jenkins.qa.guru/job/41-Aikerim-qapractice-ui-tests/)

<p align="center">
  <a href="https://jenkins.qa.guru/job/41-Aikerim-qapractice-ui-tests/">
    <img src="images/jenkins.png" alt="Jenkins" width="850">
  </a>
</p>

## Allure Report

Allure Report is used to display test execution results, test steps and attachments.

### [Open Allure Report](https://jenkins.qa.guru/job/41-Aikerim-qapractice-ui-tests/allure/)

<p align="center">
  <a href="https://jenkins.qa.guru/job/41-Aikerim-qapractice-ui-tests/allure/">
    <img src="images/allure-report.png" alt="Allure Report Overview" width="850">
  </a>
</p>

<p align="center">
  <a href="https://jenkins.qa.guru/job/41-Aikerim-qapractice-ui-tests/allure/">
    <img src="images/allure-report2.png" alt="Allure Report Test Results" width="850">
  </a>
</p>

## Allure TestOps

The project is integrated with Allure TestOps for test management and test execution analysis.

### [Open Allure TestOps](https://allure.qa.guru/launch/55931)

<p align="center">
  <a href="https://allure.qa.guru/launch/55931">
    <img src="images/allure-testops1.png" alt="Allure TestOps Launch" width="850">
  </a>
</p>

<p align="center">
  <a href="https://allure.qa.guru/launch/55931">
    <img src="images/allure-testops2.png" alt="Allure TestOps Test Results" width="850">
  </a>
</p>

## Test Execution

<p align="center">
  <img src="images/test-execution.gif" alt="UI Test Execution" width="800">
</p>