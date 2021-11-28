package comp3350.got_apples.presentation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import comp3350.got_apples.R;
import comp3350.got_apples.logic.RecipeHandler;
import comp3350.got_apples.objects.CurrentUser;
import comp3350.got_apples.objects.Recipe;

public class RecipeDescriptionActivity extends AppCompatActivity {

    private TextView title, cuisineName, ingredientList, description;
    private String newString= " ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_recipe_description);

        title = findViewById(R.id.description_title);
        cuisineName = findViewById(R.id.description_cuisine);
        ingredientList = findViewById(R.id.description_ingredientList);
        description = findViewById(R.id.description);

        Recipe recipeDescription = (Recipe) getIntent().getSerializableExtra(CurrentUser.USER_TAG);

        title.setText(recipeDescription.getRecipeName());
        cuisineName.setText(recipeDescription.getCuisineType());
        ingredientList.setText(recipeDescription.getStringIngredientsList());
        description.setText(recipeDescription.getInstructions());
        newString = "Recipe Name: " + recipeDescription.getRecipeName() + "\n"
                + "Cuisine Type: " +recipeDescription.getCuisineType()
                + "\nList of Ingredients: \n" + recipeDescription.getStringIngredientsList()
                + "\nProcedure: \n"+ recipeDescription.getInstructions();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.share_reciepe)
        {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("application/comp3350.got_apples");
            intent.putExtra(Intent.EXTRA_TEXT,newString);
            intent.putExtra(Intent.EXTRA_SUBJECT,"Subject");
            startActivity(Intent.createChooser(intent,"ShareVia"));
        }
        return true;
    }

}