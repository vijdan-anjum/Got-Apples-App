package comp3350.got_apples.logic.exceptions;

public class InputIngredientFormatException extends InvalidInputException{
    public InputIngredientFormatException(){super("Ingredient input contains characters other than letters");}
}
