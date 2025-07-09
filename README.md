**BDD Framework for UI Automation**

**Overview**
This project demonstrates end-to-end web UI automation using **Java**, **Selenium WebDriver**, **Cucumber (BDD)**, and **Maven**. It follows the Page Object Model (POM) design pattern and integrates essential automation practices to simulate real-world testing environments.

**Tools & Technologies**
- Java
- Selenium WebDriver
- Cucumber BDD
- TestNG
- Maven
- Page Object Model (POM)
- Git
- Jenkins (CI-ready)
- ExtentReports (for reporting)

**How to Run the Project**

1. **Clone the Repository**
   ```bash
   git clone https://github.com/Sumer-Madaan/AutomationPractice.git
   ```

2. **Navigate to the Project Directory**
   ```bash
   cd AutomationPractice
   ```

3. **Run Tests Using Maven**
   ```bash
   mvn clean install
   ```

4. **View Test Reports**
   - Reports will be generated in the `test-output` directory.

**Project Structure**

| Folder                          | Description                                        |
|-------------------------------- | -------------------------------------------------- |
| `src/test/java/Pages`           | Page Object classes for web elements               |
| `src/test/java/StepDefinitions` | Cucumber step definitions                          |
| `src/test/java/Features`        | Feature files written in Gherkin                   |
| `src/test/java/Utilities`       | Utility classes like configurations, loggers, etc. |

**Features Covered**
- E-Commerce Cart functionality
- Page validations
- Test result reporting
- Cross-browser test setup
- Modular, maintainable structure

**Author**
[Sumer Madaan](https://www.linkedin.com/in/sumer-madaan)

**GitHub Repo**
https://github.com/Sumer-Madaan/AutomationPractice
