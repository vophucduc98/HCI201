package namdp.demo.urent;


import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageFragment extends Fragment {
    int pos;
    HomeActivity homeActivity;
    public ScreenSlidePageFragment(int position) {
        pos = position;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        ImageView img = v.findViewById(R.id.imageView);
        TextView txt = v.findViewById(R.id.name);
        RatingBar rb = v.findViewById(R.id.rating);
        if (pos == 0)
        {
            img.setImageResource(R.drawable.car_1);
        }
        if (pos == 1)
        {
            txt.setText("LAMBORGHINI");
            rb.setNumStars(3);
            img.setImageResource(R.drawable.car_2);
        }
        if (pos == 2)
        {
            rb.setNumStars(4);
            txt.setText("BATMOBILE");
            img.setImageResource(R.drawable.car_3);
        }
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pos == 0)
                    homeActivity=((HomeActivity)getActivity());
                    homeActivity.toDetail();
            }
        });
        return v;
    }

}
