package com.example.geniusquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private TextView score;
    private Button backMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        score = findViewById(R.id.finalScore);
        backMenu = findViewById(R.id.back);


        final Intent intent = getIntent();
        int final_score = intent.getIntExtra("Score",0);
        score.setText(final_score + "/10");


        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent1);
                finish();

            }
        });


    }




}
