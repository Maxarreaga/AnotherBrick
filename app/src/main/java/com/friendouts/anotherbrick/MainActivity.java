package com.friendouts.anotherbrick;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.view.View;
import android.util.Log;
import android.widget.ImageButton;
import java.util.Calendar;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    FirebaseDatabase bigData = FirebaseDatabase.getInstance();
    DatabaseReference myRef = bigData.getInstance().getReference();


    Calendar myCalendar = Calendar.getInstance();
    int yearDay = myCalendar.get(Calendar.DAY_OF_YEAR);
    ImageButton calendarButton;
    ImageButton journalButton;
    RatingBar dailyBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarButton = findViewById(R.id.calendarButton);
        calendarButton.setOnClickListener(
                new ImageButton.OnClickListener(){
                    public void onClick(View v){
                startActivity(new Intent(MainActivity.this,calendar.class));
                    }
                }
        );
        journalButton = findViewById(R.id.journalButton);
        journalButton.setOnClickListener(
                new ImageButton.OnClickListener(){
                    public void onClick(View v){
                 startActivity(new Intent(MainActivity.this,journal.class));
                    }
                }
        );

        dailyBar = (RatingBar) findViewById(R.id.dailyRating);
        dailyBar.setOnClickListener(
                new RatingBar.OnClickListener(){
                    public void onClick(View v){

                        myRef.setValue(dailyBar.getRating());
                        //when you click the rating bar what happens
                    }
                }
        );
    }

    public void basicReadWrite() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello World");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }



}
