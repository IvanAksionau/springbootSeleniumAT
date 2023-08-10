# SpringBoot/Selenium/Cucumber test framework for WEB application testing.

[![Java CI with Maven](https://github.com/IvanAksionau/springbootSeleniumAT/actions/workflows/ci_settings.yml/badge.svg)](https://github.com/IvanAksionau/springbootSeleniumAT/actions/workflows/ci_settings.yml)

[![img_4.png](img_4.png)](https://ivanaksionau.github.io/springbootSeleniumAT/overview-features.html)

### Preconditions:

* Installed Java 17
* Installed Maven
* Installed Docker

### Framework features:

* Up-and running Selenium hub with 5 chrome nodes. with docker-compose.yml configuration.
* Parallel test execution with Cucumber.
* Execute tests described in BDD stile as Cucumber features on both local or remote chrome drivers.
* Cross browser testing with Chrome and Firefox on Selenium hube notes.
* Test execution on CI with GitHub Actions.
* Test report generation with Cucumber reporting plugin.(find
  in ```target/cucumber-html-reports/overview-failures.html```)

### Test execution:

- Run
  command ```mvn clean install -D"app.env=dev" -D"app.url=https://dev-kayanee.myshopify.com/" -D"driver.options=--headless,--remote-allow-origins=*``` -
  will start tests on local chrome driver.
- Run directly any ...xml file located in the root folder.(ex. 'smoke-module_cucumber_runner.xml')
- Various browsers support (Chrome, Firefox) from setup of ```spring.profiles.active=qa``` in VM options/env variables
  of run configuration.

### Remote execution on Selenium hub:

- Run command ```docker-compose up -d --scale chrome=5``` from a root project folder to start selenium hub and 5 chrome
  nodes.
- Go to http://localhost:4444/grid/console to check 'Grid Console'.
- You can check if hub was started by CURL GET http://localhost:4444/wd/hub/status

- Run command ```mvn clean install -D"app.env=dev" -D"app.url=https://dev-kayanee.myshopify.com/" -D"spring.profiles.active=remote"``` -
  will start tests on remote selenium hub.
- To activate settings you should specify required 'properties' files for spring
  configuration - ```spring.profiles.active=prod,remote``` or ```spring.profiles.active=qa,remote```

![img.png](img.png)

### CI integration:

- On each comment push to master branch/pull request tests will be executed with GitHub Actions.
- You can check the results of the execution in the 'Actions' tab of the repository.
- Bellow you see how repository is set to deploy the report:

![img_1.png](img_1.png)
![img_2.png](img_2.png)

- You can access last generate report by https://ivanaksionau.github.io/springbootSeleniumAT/overview-features.html

### Useful links:

- About cucumber https://habr.com/ru/articles/332754/
- Spring bean scopes https://docs.spring.io/spring-framework/reference/core/beans/factory-scopes.html
- Cucumber parallel test execution https://cucumber.io/docs/guides/parallel-execution/?lang=java
- Cucumber reporting https://github.com/damianszczepanik/maven-cucumber-reporting
- cucumber-report-annotations-action https://github.com/deblockt/cucumber-report-annotations-action
- GitHub Pages https://pages.github.com/
- GitHub Action to deploy your static files to GitHub Page https://github.com/peaceiris/actions-gh-pages
- Selenium Wait Commands: Implicit, Explicit, and Fluent Wait https://www.browserstack.com/guide/wait-commands-in-selenium-webdriver
- Selenium Grid https://www.browserstack.com/guide/selenium-grid-tutorial
- Selenium Grid https://www.selenium.dev/documentation/en/grid/
- https://www.checkout.com/docs/developer-resources/testing/test-cards - test cards
