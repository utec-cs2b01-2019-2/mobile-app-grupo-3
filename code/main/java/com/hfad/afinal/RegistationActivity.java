package com.hfad.afinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistationActivity extends AppCompatActivity {

    private EditText Username, Password, Email;
    private TextView GotoLog;
    private Button Register;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //First thing that runs when creating the APP
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation);
        setUpUIViews();

        firebaseAuth = FirebaseAuth.getInstance();

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    String user_email = Email.getText().toString().trim(); //Trim removes all white spaces that the user might have enter.
                    String user_password = Password.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(RegistationActivity.this,"Te has registrado!",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegistationActivity.this,MainActivity.class));
                            }
                            else{
                                Toast.makeText(RegistationActivity.this,"Error!",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    //Upload data to the database
                } //Valida si los usuarios han ingresado los datos correctos.
            }
        });

        GotoLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistationActivity.this, MainActivity.class));
            }
        });
    }

    private void setUpUIViews(){
        Username = findViewById(R.id.validUsername);
        Password = findViewById(R.id.validatePass);
        Email = findViewById(R.id.validateEmail);
        GotoLog = findViewById(R.id.GobackToLog);
        Register = findViewById(R.id.RegBtn);
    }

    private Boolean validate(){
        Boolean result = false;
        String name = Username.getText().toString();
        String pass = Password.getText().toString();
        String email = Email.getText().toString();


        if(name.isEmpty() && pass.isEmpty() && email.isEmpty()){
            Toast.makeText(this, "Porfavor ingresa tus datos!", Toast.LENGTH_SHORT).show();
        }else{
            result = true;
        }
        return result;
    }

}
