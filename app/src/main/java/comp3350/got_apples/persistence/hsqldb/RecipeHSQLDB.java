package comp3350.got_apples.persistence.hsqldb;

import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import comp3350.got_apples.logic.exceptions.InvalidInputException;
import comp3350.got_apples.objects.Ingredient;
import comp3350.got_apples.objects.IngredientList;
import comp3350.got_apples.objects.Recipe;
import comp3350.got_apples.persistence.RecipeInterface;

public class RecipeHSQLDB implements RecipeInterface{

    private final String dbPath;
    public final ArrayList<Recipe> recipeDatabase;

    public RecipeHSQLDB(String dbPath) {
        this.dbPath = dbPath;
        this.recipeDatabase = loadRecipeDatabase();
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    @Override
    public ArrayList<Recipe> getRecipeList() {
        return recipeDatabase;
    }

    private ArrayList<Recipe> loadRecipeDatabase() {

        ArrayList<Recipe> thisRecipeDatabase = new ArrayList<>();

        String QUERY = "SELECT * FROM RECIPEDATABASE";

        try(Connection connection = connect()){
            final Statement showAll = connection.createStatement();
            ResultSet resultSet = showAll.executeQuery(QUERY);

            while (resultSet.next()) {

                Recipe recipe = fromResultSet(resultSet);
                thisRecipeDatabase.add(recipe);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thisRecipeDatabase;
    }

    public Recipe getRecipeFromName(String recipeName){

        String QUERY = "select * from RecipeTable where RECIPEDATABASE = "+recipeName;
        Recipe recipe = new Recipe();
        return recipe;
    }

    private Recipe fromResultSet(ResultSet resultSet) throws SQLException{

        int rID = resultSet.getInt("rID");
        String recipeName = resultSet.getString("recipeName");
        String cuisineType = resultSet.getString("cuisineType");
        String listOfIngredients = resultSet.getString("listOfIngredients");
        String instructions = resultSet.getString("instructions");

        IngredientList ingredientList = new IngredientList(listOfIngredients);

        return new Recipe(rID,recipeName,cuisineType,ingredientList,instructions);
    }

    private ArrayList<Ingredient> ingredientsToList(String stringOfIngredients) {
        return ingredientsToList(stringOfIngredients,"\\|");
    }
    private ArrayList<Ingredient> ingredientsToList(String stringOfIngredients, String splitter) {

        Ingredient newIngredient;
        ArrayList<Ingredient> listOfIngredients = new ArrayList<>();

        String[] ingredientsArray = stringOfIngredients.split(splitter);

        for (int i = 0; i < ingredientsArray.length; i++) {
            try {
                newIngredient = new Ingredient(ingredientsArray[i]);
                listOfIngredients.add(newIngredient);
            }catch (InvalidInputException ie){
                Log.d("sout","also we here "+ie.getMessage());
            }
        }

        return listOfIngredients;
    }
}
