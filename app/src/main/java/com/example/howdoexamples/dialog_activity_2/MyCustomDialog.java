package com.example.howdoexamples.dialog_activity_2;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.howdoexamples.R;

public class MyCustomDialog extends AppCompatDialogFragment {

    public interface NoticeDialogListener {
        void onDialogPositiveClick(DialogInterface dialog, String username, String password);
        void onDialogNegativeClick(DialogInterface dialog);
    }

    NoticeDialogListener noticeDialogListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            noticeDialogListener = (NoticeDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement NoticeDialogListener to use this dialog");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final View dialogCustomView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_login, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                .setView(dialogCustomView)
                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String username = String.valueOf(((EditText) dialogCustomView.findViewById(R.id.username)).getText());
                        String password = String.valueOf(((EditText) dialogCustomView.findViewById(R.id.password)).getText());

                        noticeDialogListener.onDialogPositiveClick(dialogInterface, username, password);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        noticeDialogListener.onDialogNegativeClick(dialogInterface);
                    }
                });

        return builder.create();
    }
}
