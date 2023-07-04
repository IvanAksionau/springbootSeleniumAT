# Example of Spring Boot/Selenium test framework for WEB application testing.


### Framework features
* Test execution from xml files.
* Support of parallel test execution with Prototype Scope of spring framework.
* Various browsers support (Chrome, Firefox) from setup of 'spring.profiles.active=qa' in VM options/env variables of run configuration


### Remote execution on Selenium grid
* To activate settings you should specify required 'properties' files for spring configuration - 'spring.profiles.active=prod,remote'
![img.png](img.png)
-  $ docker-compose up -d --scale chrome=4 increase the number of containers for parallel tests execution.
- You can check if hub was started by CURL GET http://localhost:4444/wd/hub/status


### Useful links
* Spring bean scopes https://docs.spring.io/spring-framework/reference/core/beans/factory-scopes.html
* Cucumber parallel test execution https://cucumber.io/docs/guides/parallel-execution/?lang=java