package com.example.pk_eagle.challenge;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by PK_Eagle on 9/28/2016.
 */

public class Dialog_Add extends DialogFragment {

    EditText etFname, etLname;
    Button btnAddName;
    onSubmitListener mListener;


    public interface onSubmitListener {
        void setOnSubmitListener(DataModel arg);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_add, container,
                false);

        getDialog().setTitle(getString(R.string.dialogtext));


        etFname = (EditText) view.findViewById(R.id.etFname);
        etLname = (EditText) view.findViewById(R.id.etLname);

        btnAddName = (Button) view.findViewById(R.id.btnAddNow);

        btnAddName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etFname.getText().toString().length() == 0)
                    etFname.setError(getString(R.string.req));
                else

                {
                    DataModel dt = new DataModel();
                    dt.setFirstName(etFname.getText().toString());
                    dt.setLastName(etLname.getText().toString());
                    mListener.setOnSubmitListener(dt);
                    dismiss();
                }
            }
        });
        return view;
    }


}


