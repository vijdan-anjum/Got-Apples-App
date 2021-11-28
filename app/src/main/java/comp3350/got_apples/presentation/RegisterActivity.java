package comp3350.got_apples.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import comp3350.got_apples.R;
import comp3350.got_apples.logic.RegisterHandler;
import comp3350.got_apples.logic.exceptions.InvalidInputException;
import comp3350.got_apples.objects.CurrentUser;

public class RegisterActivity extends AppCompatActivity {

    private EditText registerEmail;
    private EditText registerPassword;
    private EditText registerRepassword;
    private Button registerButton;
    private Button registerAlradyExists;
    private RegisterHandler registerHandler;
    private CurrentUser currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        registerEmail = findViewById(R.id.register_Email_Input);
        registerPassword = findViewById(R.id.register_Password_Input);
        registerRepassword = findViewById(R.id.register_rePassword_Input);
        registerButton = findViewById(R.id.register_register_Button);
        registerAlradyExists = findViewById(R.id.register_exists_Button);
        currentUser = new CurrentUser();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringUserName = String.valueOf(registerEmail.getText()); //get users username as string
                String stringPassword = String.valueOf(registerPassword.getText());   //get users password as string
                String stringrePassword = String.valueOf(registerRepassword.getText()); //get the repassword as string
                registerHandler = new RegisterHandler(true);
                try {
                    //first check whether username and password is invalid or not
                    CurrentUser currentUser1 = new CurrentUser(stringUserName, stringPassword);
                    //now check whether user is in DB or not
                    if(stringPassword.equals(stringrePassword) && registerHandler.addUser(currentUser1) ){
                        //we move forward
                        Intent intent = new Intent(RegisterActivity.this,IngredientsActivity.class);
                        intent.putExtra(CurrentUser.USER_TAG, currentUser);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        registerPassword.setError("You password does not matched!");
                    }
                }catch (InvalidInputException ie){

                    registerEmail.setError(ie.getMessage());
                }
            }
        });

        registerAlradyExists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(loginActivity);
                finish();
            }
        });

    }
}