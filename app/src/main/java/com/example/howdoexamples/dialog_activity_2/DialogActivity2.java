package com.example.howdoexamples.dialog_activity_2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.howdoexamples.R;

public class DialogActivity2 extends AppCompatActivity
        implements MyCustomDialog.NoticeDialogListener {

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

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "Example #2", Toast.LENGTH_SHORT).show();
    }

    private void showDialog() {
        AppCompatDialogFragment dialog = new MyCustomDialog();
        dialog.show(getSupportFragmentManager(), "my_dialog_tag");
    }

    @Override
    public void onDialogPositiveClick(DialogInterface dialog, String username, String password) {
        dialogOutputTextView.setText(username + " + " + password);
    }

    @Override
    public void onDialogNegativeClick(DialogInterface dialog) {
        dialogOutputTextView.setText("Dialog canceled");
    }
}
