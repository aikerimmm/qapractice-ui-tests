# QA Practice UI Tests

<p align="center">
  <img src="images/qa-practice.png" alt="QA Practice" width="650">
</p>

## About the project

UI test automation project for the QA Practice web application.

The project covers main user scenarios and demonstrates UI test automation using Java, Selenide, JUnit 5, Gradle, Allure Report, Jenkins and Selenoid.

## 🛠 Technology Stack

<p align="center">
  <img width="55" title="Java" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg"/>
  &nbsp;&nbsp;
  <img width="55" title="Gradle" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/gradle/gradle-original.svg"/>
  &nbsp;&nbsp;
  <img width="55" title="Jenkins" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/jenkins/jenkins-original.svg"/>
  &nbsp;&nbsp;
  <img width="55" title="Git" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg"/>
  &nbsp;&nbsp;
  <img width="55" title="GitHub" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original.svg"/>
  &nbsp;&nbsp;
  <img width="55" title="IntelliJ IDEA" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg"/>
</p>

<p align="center">
  <b>Java 21</b> •
  <b>Selenide</b> •
  <b>Selenium WebDriver</b> •
  <b>JUnit 5</b> •
  <b>Gradle</b> •
  <b>Allure Report</b> •
  <b>Selenoid</b> •
  <b>Jenkins</b>
</p>

## 🧪 Test Coverage

Automated UI tests cover the following QA Practice functionality:

### 🔐 Login

- successful login with valid credentials
- login with invalid credentials
- validation of empty required fields
- parameterized authentication tests

### 📝 Web Form

- successful form submission with valid data
- validation of empty required fields

### 🛒 Ecommerce

- product search
- adding a product to the cart
- cart verification

## ▶️ Running Tests

Run all tests:

```bash
./gradlew clean test
```

Run tests remotely with Selenoid:

```bash
./gradlew clean test \
  -Dbrowser=Chrome \
  -DbrowserVersion=148.0 \
  -DbrowserSize=1920x1080 \
  -DbaseUrl=https://www.qapractice.com \
  -DremoteUrl=<SELENOID_URL> \
  -Dheadless=false
```

## 🔄 Jenkins

The project is integrated with Jenkins for automated test execution.

<p align="center">
  <a href="https://jenkins.qa.guru/job/41-Aikerim-qapractice-ui-tests/">
    <b>Open Jenkins Job</b>
  </a>
</p>

Tests are executed remotely using **Selenoid**.

<p align="center">
  <img src=".github/images/jenkins.png" alt="Jenkins" width="75%">
</p>

## 📊 Allure Report

Allure Report is generated automatically after test execution.

The report contains:

- test execution results
- test steps
- screenshots
- page source
- execution duration
- failure details

<p align="center">
  <img src=".github/images/allure.png" alt="Allure Report" width="75%">
</p>

Generate the report locally:

```bash
./gradlew allureReport
```

Open the report:

```bash
./gradlew allureServe
```

## 🎥 Test Execution

Tests are executed remotely in **Selenoid**.

<p align="center">
  <img src=".github/images/video/test-execution.gif" alt="Test Execution" width="750">
</p>


## 👩‍💻 Author

**Aikerim**

QA Automation Engineer