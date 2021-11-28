package comp3350.got_apples.application;

import comp3350.got_apples.persistence.IngredientInterface;
import comp3350.got_apples.persistence.RecipeInterface;
import comp3350.got_apples.persistence.RegisterInterface;
import comp3350.got_apples.persistence.hsqldb.IngredientHSQLDB;
import comp3350.got_apples.persistence.hsqldb.RecipeHSQLDB;
import comp3350.got_apples.persistence.hsqldb.RegisterHSQLDB;
import comp3350.got_apples.persistence.stubs.IngredientsStub;
import comp3350.got_apples.persistence.stubs.RecipeStub;

public class Services {

    private static RecipeInterface recipeInterface = null;
    private static IngredientInterface ingredientInterface = null;
    private static  RegisterInterface registerInterface = null;

    public static synchronized RecipeInterface getRecipeInterface(boolean ISHSQLDB) {
        if (recipeInterface == null) {
            if (ISHSQLDB) {
                recipeInterface = new RecipeHSQLDB(Main.getDBPathName());
            } else {
                recipeInterface = new RecipeStub();
            }
        }
        return recipeInterface;
    }
    public static synchronized IngredientInterface getIngredientInterface(boolean ISHSQLDB) {
        if (recipeInterface == null) {
            if (ISHSQLDB) {
                ingredientInterface = new IngredientHSQLDB(Main.getDBPathName());
            } else {
                ingredientInterface = new IngredientsStub();
            }
        }
        return ingredientInterface;
    }

    public static synchronized RegisterInterface getRegisterInterface(boolean ISHSQLDB) {
        if (registerInterface == null) {
            if (ISHSQLDB) {
                registerInterface = new RegisterHSQLDB(Main.getDBPathName());
            }
        }
        return registerInterface;
    }

    public static synchronized void clean() {
        recipeInterface = null;
        ingredientInterface = null;
        registerInterface = null;
    }

}
