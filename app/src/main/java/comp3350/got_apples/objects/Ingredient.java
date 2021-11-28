package comp3350.got_apples.objects;

import java.io.Serializable;
import comp3350.got_apples.logic.exceptions.InputIngredientEmptyException;
import comp3350.got_apples.logic.exceptions.InputIngredientFormatException;
import comp3350.got_apples.logic.exceptions.InvalidInputException;

public class Ingredient implements Serializable {

    private String ingredient;


    public Ingredient() {
    }

    public Ingredient(String ingredient) throws InvalidInputException{

        if(!isEmpty(ingredient) && !isWrongFormat(ingredient)) {
            this.ingredient = ingredient.toLowerCase().trim();
        }
    }

    public String getIngredient() {
        return ingredient;
    }

    public boolean isEmpty(String ingredient) throws InvalidInputException {
        boolean empty = false;
        if(ingredient.equals("")){
            empty = true;
            throw new InputIngredientEmptyException();
        }
        return empty;
    }

    public boolean isWrongFormat(String ingredient) throws InvalidInputException {
        boolean wrongFormat = false;
        //allows all chars and spaces in between
        if (!ingredient.matches("^[ A-Za-z]+$")) {
            wrongFormat = true;
            throw new InputIngredientFormatException();
        }
        return wrongFormat;
    }


    public boolean isEqual(Ingredient otherIngredient) {

        boolean areSame = false;

        if(this.ingredient.equals(otherIngredient.ingredient)){
            areSame = true;
        }

        return areSame;
    }
}