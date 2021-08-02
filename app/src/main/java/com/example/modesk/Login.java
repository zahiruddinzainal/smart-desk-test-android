package com.example.modesk;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Login extends AppCompatActivity {

    TextView textView;
    FirebaseFirestore fStore;
    String userID;

    EditText mEmail, mPassword;
    Button mLoginButton;

    ProgressBar progressBar;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fAuth  = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar);
        mLoginButton = findViewById(R.id.loginButton);


        if(fAuth.getCurrentUser() != null){

            Intent pemilik = new Intent (Login.this, MainActivity.class);
            startActivity(pemilik);
            Toast.makeText(Login.this, "Welcome to smart plug", Toast.LENGTH_SHORT).show();

            finish();
        }



        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();



                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is required");
                    return;
                }

                if(password.length()<6){
                    mPassword.setError("Password must be more than 6 characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //authenticate the user
                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {



                        if(task.isSuccessful()){
                            Intent pemilik = new Intent (Login.this, MainActivity.class);
                            startActivity(pemilik);
                            Toast.makeText(Login.this, "Welcome to smart plug", Toast.LENGTH_SHORT).show();
                        }

                        else{
                            Toast.makeText(Login.this, "Sorry login fail", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);

                        }
                    }
                });


            }
        });


        textView=findViewById(R.id.registerHere);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });




    }
}
