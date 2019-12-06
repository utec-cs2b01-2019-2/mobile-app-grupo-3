package com.hfad.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button LogOut, GoPosts, GoNoticias, GoCursos, GoGrupos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        firebaseAuth = FirebaseAuth.getInstance();
        LogOut = findViewById(R.id.LogOutBtt);
        GoPosts = findViewById(R.id.btn1SecondActivity);
        GoNoticias = findViewById(R.id.btn3SecondActivity);
        GoCursos = findViewById(R.id.btn2SecondActivity);
        GoGrupos = findViewById(R.id.btn4SecondActivity2);

        GoGrupos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this,GruposActivity.class));
            }
        });

        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(SecondActivity.this,MainActivity.class));
            }
        });

        GoPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this,PostsActivity.class));
            }
        });

        GoNoticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this,NoticiasActivity.class));
            }
        });

        GoCursos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this,CursosActivity.class));
            }
        });


    }
}
