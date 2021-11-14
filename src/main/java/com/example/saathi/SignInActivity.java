package com.example.saathi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SignInActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseDatabase database;
    Button signInBtn, googleSignIn;
    EditText signInEmail, signInPassword;
    TextView goToSignUp;

    ProgressDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        getSupportActionBar().hide();

        init();

        // Email SignIn
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInWithEmail();
            }//onClick
        });//Click_listener

        goToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }//onCreate

    public void init(){
        // Instantiating firebase
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        // FindView by Id
        signInBtn = findViewById(R.id.signInBtn);
        signInEmail = findViewById(R.id.signInEmail);
        signInPassword = findViewById(R.id.signInPassword);
        goToSignUp = findViewById(R.id.signUpInstead);
        googleSignIn = findViewById(R.id.googleSignIn);
        // Dialog Box
        loadingDialog = new ProgressDialog(SignInActivity.this);
        loadingDialog.setTitle("Signing in Account");
        loadingDialog.setMessage("Just a second :)");
    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = auth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

    private void reload() {
        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private void signInWithEmail() {
        // User Information
        String userEmail = signInEmail.getText().toString();
        String userPassword = signInPassword.getText().toString();

        loadingDialog.show();
        auth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Toast.makeText(SignInActivity.this, "Signed In", Toast.LENGTH_SHORT).show();
                    reload();
                }else {
                    Toast.makeText(SignInActivity.this, Objects.requireNonNull(Objects.requireNonNull(task.getException()).getMessage()), Toast.LENGTH_SHORT).show();
                }
                loadingDialog.dismiss();
            }
        });
    }

}// main class