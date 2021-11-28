package comp3350.got_apples.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import comp3350.got_apples.R;
import comp3350.got_apples.application.utilities.DBHelper;


public class HomeActivity extends AppCompatActivity {

    private Animation animation_top, animation_bottom; //variables will hold the animations
    private TextView homeLogo, homeText;              //variables will hold the display texts


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBHelper.copyDatabaseToDevice(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide();
        //so this method just makes sure that everything is stretched to full screen for the device being used
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);
        //this is the animation that brings the above layout
        animation_top = AnimationUtils.loadAnimation(this, R.anim.animation_header);
        animation_bottom = AnimationUtils.loadAnimation(this, R.anim.animation_footer);
        //naming the textView widgets here for logo etc
        homeLogo = findViewById(R.id.home_Logo);
        homeText = findViewById(R.id.home_Text);
        //entry animation
        homeLogo.setAnimation(animation_top);
        homeText.setAnimation(animation_bottom);

        //Transition from HomePage to Login page using a delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                finish();//this activity is now finished so you cannot go back
            }
        }, 3000); //in milliseconds
    }
}