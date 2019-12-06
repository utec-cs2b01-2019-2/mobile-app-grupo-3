package com.hfad.afinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button LogIn;
    private TextView GoReg;
    private int contador = 0;
    private FirebaseAuth firebaseAuth; //Import libraries of the authentication
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.userLoginActivity);
        Password = findViewById(R.id.passLoginActivity);
        Info = findViewById(R.id.attLoginActivity);
        LogIn = findViewById(R.id.btnLoginActivity);
        GoReg =findViewById(R.id.regTVLogActivity);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        FirebaseUser user = firebaseAuth.getCurrentUser(); // Checks if a user has already log in

        if(user != null){ //Checks if a user is already logged in
            finish();
            startActivity(new Intent(MainActivity.this,SecondActivity.class));
        }

        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validate(Name.getText().toString(), Password.getText().toString()); // VALIDA
            }
        });
        GoReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegistationActivity.class));
            }
        });
    }

    private void Validate(String userName, String userPass){
        progressDialog.setMessage("Estamos verificando tu cuenta.");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(userName,userPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this,"Exito!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,SecondActivity.class));
                }else{
                    Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                    contador++;
                    progressDialog.dismiss();
                    Info.setText("Numero de intentos: " + contador);
                    if(contador == 5){
                        LogIn.setEnabled(false);
                    }
                }
            }
        });
    }

}
