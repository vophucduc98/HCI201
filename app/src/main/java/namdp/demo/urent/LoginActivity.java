package namdp.demo.urent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    private EditText username;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.edtUsername);
        password = findViewById(R.id.edtPassword);

    }

    private void validate(String username, String password){
        if(username.equals("user") && password.equals("1234")){
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Incorrect Password ! Please Try Again !", Toast.LENGTH_LONG).show();
        }
    }

    public void clickToLogin(View view){
        validate(username.getText().toString(), password.getText().toString());
    }

    public void clickToResetPassword(View view){
        Intent intent = new Intent(this, ResetPasswordActivity.class);
        startActivity(intent);
    }

    public void clickToLoginWithFacebook(View view){

    }
}
