# Iteration 3 Worksheet


## Technical debt that has been cleaned up
*Q: Show links to a commit where you paid off technical debt. Write 2-5*
*sentences that explain what debt was paid, and what its classification is.* 

We cleaned up debt for the setup for the HSQL database. We almost refactored everything related to the database.
We were using the CSV file to import the data in iteration2. To fix all the database issues we paid 5 days in terms
of time since we were making the interface for the database that can loosely be coupled. We cleaned up the issue of
creation the object and we are doing all checks in object class if all checks passed then create an object.

## Technical debt that we left
*Q: What one item would you like to fix, and can't? Anything you write will not*
*be marked negatively. Classify this debt.*

We have done all the refactorization for the real database but for the stub databases, it is still not loosely couple.
We can not switch between easily to real database and stub database and it is hard to implement the stub database since
we are not making use of the interface for the database.

## Re-prioritized Feature
*Q: When did you change the priority of a Feature or User Story? Why was it*
*re-prioritized? Provide a link to the Feature or User Story. This can be from*
*any iteration.*

The one Feature that we were always not completely certain of was "User Account Management".
This was mainly because it was not the focal point of our application, according to our mutual understanding
and decision. But as we proceeded, our viewpoint regarding whether we need this feature or not changed.
After Iteration 0, we decided not to work on it in Iteration 1, and after Iteration 1 we thought we might work
on it during Iteration 2. However, during our discussions for Iteration 2, we decided not to and moved it to Iteration 3.
But at the end of Iteration 2, we were almost certain that we will work on this feature because it will
give our application a more organized look and will make easy it easy to handle some technical tasks as well.

user story - https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/issues/57
feature - https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/issues/5


## Acceptance test/end-to-end
*Q: Write a discussion about an end-to-end test that you wrote. What did you test,*
*how did you set up the test so it was not flaky? Provide a link to that test.*

To run the end-to-end test we have to add the dependency in the Gradle file for the espresso test. We are starting
from the login page if the user installed the fresh app then we will test for the registration page and if the user
does not have a username and password then we are always testing for the registration page. none of the tests are flaky, we
tried our best to not make the test flaky. we are checking for every warning and error that could be done by the user. after
successfully login the application, we are testing for the ingredient screen where we are entering the four to five ingredients
and trying to delete one of them, testing for duplicate ingredients, checking for the ingredient should not contains a number,
checking for can not put the empty ingredients. we are checking for the next button on the ingredient selection screen that users
can not go to the next screen unless they have entered at least one ingredient. after that we are testing for the cuisine
selection screen where we will test for the appropriate recipe is showing to appropriate cuisine. we tested for that if we do
not have a recipe that exists of entered ingredients as well. after selecting a cuisine, we are testing for the recipe selection
where we are testing if the recipe list is scrollable, testing for each recipe, and comparing the right content of the recipe to
our database. finally, we are testing for the sharing the recipe feature.

## Acceptance test, untestable
*Q: What challenges did you face when creating acceptance tests? What was difficult*
*or impossible to test?*

It was challenging to understanding the espresso because it was a learning curve. Importing the dependency was a little challenging
as well. It was fun to write the big tests. We faced some problems to check the scrollable view and connect with the database. Overall,
it was fun to do system tests.

## Velocity/teamwork
*Q: Did your estimates get better or worse through the course? Show some*
*evidence of the estimates/actuals from tasks.*

The estimates were definitely improved over the period of time. This is evident from the gradual increase in the number
of user stories and developer tasks we were able to accomplish during the course of the three iterations with almost the estimated
time frame. For instance, the estimated time for the User Management feature was 7 days and we were able to complete the actual tasks for it
within the estimated time.