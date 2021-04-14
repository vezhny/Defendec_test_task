**Environment requirements:**
1. JDK 8  (https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
2. Maven 3.1.1 or higher (https://maven.apache.org/download.cgi) installation guide: https://www.apache-maven.ru/install.html
3. Chrome or Firefox Browser

**Run:**
Execute command: _mvn clean test allure:aggregate -Dmaven.test.failure.ignore=true_

**Note:**
1. You can get report after run by opening **index.html**. Path: _target\site\allure-maven-plugin\index.html_
2. File **config.properties** (_src\main\resources\config.properties_) has base urls and using browser configs.
3.Apply _-Dselenium.browser=<**browser_name**>_ to your run command to specify using browser.
4. Specify _-Dtest=<test_class>_ param to run needed tests in class
5. Specify _-Dtest=<test_class>#<test_method>_ to run needed test