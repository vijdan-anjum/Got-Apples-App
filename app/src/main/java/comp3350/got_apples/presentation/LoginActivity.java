package comp3350.got_apples.presentation;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import comp3350.got_apples.R;
import comp3350.got_apples.logic.RegisterHandler;
import comp3350.got_apples.logic.exceptions.InvalidInputException;
import comp3350.got_apples.objects.CurrentUser;

public class LoginActivity extends AppCompatActivity {

    //variable will point to all of our widgets
    private Button loginLogInButton;
    private Button loginRegisterButton;
    private EditText userNameInput;
    private EditText passwordInput;
    private RegisterHandler registerHandler;

    //so we just made an empty user
    private CurrentUser currentUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        //find view by id returns the whole xml  widgets view
        loginLogInButton = findViewById(R.id.login_Login_Button);
        loginRegisterButton = findViewById(R.id.login_register_Button);
        userNameInput = findViewById(R.id.login_Email_Input);
        passwordInput = findViewById(R.id.login_Password_Input);
        registerHandler = new RegisterHandler(true);

        //here we are constructing that new empty user on app start
        currentUser = new CurrentUser();

        loginLogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = userNameInput.getText().toString();
                String password = passwordInput.getText().toString();
                try {
                    //first check whether username and password is invalid or not
                    CurrentUser currentUser1 = new CurrentUser(userName, password);
                    //now check whether user is in DB or not
                    if(registerHandler.isExistingUser(currentUser1)){
                        //we move forward
                        Intent intent = new Intent(LoginActivity.this,IngredientsActivity.class);
                        intent.putExtra(CurrentUser.USER_TAG, currentUser);
                        startActivity(intent);
                        finish();
                    }else{
                        userNameInput.setError("Your account details do not exist!\nPlease sign up to make a new account");
                    }
                }catch (InvalidInputException ie){
                    userNameInput.setError(ie.getMessage());
                }
            }
        });

        //make changes here
        loginRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });

    }
}