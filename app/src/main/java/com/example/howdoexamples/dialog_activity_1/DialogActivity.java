package com.example.howdoexamples.dialog_activity_1;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.howdoexamples.R;

public class DialogActivity extends AppCompatActivity {

    private TextView dialogOutputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        findViewById(R.id.show_dialog_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        dialogOutputTextView = (TextView) findViewById(R.id.dialog_output);
    }

    private void showDialog() {

        final View dialogCustomView = getLayoutInflater().inflate(R.layout.dialog_login, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setView(dialogCustomView)
                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String username = String.valueOf(((EditText) dialogCustomView.findViewById(R.id.username)).getText());
                        String password = String.valueOf(((EditText) dialogCustomView.findViewById(R.id.password)).getText());

                        dialogOutputTextView.setText(username + " + " + password);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogOutputTextView.setText("Dialog canceled");
                    }
                });

        builder.create().show();
    }

}
