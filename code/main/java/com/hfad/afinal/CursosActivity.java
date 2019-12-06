package com.hfad.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CursosActivity extends AppCompatActivity {

    private TextView C1,C2,C3;
    private String Url = "https://www.utec.edu.pe/en/undergraduate-programs/computer-science/curricular-structure";
    private String Url2 = "https://clei2004.spc.org.pe/Peru/CS-UTEC/Plan%202018/CS-UTEC-poster.pdf";
    private Button toUtec,toMalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);
        C1 = findViewById(R.id.Curso1);
        C2 = findViewById(R.id.Curso2);
        C3 = findViewById(R.id.Curso3);
        toUtec = findViewById(R.id.ButtonCursos);
        toMalla = findViewById(R.id.buttonCursos2);

        toMalla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl(Url2);
            }
        });

        toUtec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl(Url);
            }
        });

        C1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl(Url);
            }
        });

        C2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl(Url);
            }
        });

        C3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl(Url);
            }
        });

    }

    public void openUrl(String Url){
        Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse( Url ));
        startActivity(browse);
    }
}
