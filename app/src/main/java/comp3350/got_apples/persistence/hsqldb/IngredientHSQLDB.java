package comp3350.got_apples.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import comp3350.got_apples.objects.Ingredient;
import comp3350.got_apples.objects.IngredientList;
import comp3350.got_apples.persistence.IngredientInterface;

public class IngredientHSQLDB implements IngredientInterface {

    private final String dbPath;
    public IngredientList ingredientDatabase;

    public IngredientHSQLDB(String dbPath) {
        this.dbPath = dbPath;
        this.ingredientDatabase = loadIngredientDatabase();
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }


    @Override
    public String[] getSuggestionArray() {
        return this.ingredientDatabase.getStringArray();
    }


    private IngredientList loadIngredientDatabase() {
        IngredientList thisDatabase = new IngredientList();
        String QUERY = "SELECT * FROM RECIPEDATABASE";
        try (final Connection connection = connect()) {
            final Statement showAll = connection.createStatement();
            ResultSet resultSet = showAll.executeQuery(QUERY);
            while (resultSet.next()) {
                String rawIngredients = resultSet.getString("listOfIngredients");
                IngredientList ingredientList = new IngredientList(rawIngredients);
                for (Ingredient ingredient : ingredientList.getIngredientArrayList()) {
                    if (!thisDatabase.contains(ingredient)) {
                        thisDatabase.addIngredient(ingredient);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thisDatabase;
    }
}