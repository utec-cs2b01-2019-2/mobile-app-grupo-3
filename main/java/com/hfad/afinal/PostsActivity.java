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

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PostsActivity extends AppCompatActivity {


    private EditText writePosts;
    private TextView yourPost;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    String contenido;
    private Button SendPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        writePosts = findViewById(R.id.WritePost);
        yourPost = findViewById(R.id.yourPost);
        SendPost = findViewById(R.id.SendButton);

        SendPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contenido = writePosts.getText().toString();
                if(!contenido.isEmpty()){
                    sendUserData();
                }else{
                    Toast.makeText(PostsActivity.this, "Escribe algo!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                yourPost.setText(user.Posts);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(PostsActivity.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sendUserData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());
        User user = new User(contenido);
        myRef.setValue(user);
    }
}
