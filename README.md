# Api jsonplaceholder Test Automation
Automation Made by Edgar Silva

Date: April, 2021

Description:

This Automation was created from scratch using ruby language for test the provided APÌ in  https://jsonplaceholder.typicode.com/

It have automated tests running with github actions on each pull request on the main branch

## Requirements:
- Java 11+
- Maven

### The scope of this automation is:
* Validate if the emails in the comments are properly formatted
* Validate the username search by an inexistent user
* Validate the post search by an inexistent user id
* Validate the post comment search by an inexistent post id

### instalation:

- run the command bellow to install all dependencies:

```
 mvn clean install
```

### Execution:

To run all tests from command console:

```
mvn clean test
```


### UPDATE 22/02/2024

The pipeline for this project was configured with Github Actions to run on every pull request made on main branch

## Report Page:
After the test job finishes, a report page will be available ate the address below:

https://edgarmsilva.github.io/ApiJsonplaceholder_Java/