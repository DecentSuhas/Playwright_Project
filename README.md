# Playwright Java Automation Framework

## Overview

This repository contains a scalable UI automation framework built using Playwright with Java.

The framework is designed with focus on:

* scalability
* maintainability
* parallel execution
* reusable architecture
* containerized execution
* clean reporting
* data-driven testing

The project demonstrates real-world automation framework design practices rather than simple script-based automation.

---

# Tech Stack

* Java
* Playwright
* TestNG
* Maven
* Extent Reports
* Logback
* Jackson
* Docker

---

# Framework Features

## UI Automation

* Playwright based UI automation
* Cross-browser execution support
* BrowserContext isolation
* Page Object Model (POM)

---

## Parallel Execution

* Thread-safe execution using ThreadLocal
* Parallel execution using TestNG
* Isolated browser/page/context handling

---

## Reporting

* Extent Reports integration
* Failure screenshots
* Base64 screenshot embedding
* Execution logging using Logback

---

## Retry Mechanism

* Failed test retry support using RetryAnalyzer

---

## Data-Driven Testing

* JSON-based test data management
* TestNG DataProvider integration
* Reusable JSON utility support

---

## Environment Management

* Environment-specific property files
* Configurable execution support

---

## Docker Support

* Dockerized framework execution
* Portable execution environment
* Browser/runtime isolation

---

# Project Structure

```text id="brm8vt"
src
 ├── main
 └── test
      ├── java
      │     ├── base
      │     ├── factory
      │     ├── listeners
      │     ├── pages
      │     ├── tests
      │     ├── utils
      │     ├── dataproviders
      │     └── config
      │
      └── resources
            ├── config
            ├── testdata
            └── logs
```

---

# Framework Architecture Highlights

## BrowserFactory

Responsible for:

* Playwright initialization
* Browser creation
* BrowserContext management
* Page lifecycle handling

ThreadLocal is used to support parallel-safe execution.

---

## BaseTest

Handles:

* setup
* teardown
* page initialization
* test lifecycle management

---

## Page Object Model

Each application page is separated into dedicated page classes to improve:

* maintainability
* readability
* reusability

---

# Execution Methods

## Run Using TestNG XML

```bash id="3qk4v0"
mvn test
```

Execution is controlled using:

```text id="59d2v9"
testng.xml
```

---

# Cross Browser Execution

Browser execution can be configured using TestNG parameters.

Supported browsers:

* Chromium
* Firefox
* Webkit

---

# Docker Execution

## Build Docker Image

```bash id="tj8j7t"
docker build -t playwright-framework .
```

---

## Run Docker Container

```bash id="tkt9es"
docker run playwright-framework
```

---

# Reporting

Extent Reports are generated after execution.

Reports include:

* test execution summary
* pass/fail status
* screenshots for failures
* execution logs

---

# Logging

Framework uses Logback for logging support.

Execution logs are generated for:

* browser actions
* failures
* execution flow

---

# Data Driven Testing

Test data is maintained using JSON files.

Example:

```text id="x3ks97"
src/test/resources/testdata
```

TestNG DataProviders are used to inject test data into test cases.

---

# Current Framework Capabilities

* Parallel execution
* Cross-browser execution
* Retry mechanism
* Docker support
* JSON data-driven testing
* Extent reporting
* Logging
* Environment management
* Thread-safe architecture

---

# Future Enhancements

Planned improvements:

* GitHub Actions CI integration
* Cloud execution support
* API + UI hybrid execution
* Allure reporting
* Database validation support
* Unified mobile/web automation support

---

# Key Learning Goals Of This Framework

This framework was built to deeply understand:

* automation framework architecture
* Playwright internals
* scalable test execution
* parallel execution design
* containerized automation execution
* maintainable automation practices

---

# Notes

This repository is intended as:

* a learning project
* framework experimentation project
* scalable automation framework reference

The focus is on understanding framework design decisions and execution architecture rather than only creating automated test scripts.
