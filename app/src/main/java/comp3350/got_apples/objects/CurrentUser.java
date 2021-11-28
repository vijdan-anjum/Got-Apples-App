package comp3350.got_apples.objects;

import java.io.Serializable;
import java.util.regex.Pattern;
import comp3350.got_apples.logic.exceptions.InvalidInputException;
import comp3350.got_apples.logic.exceptions.InvalidCheckException;

public class CurrentUser implements Serializable {

    public static final String USER_TAG = "CURR USER";

    private String userName;
    private String password;
    private String cuisine;
    private IngredientList ingredientList;
    //by changing the range you can restrict the input, currently password has to be minimum 4 and max 15.
    private static final String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,15}$";
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    public CurrentUser() {}

    public CurrentUser(String userName, String password) throws InvalidInputException {
        if(!checkInvalidUserName(userName) && !checkInvalidPassword(password) ) {
            this.userName = userName;
            this.password = password;
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public IngredientList getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(IngredientList ingredientList) {
        this.ingredientList = ingredientList;
    }


    //make changes here
    public boolean isInvalidUserName(String thisUserName){
        boolean invalid = false;
        if(thisUserName.length() < 8){
            invalid = true;
        }
        return invalid;
    }

    public boolean checkInvalidUserName(String thisUserName) throws InvalidCheckException {
        boolean invalid = false;
        if(isInvalidUserName(thisUserName)){
            invalid = true;
            throw new InvalidCheckException();
        }
        return invalid;
    }

    //make changes here
    public boolean isInvalidPassword(String thisPassword){
        boolean invalid = false;
        if(thisPassword==null)
        {
            invalid = true;
        }
        if(ispasswordMatcher(thisPassword)==false)
        {
            invalid = true;
        }
        return invalid;
    }

    private boolean ispasswordMatcher(String input)
    {
        return PASSWORD_PATTERN.matcher(input).matches();
    }
    public boolean checkInvalidPassword(String thisPassword) throws InvalidCheckException {
        boolean invalid = false;
        if(isInvalidPassword(thisPassword)){
            invalid = true;
            throw new InvalidCheckException();
        }
        return invalid;
    }


}
