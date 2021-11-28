package comp3350.got_apples.objects;

import java.io.Serializable;
import java.util.ArrayList;

import comp3350.got_apples.logic.exceptions.InputIngredientDuplicateException;
import comp3350.got_apples.logic.exceptions.InvalidInputException;

public class IngredientList implements Serializable {

    private ArrayList<Ingredient> ingredientArrayList;

    public IngredientList() {
        this.ingredientArrayList = new ArrayList<>();
    }

    public IngredientList(String rawIngredients) {
        this.ingredientArrayList = buildList(rawIngredients);
    }

    public ArrayList<Ingredient> getIngredientArrayList() {
        return ingredientArrayList;
    }

    public void setIngredientArrayList(ArrayList<Ingredient> ingredientArrayList) {
        this.ingredientArrayList = ingredientArrayList;
    }

    private ArrayList<Ingredient> buildList(String stringOfIngredients) {
        return buildList(stringOfIngredients, "\\|");
    }

    private ArrayList<Ingredient> buildList(String stringOfIngredients, String splitter) {
        Ingredient newIngredient;
        ArrayList<Ingredient> listOfIngredients = new ArrayList<>();
        String[] ingredientsArray = stringOfIngredients.split(splitter);
        for (String stringIngredient : ingredientsArray) {
            try {
                newIngredient = new Ingredient(stringIngredient);
                listOfIngredients.add(newIngredient);
            } catch (InvalidInputException ie) {
            }
        }
        return listOfIngredients;
    }

    public boolean contains(Ingredient ingredient) {
        boolean contains = false;
        if (this.ingredientArrayList.size() > 0) {
            for (Ingredient thisIngredient : this.ingredientArrayList) {

                if (thisIngredient.isEqual(ingredient)) {
                    contains = true;
                }
            }
        }
        return contains;
    }


    public boolean containsCheck(Ingredient ingredient) throws InputIngredientDuplicateException {
        boolean contains = false;
        if (contains(ingredient)) {
            contains = true;
            throw new InputIngredientDuplicateException();
        }
        return contains;
    }

    public void addIngredient(String stringIngredient) {
        try {
            Ingredient ingredient = new Ingredient(stringIngredient);
            this.ingredientArrayList.add(ingredient);
        } catch (InvalidInputException ie) {
            ie.getMessage();
        }
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredientArrayList.add(ingredient);
    }

    public String[] getStringArray() {
        String[] array = new String[this.ingredientArrayList.size()];
        for (int i = 0; i < this.ingredientArrayList.size(); i++) {
            array[i] = this.ingredientArrayList.get(i).getIngredient();
        }
        return array;
    }


    public void removeIngredient(int index) {
        this.ingredientArrayList.remove(index);
    }

    public String toString() {

        String string = "[";
        Ingredient ingredient;
        int n = this.ingredientArrayList.size();
        for (int i = 0; i < n - 1; i++) {
            ingredient = this.ingredientArrayList.get(i);
            string += ingredient.getIngredient() + ", ";
        }
        ingredient = this.ingredientArrayList.get(n - 1);
        string += ingredient.getIngredient() + "]";
        return string;
    }

    public int getSize() {
        return this.ingredientArrayList.size();
    }

    public Ingredient getIngredient(int index) {
        return this.ingredientArrayList.get(index);
    }
}
