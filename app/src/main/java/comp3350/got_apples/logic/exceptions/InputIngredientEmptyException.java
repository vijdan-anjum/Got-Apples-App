package comp3350.got_apples.logic.exceptions;

public class InputIngredientEmptyException extends InvalidInputException {

    public InputIngredientEmptyException() {
        super("No ingredient provided");
    }
}
