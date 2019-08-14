# hotelbooking

This project is developed in Eclipse using Selenium, TestNG and Maven.

1) Build and Execution Requirement
    - Assuming Java is installed. 
    - Download the latest Git. Clone this repo to your local machine.
    - cd to the root of the project directory
    - Download the latest Apache maven. Ensure you setup your system environment variable. In the command-line, execute the following commands to execute the tests:
       * mvn clean
       * mvn test
2) Test Reports
  - Test reports can be found in the repo after maven test: 
  .\hotelbookrepo\hotelbooking\target\surefire-reports
3) Limitations
   - As the hotel booking site is shared amongst testers, load and performance tests were not implemented.
   - Only Chrome version v76 driver is implemented for this project. For other types of browsers compatibility tests, the appropriate driver can be downloaded but is extended in this project.
   - No cross/multiple browsers test is implemented in this project. Tests can be extended using TestNG for parallel testing
