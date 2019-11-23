package com.example.geniusquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    protected Button history, math, science;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        history = findViewById(R.id.history_button);

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent historyDisplay = new Intent(getApplicationContext(), HistoryActivity.class);
                startActivity(historyDisplay);
                finish();

            }
        });

    }


}
