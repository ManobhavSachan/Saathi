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

import com.example.saathi.Models.UsersInfo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {

//    ActivitySignUpBinding binding;

    private FirebaseAuth auth;
    private FirebaseDatabase database;
    Button signUpBtn;
    EditText signUpEmail, signUpPassword, personName;
    TextView goToSignIn;

    ProgressDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Objects.requireNonNull(getSupportActionBar()).hide();

//        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
//        View view = binding.getRoot();
//        setContentView(view);
        // Instantiating firebase
        init();


        signUpBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                signUpWithEmail();
            }//onClick
        });

        goToSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                    startActivity(intent);
            }
        });

    }//OnCreate
    
//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = auth.getCurrentUser();
//        if(currentUser != null){
//            reload();
//        }
//    }

    public void init() {
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        // FindView by Id
        signUpBtn = findViewById(R.id.signUpBtn);
        personName = findViewById(R.id.personName);
        signUpEmail = findViewById(R.id.signUpEmail);
        signUpPassword = findViewById(R.id.signUpPassword);
        goToSignIn = findViewById(R.id.alreadyHaveAccount);


        // Dialog Box
        loadingDialog = new ProgressDialog(SignUpActivity.this);
        loadingDialog.setTitle("Creating Account");
        loadingDialog.setMessage("we are creating your account, please wait");
    }

    private void signUpWithEmail() {
        // User Information
        String userEmail = signUpEmail.getText().toString();
        String userPassword = signUpPassword.getText().toString();
        String userName = personName.getText().toString();
        if (signUpEmail.getText().length() != 0 && signUpPassword.getText().length() != 0) {
            loadingDialog.show();
            auth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    loadingDialog.dismiss();
                    if (task.isSuccessful()) {
                        Toast.makeText(SignUpActivity.this, "Account created successfully", Toast.LENGTH_SHORT).show();
                        UsersInfo usersInfo = new UsersInfo(userName, userEmail, userPassword);
//   getUser : Returns the currently signed-in FirebaseUser, or null if there isn't any (i.e. the user is signed out).
                        String id = Objects.requireNonNull(Objects.requireNonNull(task.getResult()).getUser()).getUid();
                        database.getReference().child("user").child(id).setValue(usersInfo);
                        reload();
                    } else {
                        Toast.makeText(SignUpActivity.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }else{
            Toast.makeText(SignUpActivity.this, "Please Enter Email And Password", Toast.LENGTH_SHORT).show();
        }
    }

    private void reload() {
        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        startActivity(intent);
    }
}//Main Class