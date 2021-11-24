Summary
--------
- The project has been implemented as a Maven Project using Selenium with Java.
- Page Object Model (POM) design pattern has been used in combination with Page Factory Design Pattern.
- OOP Principles have been used to optimize the code.
- log4j component has been added to generate logs wherever required.

Tests
--------
One automated test which checks if the amount on the main payments page and the invoice in the full history page is matching exactly.
This test case FAILS currently due to the bug on the UI.

Prerequisites
-------------
- Java 15.0.2
- Apache Maven 3.8.2
- Chrome 95

Instructions to execute the Automation Suite
---------------------------------------------
1) Make sure the prerequisites are installed with the same major version as above. Older versions MIGHT result in compatibility issues.
2) Add Java and Maven to PATH so that you can run them from any directory.
3) On command line, run git clone https://github.com/pavank2/DemoProject.git
4) Run "cd DemoProject"
5) Run "mvn clean install". This command will DOWNLOAD the dependencies, BUILD the project and EXECUTE too.
Please be patient while the dependencies are getting downloaded for the first time, and keep your fingers crossed :-)
6) Once the build and run is successful, you can check the execution status for all the Cucumber step definitions on the command line.
7) To run individual Test classes, execute mvn -Dtest=<Classname> test

**Note**: If mvn clean install throws errors, please open the project in any IDE (preferably IntelliJ) and the IDE will download the dependencies. 
You can also re-build the project.
Please feel free to contact me :-)

