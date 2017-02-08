package com.example.howdoexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.howdoexamples.dialog_activity_1.DialogActivity;
import com.example.howdoexamples.dialog_activity_2.DialogActivity2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.dialog_example).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), DialogActivity.class);
                startActivity(i);
            }
        });

        findViewById(R.id.dialog_example_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), DialogActivity2.class);
                startActivity(i);
            }
        });
    }

}
