package comp3350.got_apples.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

import comp3350.got_apples.R;
import comp3350.got_apples.objects.CurrentUser;

public class CuisineActivity extends AppCompatActivity {

    private GridLayout grid;
    ArrayList<TextView> cuisineTextsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide();
        //so this method just makes sure that everything is stretched to full screen for the device being used
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cuisine);

        cuisineTextsList.add(findViewById(R.id.one));
        cuisineTextsList.add(findViewById(R.id.two));
        cuisineTextsList.add(findViewById(R.id.three));
        cuisineTextsList.add(findViewById(R.id.four));
        cuisineTextsList.add(findViewById(R.id.five));
        cuisineTextsList.add(findViewById(R.id.six));
        cuisineTextsList.add(findViewById(R.id.seven));
        cuisineTextsList.add(findViewById(R.id.eight));

        grid = findViewById(R.id.main_grid);
        setClickEvent(grid);
    }

    private void setClickEvent(GridLayout items) {

        CurrentUser currentUser = (CurrentUser) getIntent().getSerializableExtra(CurrentUser.USER_TAG);


        for (int i = 0; i < items.getChildCount(); i++) {
            CardView cv = (CardView) items.getChildAt(i);
            int cardPosition = i;


            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(CuisineActivity.this, RecipeActivity.class);

                    String cuisineSelected = cuisineTextsList.get(cardPosition).getText().toString();
                    currentUser.setCuisine(cuisineSelected);

                    intent.putExtra(CurrentUser.USER_TAG,currentUser);
                    startActivity(intent);
                }
            });
        }
    }

}
