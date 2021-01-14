package com.example.menu.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.menu.Helper.LoginHelper;
import com.example.menu.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class Login extends AppCompatActivity {
    private Button login;
    private Button register;
    private EditText email, password;
    private CheckBox saveLogin;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLoginControl;
    public LoginHelper loginHelper;
    protected boolean checklogin;
    protected OnCompleteListener onCompleteListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        login = (Button) findViewById(R.id.login);
        register = findViewById(R.id.register);
        email = findViewById(R.id.logemail);
        password = findViewById(R.id.logpassword);
        saveLogin = findViewById(R.id.checkBox);
        loginHelper = new LoginHelper();

        onCompleteListener = new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if (task.isSuccessful())
                    checklogin = true;
                else
                    checklogin = false;
                authentication();
            }
        };

        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
        saveLoginControl = loginPreferences.getBoolean("saveLoginControl", false);
        if (saveLoginControl == true) {
            email.setText(loginPreferences.getString("email", ""));
            password.setText(loginPreferences.getString("password", ""));
            saveLogin.setChecked(true);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginHelper.login(email, password, onCompleteListener);
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(email.getWindowToken(), 0);
                if (saveLogin.isChecked()) {
                    loginPrefsEditor.putBoolean("saveLoginControl", true);
                    loginPrefsEditor.putString("email", email.getText().toString());
                    loginPrefsEditor.putString("password", password.getText().toString());
                    loginPrefsEditor.commit();
                } else {
                    loginPrefsEditor.clear();
                    loginPrefsEditor.commit();
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoregistration();
            }
        });
    }

    private void authentication() {
        if (checklogin) {
            Toast.makeText(Login.this, "Accesso Effettuato", Toast.LENGTH_LONG).show();
            gotomenu();
        } else
            Toast.makeText(Login.this, "Nome Utente e/o Password Errati", Toast.LENGTH_LONG).show();
    }

    private void gotomenu() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    private void gotoregistration() {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}

