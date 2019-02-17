package com.friendouts.anotherbrick;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class journal extends AppCompatActivity {

    ImageButton backButton;
    TextInputLayout journallog;

    FirebaseDatabase bigData = FirebaseDatabase.getInstance();
    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference conditionRef = myRef.child("condition");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);
        journallog = findViewById(R.id.textInputLayout);
        backButton = findViewById(R.id.imageButton);
        backButton.setOnClickListener(
                new ImageButton.OnClickListener(){
                    public void onClick(View v) {
                        startActivity(new Intent(journal.this,MainActivity.class));
                        myRef.setValue(journallog.getEditText().getText().toString());
                    }
                }
        );
    myRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            //String text = dataSnapshot.getValue(String.class);

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
    }
}
