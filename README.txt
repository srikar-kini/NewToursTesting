/*
#### Author: Srikar Kini
#### NewTours Test Project
#### Date created: 12/01/2019
 */
 
 Notes:
 --> Sample Test Automation project for http://newtours.demoaut.com/ 
 --> Test Framework is built upon on Maven and Serenity-Cucumber with Java
 --> Test inputs are stored in EnvDetails.properties
 --> Test reports and logging are stored under: ~/target/site/serenity/index.html (Serenity report)
 --> screenshots are stored under: ~/src/test/resources/files/screenshots/
 --> sample IDE maven configuration to run the tests: mvn clean test serenity:aggregate -Dmaven.test.failure.ignore=true -Dtest=RunNewToursTest