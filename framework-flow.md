# Playwright Framework Execution Flow

## Step 1 - Execute testng.xml

testng.xml

Defines:

* environment (qa/stage/prod)
* browser (chromium/firefox/webkit)
* execution type (local/browserstack)

---

## Step 2 - BaseTest Setup


@BeforeMethod

Runs before every test method.

Responsible for:

* loading environment configuration
* initializing browser
* creating page object

Flow:

testng.xml
      ↓
BaseTest.setup()


---

## Step 3 - BrowserFactory

BrowserFactory decides where test should run.

execution=local
      ↓
Local Browser

execution=browserstack
      ↓
BrowserStack Cloud Browser


Flow:

BaseTest
      ↓
BrowserFactory

---

## Step 4 - Playwright Objects Creation

BrowserFactory creates:

Playwright
      ↓
Browser
      ↓
BrowserContext
      ↓
Page


Stores them in ThreadLocal for parallel execution.

---

## Step 5 - Test Starts

Example:

LoginPageTests
      ↓
LoginPage


Test class should contain only test logic.

Page interactions belong to Page Objects.

---

## Step 6 - Page Object Layer

Example:

LoginPage
      ↓
page.fill()
page.click()
page.textContent()


All locators and actions are maintained inside page classes.
---

## Step 7 - Data Driven Testing

Flow:

login.json
      ↓
JsonUtils
      ↓
DataProvider
      ↓
Test Method

Test data remains separate from test code.

---

## Step 8 - API + UI Hybrid Flow

Flow:

APIClient
      ↓
Create Test Data
      ↓
Response
      ↓
UI Validation

Used when data setup is faster through APIs.

---

## Step 9 - Reporting

Listener captures execution result.

Test Pass
      ↓
Extent Report

Test Fail
      ↓
Screenshot
      ↓
Extent Report

---

## Step 10 - Teardown

@AfterMethod

Closes:

Page
      ↓
Browser
      ↓
Playwright

Executed after every test method.

---

# Complete Framework Flow


testng.xml
      ↓
BaseTest
      ↓
BrowserFactory
      ↓
Browser / BrowserStack
      ↓
BrowserContext
      ↓
Page
      ↓
Page Objects
      ↓
Test Classes
      ↓
Listeners
      ↓
Extent Report

---

# Supported Execution Modes


Local Execution

Docker Execution

GitHub Actions CI/CD

BrowserStack Cloud Execution