package comp3350.got_apples.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import java.util.ArrayList;
import comp3350.got_apples.R;
import comp3350.got_apples.logic.RecipeHandler;
import comp3350.got_apples.objects.CurrentUser;
import comp3350.got_apples.objects.Recipe;

public class RecipeActivity extends AppCompatActivity {

    RecyclerView listHolder;
    RecipeHandler recipeHandler = new RecipeHandler(true);
    CurrentUser currentUser;
    int[] imgDefault = {R.drawable.chinese_cuisine, R.drawable.indian_cuisine, R.drawable.italian_cuisine, R.drawable.japanese_cuisine, R.drawable.japanese_cuisine};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_recipe);

        currentUser = (CurrentUser) getIntent().getSerializableExtra(CurrentUser.USER_TAG);
        ArrayList<ArrayList<Recipe>> matchedRecipes = recipeHandler.getMatchedRecipes(currentUser);
        String[] matchedRecipeNames = recipeHandler.getRecipeNames(matchedRecipes);
        int[] img = recipeHandler.getImageArray(matchedRecipeNames.length);


        listHolder = (RecyclerView) findViewById(R.id.recycler_list_holder);
        RecipeAdapter recipeAdapter = new RecipeAdapter(RecipeActivity.this, matchedRecipeNames, img, currentUser, matchedRecipes);
        if(recipeAdapter.getItemCount()==0)
        {
            new AlertDialog.Builder(RecipeActivity.this)
                    .setTitle("Please add some more ingredients.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .show();
        }
        if(recipeAdapter.getItemCount()!=0)
        {
            listHolder.setAdapter(recipeAdapter);
        }

        listHolder.setLayoutManager(new LinearLayoutManager(RecipeActivity.this));

    }

}