package com.example.schoolapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.schoolapp.SQL.DatabaseHelper;
import com.example.schoolapp.activities.MainPage;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final AppCompatActivity activity = MainActivity.this;
    private EditText textInputEditTextEmail;
    private EditText textInputEditTextPassword;
    private Button appCompatButtonLogin;
    private TextView textViewLinkRegister;
    private DatabaseHelper databaseHelper;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
       // Log.e("test", user.toString());
        if (user != null) {
            Intent i = new Intent(MainActivity.this, MainPage.class);
            startActivity(i);
            finish();
        }
        // getSupportActionBar().hide();
        textInputEditTextEmail = (EditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = (EditText) findViewById(R.id.textInputEditTextPassword);
        appCompatButtonLogin = (Button) findViewById(R.id.ButtonLogin);
        //textViewLinkRegister = (TextView) findViewById(R.id.textViewLinkRegister);
        appCompatButtonLogin.setOnClickListener(this);
       // textViewLinkRegister.setOnClickListener(this);
        databaseHelper = new DatabaseHelper(activity);
    }

    //This implemented method is to listen the click on view
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ButtonLogin:
                check();
                verifyFromSQLite();
                Intent intentMpage = new Intent(getApplicationContext(), MainPage.class);
                startActivity(intentMpage);
               //finish();
                break;
           // case R.id.textViewLinkRegister:
                // Navigate to RegisterActivity
                // Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                // startActivity(intentRegister);
             //   break;
        }
    }

    private void check() {
        if (textInputEditTextEmail == null) {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter Email", Toast.LENGTH_SHORT);
            toast.show();
        }
        if (textInputEditTextPassword == null) {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    // This method is to validate the input text fields and verify login credentials from SQLite
    private void verifyFromSQLite() {

        if (databaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim()
                , textInputEditTextPassword.getText().toString().trim())) {
            Intent accountsIntent = new Intent(activity, MainPage.class);
            accountsIntent.putExtra("EMAIL", textInputEditTextEmail.getText().toString().trim());
            emptyInputEditText();
            startActivity(accountsIntent);
        } else {
            //  Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.error_valid_email_password), Toast.LENGTH_SHORT);
            //toast.show();
        }
    }

    //This method is to empty all input edit text
    private void emptyInputEditText() {
        textInputEditTextEmail.setText(null);
        textInputEditTextPassword.setText(null);
    }
}


