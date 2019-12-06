package com.hfad.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NoticiasActivity extends AppCompatActivity {

    private TextView N1, N2, N3;
    private String inUrl = "http://computersciencenews.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        N1 = findViewById(R.id.Noticia1);
        N2 = findViewById(R.id.Noticia2);
        N3 = findViewById(R.id.Noticia3);


        N1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openURL(inUrl);
            }
        });

        N2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openURL(inUrl);
            }
        });

        N3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openURL(inUrl);
            }
        });
    }

    public void openURL(String inUrl){
        Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse( inUrl ));
        startActivity(browse);
    }
}
