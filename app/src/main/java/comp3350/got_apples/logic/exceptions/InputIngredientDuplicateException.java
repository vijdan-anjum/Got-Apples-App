package comp3350.got_apples.logic.exceptions;

public class InputIngredientDuplicateException extends InvalidInputException{
    public InputIngredientDuplicateException(){super("You already have this Ingredient!");}
}
