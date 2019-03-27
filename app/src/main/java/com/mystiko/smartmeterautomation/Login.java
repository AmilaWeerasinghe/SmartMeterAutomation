package com.mystiko.smartmeterautomation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText Email,Password;
    Button LoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Email=(EditText)findViewById(R.id.editTextEmail);
        Password=(EditText)findViewById(R.id.editTextPassword);
        LoginButton=(Button)findViewById(R.id.LoginButton);
        LoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
    public void OpenRegister(View view){
        startActivity(new Intent(this,MainActivity.class));
    }
}
