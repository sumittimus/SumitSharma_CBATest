# Provides instructions to set up, run tests locally.
# Stretched Goal -- Integrate with Docker image test case execution

Here's a complete end-to-end QA automation framework that fulfills the Codility challenge. 

It focuses on:
1.	TestNG for Test Execution.
2.	Parallel Execution using TestNG XML configuration.
3.	ExtentReports for Reporting.
4.	Fluent API style for writing test cases.
5.	Java 17 compatibility.
6.	Docker Integration for CI pipelines (using Maven and TestNG). 
7.	Configurable properties with a config.properties file.


Summary of Tests

Create Pet: Verifies a pet can be added with valid data.
Get Pet: Fetches a pet using an existing ID.
Update Pet: Updates a pet's details (name and status).
Delete Pet: Deletes an existing pet and ensures it is removed.
Negative Test: Attempts to fetch a pet with an invalid ID.