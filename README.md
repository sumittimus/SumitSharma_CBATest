# Provides instructions to set up, run tests locally.
# Stretched Goal -- Integrate with Docker for test case execution (ACHIEVED)

## PROJECT GITHUB LOCATION : https://github.com/sumittimus/SumitSharma_CBATest/tree/feature/SumitSharma-CBATest

##Here's a complete end-to-end QA automation framework that fulfills the Codility challenge. 

It focuses on:
1.	RestAssured for API Testing and TestNG for Test Execution.
2.	Parallel Execution using TestNG XML configuration.
3.	ExtentReports for Reporting.
4.	Fluent API style for writing test cases.
5.	Java 17 compatibility.
6.	Docker Integration for CI pipelines (using Maven and TestNG). (DOCKER INTEGRATION COMPLETED. CI INTEGRATION IN PROGRESS)
7.	Configurable properties with a config.properties file.


##Summary of Tests

Create Pet: Verifies a pet can be added with valid data.
Get Pet: Fetches a pet using an existing ID.
Update Pet: Updates a pet's details (name and status).
Delete Pet: Deletes an existing pet and ensures it is removed. 
//testDeletePet:fails sometimes since the pet id is already existing since the ID is generated randomly. Rerun of the test suite
// fixes the issue. Due to time constraints couldn't add further checks to 'update' instead of 'create' new.
Negative Test: Attempts to fetch a pet with an invalid ID.

HOW TO RUN 

## Steps to Run Locally on WINDOWS 11
1. Clone the repository.
2. Install Maven 3.8.8 and Java 17.
3. Setup Path, JAVA_HOME and MAVEN_HOME in environment variables
4. Navigate to the project folder via CMD (Windows-11)
5. Run tests:
mvn clean install
mvn test

## Run in Docker
1. Start Docker Desktop in your machine
2. docker build -t sumitsharma-cbatest .
3. docker run sumitsharma-cbatest

###TESTING CI######

## CI Pipeline Integration
---- IN PROGRESS ----------------
----NOW TESTING------------------
-------AGAIN TESTING--------------
