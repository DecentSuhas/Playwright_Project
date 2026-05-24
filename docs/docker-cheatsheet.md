# Docker Cheat Sheet for Playwright Automation Framework

# What is Docker?

Docker helps package:

* Java
* Maven
* Playwright
* Browsers
* Framework code
* Dependencies

into a portable reusable execution environment called an **Image**.

The image can then run on any machine that has Docker installed.

---

# Important Concepts

## Docker Image

A packaged snapshot/template containing:

* OS layer
* Runtime
* Dependencies
* Framework code

Image itself is NOT running.

Think:

```text
Image = Blueprint/Class
```

---

## Docker Container

A running instance created FROM image.

Think:

```text
Container = Running Object
```

Multiple containers can run from same image.

---

# Why Docker?

Without Docker:

* Works on my machine issue
* Java mismatch
* Browser mismatch
* Dependency mismatch
* Environment inconsistency

With Docker:

* Same environment everywhere
* Same browser versions
* Same dependencies
* Portable execution

---

# Host Machine Requirements

Target machine only needs:

* Docker installed

Target machine does NOT need:

* Java
* Maven
* Browsers
* Playwright

Everything exists inside container image.

---

# Dockerfile

Dockerfile has NO extension.

Correct filename:

```text
Dockerfile
```

---

# Playwright Dockerfile Example

```dockerfile
FROM mcr.microsoft.com/playwright/java:v1.50.0

WORKDIR /app

COPY . .

RUN mvn clean install -DskipTests

CMD ["mvn", "test"]
```

---

# Docker Command Cheat Sheet

## Verify Docker Installation

```bash
docker --version
```

---

## View Running Containers

```bash
docker ps
```

---

## View All Containers

```bash
docker ps -a
```

---

## Build Docker Image

```bash
docker build -t playwright-framework .
```

Explanation:

* docker build → create image
* -t → tag/name
* playwright-framework → image name
* . → current directory

---

## View Images

```bash
docker images
```

---

## Run Container From Image

```bash
docker run playwright-framework
```

This creates temporary container from image and executes framework.

---

## Run Container In Interactive Mode

Useful for debugging container.

```bash
docker run -it playwright-framework bash
```

---

## Run Container With Custom Name

```bash
docker run --name pw-container playwright-framework
```

---

## Start Existing Container

```bash
docker start pw-container
```

---

## Stop Running Container

```bash
docker stop pw-container
```

---

## Remove Container

```bash
docker rm pw-container
```

---

## Remove Image

```bash
docker rmi playwright-framework
```

---

# Export Docker Image

Create portable tar file.

```bash
docker save -o playwright-framework.tar playwright-framework
```

---

# Load Docker Image On Another Machine

```bash
docker load -i playwright-framework.tar
```

---

# Run Loaded Image

```bash
docker run playwright-framework
```

---

# Save Reports To Host Machine

Without volume mapping:

* reports generated inside container
* reports disappear after container destroyed

Use volume mapping:

```bash
docker run -v "D:/Automation Repos/Playwright_Project/reports:/app/reports" playwright-framework
```

This maps:

```text
Host reports folder ↔ Container reports folder
```

---

# Important Notes

## Headless Execution

Containers usually run without GUI.

Use:

```properties
headless=true
```

---

## When To Rebuild Image?

Rebuild image if:

* framework code changes
* dependencies change
* Dockerfile changes

Command:

```bash
docker build -t playwright-framework .
```

---

# Important Understanding

## Build Phase

Expensive setup phase.
Installs:

* Java
* Maven
* Browsers
* Dependencies

Done during:

```bash
docker build
```

---

## Run Phase

Fast execution phase.

Done during:

```bash
docker run
```

Container created from already-built image.

No reinstall happens every execution.

---

# Can Multiple Containers Run From Same Image?

YES.

Example:

```bash
docker run playwright-framework
docker run playwright-framework
docker run playwright-framework
```

Each creates isolated container.

---

# Can Someone Extract Framework From Image?

YES.

Docker is NOT code protection.

If image contains source code, users can inspect container and access framework files.

---

# Real Use Cases

* CI/CD execution
* Environment consistency
* Portable automation execution
* Parallel scalable execution
* Cloud execution
* Reproducible runtime environments

---

# High-Level Mental Model

```text
Docker Image
    =
Portable preconfigured execution environment

Docker Container
    =
Running instance of that environment
```
