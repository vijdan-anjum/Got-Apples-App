# ITERATION 1 WORKSHEET

## Adding a feature
The first feature we have added was "Ingredients Management", which was regarded
as a high priority task. We have decided that this is the first feature we had 
to implement since this holds the main purpose of our application. Link to the
*Ingredients Management* feature [HERE](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/issues/1).

Adding a feature was not easy, and we were having troubles with Android Studios
in the beginning of the Iteration since it was not an easy hurdle to pass by,
especially on the technical side. However, once we figured out how to make it
work for each of our computers, we were able to start working on the project.
We also have many branches that led to the final feature. It was a step-by-step
branching that led to the final version that will be merged to the master branch.
Links below:

[Developer Nitya creating organized packages as a backbone](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/tree/UI-AndroidStudio)

[Developer Mohammed's version; raw and unorganized](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/tree/Mohammeds_branch)

[Merging Mohammed's version to developer Rutu's version; unorganized](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/tree/rutu)

[Merging the two versions above; unorganized files](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/tree/updatedVersion)
;Link to the merge [HERE](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/merge_requests/7)

[Final version for Iteration 1, organized packages](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/tree/updatedPackage)

Finally, we created tests for that feature. 
Link to the unit tests [HERE](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/tree/master/app/src/test/java/com/example/got_apple)

--------------------------------------------------------------------------------

## Exceptional code

We were not able to implement exceptional tests since we were out of time, but we
created unit tests [(links HERE](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/tree/updatedPackage/app/src/androidTest/java/com/example/got_apple)
and [HERE)](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/tree/updatedPackage/app/src/test/java/com/example/got_apple)
for each testable class.

--------------------------------------------------------------------------------

## Branching

Click [HERE](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/Other%20Markdown%20Files%20(.md)/Branching.md)
for our branching strategy.

A screenshot of the final merge of a feature to the master branch 
![HERE](images/git_log_--graph.png)

--------------------------------------------------------------------------------

## SOLID

We marked Group 10's [UM PLANNER](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-10/umplanner-comp3350-a02-group10)
Overall, they are well-organized and all of their application buttons are either
fully implemented, or implemented for the future. However there is an exception 
java file that is in main->persistence directory, but should be in testing files,
which violates S of SOLID. [HERE](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-10/umplanner-comp3350-a02-group10/-/tree/master/app/src/main/java/com/cth/myapplication/persistence/PersistenceException.java)
is the link to the java file.

(EDIT): On 02/26 @ 3:52PM - While we saw 1 SOLID violation regarding their 
project, they quickly fixed it and we were not able to add comments afterwards.
We ended up looking for other SOLID violations, but they have already fixed that.
We instead looked at their commits, and have found [this](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-10/umplanner-comp3350-a02-group10/-/commit/cc3eca425c793de01b9128ecc69b368104d993c1)
where they have numerous if-else statements (Commit: cc3eca42)
,which violated O of SOLID, but then again they already fixed it. We created an 
issue, although it was not necessary, just to remind them for the future.

Link to the issue we created [HERE](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-10/umplanner-comp3350-a02-group10/-/issues/57)

--------------------------------------------------------------------------------

## Agile Planning

For iteration 1, we were only able to implement 1 feature, which was "Ingredients
Management". We were not able to implement                                     
["Cuisine Selection"](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/issues/2)
and ["Recipe Selection"](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/issues/3),
which were also high priority tasks but had no time to implement because we did
not account for technical issues within Android Studios and in GitLab. We were 
having trouble using Android Studios because some of our computers couldn't
handle the software and the emulator kept crashing, so we had to use external 
devices which occasionally had connection troubles as well. In GitLab, there is
also a learning curve we had to face as a group, in terms of pushing and pulling
projects, and committing project changes. Therefore, we had no choice but to push
the other features to [Iteration 2](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/milestones/2), 
and changed the description to the aforementioned features and their 
corresponding user stories. We presume we will have better time management and 
less technical difficulties for the next Iteration since we have more experience
using the software and Gitlab commands.