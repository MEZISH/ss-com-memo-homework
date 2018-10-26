# Homework: testing particular feature for ad portal using Selenium

Feature to test:
Adding ad to memo as a favourite. Go to any category, search for an ad, open it, scroll down to see “Add to favourites”. Once you click it, it gets added to the “Memo" section (on the top in the header menu). Alternatively, you can select ads from the list and add several to Memo at once. You can do that while searching as well - the advanced search from the header menu. Please be sure to achieve a reasonable coverage of the feature to test. Feel free to do any other use case that you feel could demonstrate your testing decisions better.

## Getting Started

These instructions will get your copy of the project up and running on your local machine
### Prerequisites

* Windows system
* Installed Java 8
* Installed Google Chrome Web browser

## Running the tests

Clone the repository and launch the following command in the project directory:
```
gradlew clean build --info
```

## Built With

* Selenium tool
* Groovy language
* Cucumber BDD
* Gradle build system

## Scope

The test suite tests main happy-path functionality described in requirements by randomly selecting ads and adding them to Memo section.

Edge case tests are omitted since this project is considered a presentation of technical knowledge, not a full solution:
* verification of Memo section state remaining the same after re-launch of browser;
* functionality verification on browser mobile version;
* cross-browser and cross-platform functionality verification;
* etc.

  