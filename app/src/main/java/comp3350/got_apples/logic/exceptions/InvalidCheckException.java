package comp3350.got_apples.logic.exceptions;

public class InvalidCheckException extends InvalidInputException{
    public InvalidCheckException(){super(("Invalid user name or password provided"));}
}
