package com.example.stuff_14.Home;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.stuff_14.R;

import static android.content.Context.MODE_PRIVATE;

public class Dialog_Username extends AppCompatDialogFragment {
    private EditText edittext_Username;
    private Dialog_Username_Listener listener;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog,null);
        builder.setView(view)
                .setTitle("Player username")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.apply_Text("NoName");
                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String username = edittext_Username.getText().toString();
                        listener.apply_Text(username);
                    }
                });

        edittext_Username = view.findViewById(R.id.editText_Username);
        return  builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (Dialog_Username_Listener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement dialog_Username_listener");
        }
    }

    public interface Dialog_Username_Listener {
        void apply_Text(String username);
    }
}
