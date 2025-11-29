# Selenium Java Automation Framework

A complete Selenium-based test automation framework built with Java, TestNG, Page Object Model (POM), data-driven
testing, logging, and HTML reporting.  
Designed to be clean, scalable, and easy to maintain.

## 📁 Project Structure

```
qa-selenium/
│
├── Logs/
│ └── framework.log
│
├── reports/
│ └── extent-report.html
│
├── screenshots/
│ └── (failure screenshots)
│
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── core/
│ │ │ ├── BaseTest.java
│ │ │ ├── ConfigManager.java
│ │ │ └── LoggerManager.java
│ │ │
│ │ └── resources/
│ │ └── config.properties
│ │
│ └── test/
│ ├── java/
│ │ ├── core/
│ │ │ ├── ExtentManager.java
│ │ │ └── ExtentTestListener.java
│ │ │
│ │ ├── pages/
│ │ │ ├── CartPage.java
│ │ │ ├── CheckoutPage.java
│ │ │ ├── InventoryPage.java
│ │ │ ├── LoginPage.java
│ │ │ ├── MenuPage.java
│ │ │ └── NegativeLoginPage.java
│ │ │
│ │ ├── tests/
│ │ │ ├── CartTest.java
│ │ │ ├── CheckoutTest.java
│ │ │ ├── DataDrivenLoginTest.java
│ │ │ ├── InventoryTest.java
│ │ │ ├── LoginTest.java
│ │ │ ├── LogoutTest.java
│ │ │ ├── MenuTest.java
│ │ │ └── NegativeLoginTest.java
│ │ │
│ │ └── utils/
│ │ └── CSVReader.java
│ │
│ └── resources/
│ └── data/
│ └── loginData.csv
│
├── pom.xml
└── README.md
```

## ▶️ How to Run the Tests

### Option 1: Run tests from IntelliJ IDEA

1. Open the project in IntelliJ.
2. Navigate to `src/test/java/tests`.
3. Right-click any test class (for example: `LoginTest.java`).
4. Click **Run**.

### Option 2: Run the full test suite with Maven

Use the command below in the terminal:
mvn clean test

### Reports

After the test run:

- **HTML Report** is generated at:  
  /reports/extent-report.html

- **Execution Logs** are stored at:  
  /Logs/framework.log
