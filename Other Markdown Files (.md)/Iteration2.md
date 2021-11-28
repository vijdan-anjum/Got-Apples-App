# Iteration 2 Worksheet

## Paying off technical debt
*Q: Show two instances of your group paying off technical debt. For these two*
*instances, explain how you are paying off the technical debt, show commits,*
*links to lines in your commit where you paid off technical debt, and classify*
*the debt and justify why you chose that classification with 1-3 sentences.*

In Iteration 1, we were hasty with our coding (which led to some technical 
debt and code smells). We also lost quite a bit of time due to technical 
difficulties within group members' Android Studios. So for this iteration, we 
decided to fix those issues first and code more efficiently and ended up paying
off some technical debt. An example would be that we quickly created an
[Ingredient Persistence](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/Iteration-1/app/src/main/java/com/example/got_apple/persistence/IngredientsPersistence.java)
with the use of an ArrayList, which is quick to do but is not ideal in terms of
functionality and privacy. Since then we have changed it to an [IngredientSuggestions](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/Iteration-2/app/src/main/java/comp3350/got_apples/persistence/IngredientSuggestions.java)
list instead, since these ingredients will be accessed later when a user is
inputting the ingredients that they have/want to add into their list of ingredients.
It now has become a class with a singular function: providing suggestions to the users
when inputting their ingredients. Hence we were able to repay the Reckless technical debt 
as well. The second technical debt we were able to repay was the 
[IngredientHandler class](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/Iteration-1/app/src/main/java/com/example/got_apple/logic/IngredientHandler.java)
which was considered a code smell and we Inadvertently created technical debt
by not noticing that we could have refactored it and made it better because it had
duplicate code. So, we focused on refactoring the code and since then, our
[new IngredientHandler class](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/logic/IngredientHandler.java)
has now been completely refactored, catching certain Ingredient Exceptions, and
does not have duplicate code anymore. We were able to repay this Inadvertent technical debt
as well.

## SOLID
*Q: Find a SOLID violation in the project of group with the same group number*
*in the next class over - (n%3)+1 (A03 does A01)*

We are trying to look for a SOLID violation for Group 9's Project in A03: 
[Course Scheduler.](https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9)
We were not able to observe major SOLID violations, but there are a few minor 
violations that we have noticed (Link to the issues
[here](https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/47)).


## Retrospective
*Q: Describe how the retrospective has changed the way you are doing your*
*project. Is there evidence of the change in estimating/committing/peer*
*review/timelines/testing?*

We reflected on Iteration 1 and the feedback we received once the marks came out.
Even before the marks came out, we talked about the goods and the bads that came
out of the project. Particularly, we barely used gitlab issues to organize 
ourselves as to who is doing what developer task/user story. Along with the
technical difficulties that two of our members faced regarding Android Studios,
we were not operating as a group and instead were uncooperated and unorganized 
in finishing the iteration. So, for this iteration, we decided to focus on 
utilizing GitLab to its potential, as well as to completely organize ourselves 
and determine who is doing what so there will be no confusion. There are now 
asignees to each [developer task](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/issues?scope=all&utf8=%E2%9C%93&state=opened&label_name[]=Developer%20Tasks)
and more specifically, for our four members: developer Rutu handles GUI,
developers Mohammed and Nitya handles Logic and Persistence, and developer Amiel
handles Testing and GitLab documentations.


## Design patterns
*Show links to your project where you use a well-known design pattern.*
*Which pattern is it? Provide links to the design pattern that you used.*

There are a few design patterns that we used: Singleton, Facade, and Chain-Of-Responsibility
We used Singleton in the [CurrentUser class](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/objects/CurrentUser.java#L8) 
as the public static final Tag USER_TAG, which is then used as a global access
point. Next, we used Facade in the [RecipeHSQLDB class](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/persistence/hsqldb/RecipePersistenceHSQLDB.java)
, in the [getRecipeDatabase() method](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/persistence/hsqldb/RecipePersistenceHSQLDB.java#L28)
, which provides a simplified interface to the HSQLDB connection by only having
2 lines which connects us to the whole database. Lastly, we have a Chain-Of-Responsibility 
design pattern, which is evident in our whole [Presentation package](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/tree/master/app/src/main/java/comp3350/got_apples/presentation)
As also seen in our [Iteration 2 diagram](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/Other%20Markdown%20Files%20(.md)/ARCHITECTURE.md),
we can see that the HomeActivity class is passed to LoginActivity, which is then
passed to IngredientsActivity, then CuisineActivity, then RecipeActivity, and then
RecipeDescriptionActivity; which means that our [Logic classes](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/tree/Iteration-2/app/src/main/java/comp3350/got_apples/logic)
also proactively interacts with the chained presentation classes, hence it is
evident we have used this design pattern as well.

## Iteration 1 Feedback Fixes
*Q: Provide a link to an issue opened by the grader.Explain what the issue was,*
*and why it was flagged. Explain what you did to refactor or fix your code to*
*address the issue. Provide links to the commits where you fixed the issue.*


The feedback for Iteration 1 was posted in UM Learn, so here is
a screenshot of the feedback:
![](images/COMP3350-Winter2021-A02-Iteration1CriterionFeedback.png)

Here are the commit links to their fixes:

### Functionality
This was the issue addressed by the TA: Toast messages are not disappearing
for a long amount of time when transitioning through the application's features.
It was flagged since it is considered an annoying bug for any users.
(Link to the issue created by the TA
[here)](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/issues/56).
We were able to fix that, and the following fix to that issue was committed
[here.](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/commit/7c86c10ae1137eca159dd602422a99445f70a943)

### Code Implementation
These are the other fixes, with their corresponding commit fixes here:

[Refactored the package to remove the "com.example" portion](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/commit/3ac06618dcdcc788ddfab230cd3c2cfa2e93f151)

Ingredient.java:
    Ingredient class should be called "IngredientList.java".
    - This was evidently true for Iteration 1, alongside its fake database.
    However, since we are now implementing a real database, we decided to stick 
    with the same java class name since it now actually represents one ingredient 
    which will then be added to the DB and/or the [IngredientsSuggestions](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/Iteration-2/app/src/main/java/comp3350/got_apples/persistence/IngredientSuggestions.java)

IngredientPersistence is now refactored and used as an IngredientSuggestions
Commit links to that implementation [here](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/Iteration-2/app/src/main/java/comp3350/got_apples/persistence/IngredientSuggestions.java)

[Cleaned up the IngredientHandler Class](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/commit/9197a065a79877c0d66da1f5704ef50320cb7eb3)

LoginHandler will( OR WILL NOT) be deleted by our group since we decided not to
focus on user account management for this iteration and it barely has any code in it.
    
### Unit Tests

[AllTests.java](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/Amiel-Branch/app/src/test/java/comp3350/got_apples/AllUnitTests.java)
is now working: 
Logic layer is now thoroughly tested, now >80% of code coverage. Link to the 
Logic layer tests [here.](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/tree/master/app/src/test/java/comp3350/got_apples/logic)
We have also now created all unit tests for each [Object classes](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/tree/master/app/src/main/java/comp3350/got_apples/objects)
and [Logic classes](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/tree/master/app/src/main/java/comp3350/got_apples/logic)