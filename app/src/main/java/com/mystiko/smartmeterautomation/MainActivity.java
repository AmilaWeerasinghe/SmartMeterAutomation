package com.mystiko.smartmeterautomation;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   private Button RegisterButton,LoginButton;
    private EditText EmailET,PasswordEt;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RegisterButton=(Button)findViewById(R.id.BRegister);
        LoginButton=(Button)findViewById(R.id.BLogin);
        EmailET=(EditText)findViewById(R.id.EditTextEmail);
        PasswordEt=(EditText)findViewById(R.id.EditTextPassword);
        RegisterButton.setOnClickListener(this);
        LoginButton.setOnClickListener(this);
        progressDialog=new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        if(v == RegisterButton){
            registerUser();
        }
        
    }

    private void registerUser() {
        String Email=EmailET.getText().toString();
        String Password=PasswordEt.getText().toString();

        if(TextUtils.isEmpty(Email)){
            //email field empty
            Toast.makeText(this,"Please Enter Email",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(Password)){
            //Password field empty
            Toast.makeText(this,"Please Enter Password",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering User");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(Email,Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"Registered Successfully",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this,"Couldn't register! Please Try again...",Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });


    }
}
