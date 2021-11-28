package comp3350.got_apples.presentation;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import comp3350.got_apples.R;
import comp3350.got_apples.application.Services;
import comp3350.got_apples.logic.exceptions.InvalidInputException;
import comp3350.got_apples.objects.CurrentUser;
import comp3350.got_apples.objects.Ingredient;
import comp3350.got_apples.objects.IngredientList;
import comp3350.got_apples.persistence.IngredientInterface;

public class IngredientsActivity extends AppCompatActivity {


    private CurrentUser currentUser;
    private ArrayAdapter<String> ingredientsDisplay; //adapter will help display ingredients
    private final IngredientList ingredientsInFridge = new IngredientList();
    private final IngredientInterface ingredientInterface = Services.getIngredientInterface(true);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //all of the below 4 lines should just help us set the layout nicely in the app
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ingredients);

        //here we are connecting our java variables to the widgets on the ingredients_layout
        AutoCompleteTextView ingredientsInputText = findViewById(R.id.ingredients_Input);
        ListView ingredientsListView = findViewById(R.id.ingredients_List);
        Button ingredientsEnterButton = findViewById(R.id.ingredients_Enter_Button);
        Button ingredientsNextButton = findViewById(R.id.next_button);

        //setting suggestions for drop down
        String[] suggestionArray = ingredientInterface.getSuggestionArray();
        ArrayAdapter<String> ingredientSuggestions = new ArrayAdapter<String>(IngredientsActivity.this, android.R.layout.simple_list_item_1, suggestionArray);
        ingredientsInputText.setAdapter(ingredientSuggestions);
        //getting user from prev activity
        currentUser = (CurrentUser) getIntent().getSerializableExtra(CurrentUser.USER_TAG);

        //this button will help add an ingredient if valid
        ingredientsEnterButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String stringIngredient = ingredientsInputText.getText().toString();
                        Ingredient newIngredient;
                        String errorMessage;
                        try {
                            newIngredient = new Ingredient(stringIngredient);
                            if (!ingredientsInFridge.containsCheck(newIngredient)) {
                                ingredientsInFridge.addIngredient(newIngredient);
                            }
                            ingredientsDisplay = new ArrayAdapter<String>(IngredientsActivity.this, android.R.layout.simple_list_item_1, ingredientsInFridge.getStringArray());
                            ingredientsListView.setAdapter(ingredientsDisplay);
                            ingredientsInputText.setText("");
                        } catch (InvalidInputException ie) {
                            errorMessage = ie.getMessage();
                            ingredientsInputText.setError(errorMessage);
                        }
                    }
                }
        );


        //this button will help remove an ingredient
        ingredientsListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        int ingredientsPosition = position;
                        new AlertDialog.Builder(IngredientsActivity.this)
                                .setIcon(android.R.drawable.ic_delete)
                                .setTitle("Are you sure want to delete?")
                                .setMessage("Do you want to delete this item?")
                                .setNegativeButton("No", null)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        ingredientsInFridge.removeIngredient(position);
                                        ingredientsDisplay = new ArrayAdapter<String>(IngredientsActivity.this, android.R.layout.simple_list_item_1, ingredientsInFridge.getStringArray());
                                        ingredientsListView.setAdapter(ingredientsDisplay);
                                    }
                                })
                                .show();
                    }
                }
        );


        //this button will help us transition from this activity to the next
        //we can come back to this activity
        ingredientsNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IngredientsActivity.this, CuisineActivity.class);
                if (ingredientsInFridge.getSize() > 0) {
                    currentUser.setIngredientList(ingredientsInFridge);
                    intent.putExtra(CurrentUser.USER_TAG, currentUser);
                    startActivity(intent);
                } else {
                    new AlertDialog.Builder(IngredientsActivity.this)
                            .setTitle("Add at least one ingredient please.")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            })
                            .show();
                }
            }
        });
    }
}
