package com.hfad.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GruposActivity extends AppCompatActivity {

    private TextView Link1, Link2, Link3;
    private String Url = "https://ocw.mit.edu/index.htm";
    private String Url2 = "https://chat.whatsapp.com/ENqwr6U5UHBGoWaMObuZiA";
    private String Url3 = "https://github.com/peon-pasado/icpc-training";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupos);
        Link1 = findViewById(R.id.Link1);
        Link2 = findViewById(R.id.Link2);
        Link3 = findViewById(R.id.Link3);

        Link1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenUrl(Url3);
            }
        });

        Link2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenUrl(Url);
            }
        });

        Link3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenUrl(Url2);
            }
        });


    }

    public void OpenUrl(String Url){
        Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse( Url ));
        startActivity(browse);
    }
}
