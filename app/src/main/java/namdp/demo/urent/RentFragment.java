package namdp.demo.urent;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

/**
 * A simple {@link Fragment} subclass.
 */
public class RentFragment extends Fragment {


    public RentFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_rent, container, false);
        view.findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity homeActivity=((HomeActivity)getActivity());
                homeActivity.backFragment();
            }
        });

        view.findViewById(R.id.btnFind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity homeActivity=((HomeActivity)getActivity());
                homeActivity.showMap();
            }
        });
        return view;
    }


}
