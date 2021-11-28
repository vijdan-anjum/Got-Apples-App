package comp3350.got_apples.persistence.stubs;

import java.util.ArrayList;

import comp3350.got_apples.logic.exceptions.InvalidInputException;
import comp3350.got_apples.objects.Ingredient;
import comp3350.got_apples.persistence.IngredientInterface;

public class IngredientsStub implements IngredientInterface {

    private ArrayList<Ingredient> ingredientDatabase;

    public IngredientsStub() {
        createIngredientDatabase();
    }

    @Override
    public String[] getSuggestionArray() {

        String[] suggestions = new String[ingredientDatabase.size()];
        for(int i=0; i<ingredientDatabase.size(); i++){
            suggestions[i] = ingredientDatabase.get(i).getIngredient();
        }
        return suggestions;
    }

    private void createIngredientDatabase() {

        try {
            ingredientDatabase.add(new Ingredient("eggs"));
            ingredientDatabase.add(new Ingredient("milk"));
            ingredientDatabase.add(new Ingredient("salt"));
            ingredientDatabase.add(new Ingredient("oil"));
            ingredientDatabase.add(new Ingredient("mushrooms"));
            ingredientDatabase.add(new Ingredient("olives"));
            ingredientDatabase.add(new Ingredient("tomatoes"));
            ingredientDatabase.add(new Ingredient("bread"));
            ingredientDatabase.add(new Ingredient("sausage"));
            ingredientDatabase.add(new Ingredient("pepper"));
            ingredientDatabase.add(new Ingredient("shredded cheese"));
        }catch (InvalidInputException ie){
            ie.getMessage();
        }
    }
}
