package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class JobDialog extends AppCompatDialogFragment {

    private EditText startTimeText1, startTimeText2, startTimeText3, endTimeText1, endTimeText2, endTimeText3;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(view);

        startTimeText1 = view.findViewById(R.id.startTime1);
        startTimeText2 = view.findViewById(R.id.startTime2);
        startTimeText3 = view.findViewById(R.id.startTime3);
        endTimeText1 = view.findViewById(R.id.endTime1);
        endTimeText2 = view.findViewById(R.id.endTime2);
        endTimeText3 = view.findViewById(R.id.endTime3);

        return builder.create();
    }
}
