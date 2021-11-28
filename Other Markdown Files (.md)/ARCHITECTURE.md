# **ARCHITECTURE.md**

We had a few changes involving class name changes, project architecture towards
Iteration 2. We changed the documentation for each layer below:

**Iteration 2 Diagram:**
![](images/Iteration2.png)



**Iteration 1 Diagram:**
![](images/Iteration1.png)

-------------------------------------------------------------------------------

## [Domain-specific Objects](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/objects)


[Ingredient](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/objects/Ingredient.java)
- An Object for an ingredient.

[Recipe](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/objects/Recipe.java) 
- An Object for a full recipe.

[CurrentUser](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/objects/CurrentUser.java) 
- An Object for a user.

-------------------------------------------------------------------------------

## [Logic Layer](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/logic)


[IngredientHandler](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/logic/IngredientHandler.java)
- A logical implementation for Ingredients.

[LoginHandler](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/logic/LoginHandler.java)
- A logical implementation for User Login.

[RecipeHandler](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/logic/RecipeHandler.java) 
- A logical implementation for Recipes.

-------------------------------------------------------------------------------

## [Exceptions Layer](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/logic/exceptions)


[IngredientsListOutOfBoundsException](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/logic/exceptions/IngredientsListOutOfBoundsException.java)
- Exception class for list of Ingredients out of bounds.

[InputIngredientDuplicateException](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/logic/exceptions/InputIngredientDuplicateException.java)
- Exception class for user input Ingredient duplicate.

[InputIngredientEmptyException](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/logic/exceptions/InputIngredientEmptyException.java)
- Exception class for empty user input Ingredient.

[InputIngredientFormatException](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/logic/exceptions/InputIngredientFormatException.java)
- Exception class for user input Ingredient wrong format.

[InvalidInputException](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/logic/exceptions/InvalidInputException.java)
- Exception class for invalid user input.

-------------------------------------------------------------------------------

## [Persistence Layer](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/tree/master/app/src/main/java/comp3350/got_apples/persistence)


[IngredientSuggestions](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/persistence/IngredientSuggestions.java)
- Holds the database for Ingredients input suggestions.

-------------------------------------------------------------------------------

## [Stubs Layer](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/tree/master/app/src/main/java/comp3350/got_apples/persistence/stubs)

[IngredientPersistenceStub](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/persistence/stubs/IngredientPersistenceStub.java)
- Holds a fake database (stub) for Ingredients.

[RecipePersistentStub](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/persistence/stubs/RecipePersistenceStub.java)
- Holds a fake database (stub) for Recipes.

-------------------------------------------------------------------------------

## [hsqldb](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/tree/master/app/src/main/java/comp3350/got_apples/persistence/hsqldb)

[RegisterPersistence](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/persistence/hsqldb/RegisterPersistence.java)
- Holds user registration database (currently implemented in SQLite).

[RecipePersistenceHSQLDB](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/persistence/hsqldb/RecipePersistenceHSQLDB.java)
- Holds recipe database implemented in HSQLDB.

-------------------------------------------------------------------------------

## [Presentation Layer](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/presentation)


[HomeActivity](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/presentation/RecipeAdapter.java)
- Initiates the GUI of the application.


[](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/presentation/LoginActivity.java)
- Displays the login screen of the application.


[IngredientsActivity](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/presentation/IngredientsActivity.java)
- Displays the Ingredients added/deleted.


[CuisineActivity](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/com/example/got_apple/presentation/CuisineActivity.java)
- Shows the list of cuisines that can be selected from.


[RecipeActivity](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/presentation/RecipeActivity.java)
- Displays Recipe Activity of a user.

[RecipeAdapterActivity](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/presentation/RecipeAdapterActivity.java)
- Displays adapter of a recipe. 

[RecipeDescriptionActivity](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/presentation/RecipeDescriptionActivity.java)
- Displays messages on screen for a recipe


[RegisterActivity](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/presentation/RegisterActivity].javay)
- Displays a profile of a user, achievements, etc.


[SelectRecipeActivity](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/blob/master/app/src/main/java/comp3350/got_apples/presentation/SelectRecipeActivity.java)
(Currently not implemented)
- Displays the GUI for selecting a recipe and ability to see the recipe.

-------------------------------------------------------------------------------

### [**Link to the full master graph here**](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-9-project/-/network/master)