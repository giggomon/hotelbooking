# hotelbooking

This project is developed in Eclipse using Selenium, TestNG and Maven. All the dependencies are handled by Maven. It consists of automated tests that are developed to test against a hotel booking website.

1) Build and Execution Requirement
    - Assuming Java is installed. 
    - Download the latest Git. Clone this repo to your local machine.
    - cd to the root of the project directory
    - Download the latest Apache maven. Ensure the system environment variable is setup. In the command-line, execute the following commands to execute the tests:
       * mvn clean
       * mvn test
2) Automated Tests
   Consists of creating and deleting of bookings with positive input data only. It does not check for negative input tests as those are covered by the manual exploratory tests. 
3) Test Reports
     - Test reports can be found in the repo after maven test: .\hotelbookrepo\hotelbooking\target\surefire-reports
4) Limitations
   - As the hotel booking site is shared amongst testers, load and performance tests were not implemented.
   - Only Chrome version v76 driver is implemented for this project. For other types of browsers compatibility tests, the appropriate driver can be downloaded but is extended in this project.
   - No cross/multiple browsers test is implemented in this project. Tests can be extended using TestNG for parallel testing
