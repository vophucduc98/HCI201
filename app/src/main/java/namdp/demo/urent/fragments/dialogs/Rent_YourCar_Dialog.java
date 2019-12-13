package namdp.demo.urent.fragments.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import namdp.demo.urent.R;

public class Rent_YourCar_Dialog extends DialogFragment {
    Button btnAccept, btnClose;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_rent_your_car, container, false);


        btnAccept = view.findViewById(R.id.btn_accept_rent);
        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
                Toast.makeText(getActivity(), "You accepted!", Toast.LENGTH_LONG).show();
            }
        });

        btnClose = view.findViewById(R.id.btn_reject_rent);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
                Toast.makeText(getActivity(), "You rejected!", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
