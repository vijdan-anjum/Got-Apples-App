package comp3350.got_apples.logic;

import java.util.ArrayList;

import comp3350.got_apples.R;
import comp3350.got_apples.application.Services;
import comp3350.got_apples.objects.CurrentUser;
import comp3350.got_apples.objects.Ingredient;
import comp3350.got_apples.objects.IngredientList;
import comp3350.got_apples.objects.Recipe;
import comp3350.got_apples.persistence.RecipeInterface;

public class RecipeHandler {

    private final ArrayList<Recipe> recipeDatabase;
    private final RecipeInterface recipeInterface;

    public RecipeHandler(boolean isHSQLDB) {
        this.recipeInterface = Services.getRecipeInterface(isHSQLDB);
        this.recipeDatabase = recipeInterface.getRecipeList();
    }

    public RecipeHandler(final RecipeInterface recipeInterface){
        this.recipeInterface = recipeInterface;
        this.recipeDatabase = recipeInterface.getRecipeList();
    }


    public ArrayList<ArrayList<Recipe>> getMatchedRecipes(CurrentUser currentUser) {

        ArrayList<Recipe> matchedList = new ArrayList<>(); //100% matched
        ArrayList<Recipe> almostMatchedList = new ArrayList<>(); //2 or 1 things were left out
        ArrayList<ArrayList<Recipe>> returnList = new ArrayList<>();

        String usersCuisine = currentUser.getCuisine();

        for (int row = 0; row < recipeDatabase.size(); row++) {

            if (!usersCuisine.equals("All")) {

                if (recipeDatabase.get(row).getCuisineType().equals(usersCuisine)) {

                    matchThisRecipeIngredients(recipeDatabase.get(row), currentUser.getIngredientList(),
                            matchedList, almostMatchedList);
                }

            } else {

                matchThisRecipeIngredients(recipeDatabase.get(row), currentUser.getIngredientList(),
                        matchedList, almostMatchedList);
            }
        }

        returnList.add(matchedList);
        returnList.add(almostMatchedList);

        return returnList;
    }



    private void matchThisRecipeIngredients(Recipe recipe, IngredientList usersIngredients,
                                            ArrayList<Recipe> matchedList, ArrayList<Recipe> almostMatchedList) {

        int numMatched = 0;
        int numNotMatched = 0;
        boolean matched = false;

        IngredientList recipeIngredients = recipe.getListOfIngredients();

        for (int ri = 0; ri < recipeIngredients.getSize(); ri++) {

            Ingredient thisRecipesIngredient = recipeIngredients.getIngredient(ri);

            for (int u = 0; u < usersIngredients.getSize() && matched == false; u++) {

                Ingredient thisUsersIngredient = usersIngredients.getIngredient(u);

                //if this recipe ingredient is in users fridge
                if (thisUsersIngredient.isEqual(thisRecipesIngredient)) {
                    numMatched++;
                    matched = true;
                }
            }

            if (matched != true) {
                numNotMatched++;
            }

            //reset all
            matched = false;
        }


        if (numMatched == recipeIngredients.getSize()) {
            matchedList.add(recipe);
        } else if (numNotMatched == 1 || numNotMatched == 2) {
            almostMatchedList.add(recipe);
        } else if (numMatched == 0 || numNotMatched > 2) {
            //do nothing here
        }

    }


    public String[] getRecipeNames(ArrayList<ArrayList<Recipe>> matchedList){

        String[] titleArray = new String[matchedList.get(0).size() + matchedList.get(1).size()];

        int i=0;
        if(matchedList.get(0).size() > 0) {
            for (i = 0; i < matchedList.get(0).size(); i++) {
                titleArray[i] = matchedList.get(0).get(i).getRecipeName() + "~ 100% Match";
            }
        }
        if(matchedList.get(1).size() > 0) {
            for (int j = 0; j < matchedList.get(1).size(); j++) {
                titleArray[j + i] = matchedList.get(1).get(j).getRecipeName() + "~ Almost Match";
            }
        }

        if(titleArray.length <= 0){
            titleArray = new String[]{};
        }

        return titleArray;
    }

    public Recipe getRecipe(String recipeName, ArrayList<ArrayList<Recipe>> matchedList){

        Recipe returnRecipe = new Recipe();

        String title_ = recipeName;
        if(recipeName.contains("~")) {
            String[] titleArr = recipeName.split("~");
            title_ = titleArr[0].trim();
        }

        for(int i=0; i<matchedList.size(); i++){

            for(int j=0; j<matchedList.get(i).size(); j++){

                Recipe thisRecipe = matchedList.get(i).get(j);
                System.out.println(thisRecipe.getRecipeName());

                if(thisRecipe.getRecipeName().equals(title_)){

                    returnRecipe.setRecipeName(thisRecipe.getRecipeName());
                    returnRecipe.setCuisineType(thisRecipe.getCuisineType());
                    returnRecipe.setListOfIngredients(thisRecipe.getListOfIngredients());
                    returnRecipe.setInstructions(thisRecipe.getInstructions());
                }
            }
        }
        return returnRecipe;
    }

    public int[] getImageArray(int length){
        int[] imgDefault = {R.drawable.chinese_cuisine, R.drawable.indian_cuisine, R.drawable.italian_cuisine, R.drawable.japanese_cuisine, R.drawable.japanese_cuisine};
        int[] imgArray = new int[length];
        for(int x=0; x<imgArray.length; x++){
            imgArray[x] = imgDefault[(int)(Math.random()*imgDefault.length)];
        }
        return imgArray;
    }

}
