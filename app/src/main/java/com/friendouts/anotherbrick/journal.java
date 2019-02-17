package com.friendouts.anotherbrick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;



public class journal extends AppCompatActivity {

    ImageButton backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(
                new ImageButton.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(journal.this, MainActivity.class));
                    }
                }
                        );

                }
}
