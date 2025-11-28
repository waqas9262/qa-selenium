# Continuous Integration Plan for Selenium Framework

This document describes how the Selenium Java test framework should run in a Continuous Integration (CI) pipeline (
build → test → report).

## 1. When the CI pipeline should run (triggers)

- On every push to the `main` (or `master`) branch.
- On every pull request to `main` (for code review).
- Optionally, once every night (scheduled run) to catch flaky tests.

## 2. Pipeline steps (high-level)

The CI pipeline for this framework should follow three main stages:

1. **Build**
    - Install Java and Maven on the CI agent.
    - Restore Maven dependencies (Selenium, TestNG, WebDriverManager, ExtentReports, etc.).
    - Run `mvn clean compile` to make sure the project builds successfully.

2. **Test**
    - Run the full automated test suite with:
      ```bash
      mvn test
      ```
    - Tests will:
        - Start the browser using `BaseTest`.
        - Read configuration from `config.properties` via `ConfigManager`.
        - Use Page Object Model classes in `pages/`.
        - Use data-driven tests via `CSVReader` and `loginData.csv`.
        - Log key steps using `LoggerManager`.
        - Generate an Extent HTML report.

3. **Report**
    - After the tests finish, collect:
        - HTML report from `reports/extent-report.html`
        - Log file from `Logs/framework.log`
    - Mark the pipeline as:
        - **Failed** if any test fails.
        - **Passed** only if all tests pass.

## 3. Notifications and visibility

- If the pipeline fails:
    - Notify the team via email or chat (Slack / MS Teams).
    - Include a link to the CI job, the HTML report, and logs.
- If the pipeline passes:
    - Optionally post a short success message in the team channel.

## 4. Future improvements (optional)

- Run tests in parallel or on multiple browsers in CI.
- Add separate test stages (smoke vs full regression).
- Publish HTML report as a CI artifact so it can be downloaded from the pipeline UI.