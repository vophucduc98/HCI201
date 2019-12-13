package namdp.demo.urent;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeaturedSlidePageFragment extends Fragment {


    int pos;
    public FeaturedSlidePageFragment(int position) {
        pos = position;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_featured_slide_page, container, false);
        ImageView img = v.findViewById(R.id.content);
        if (pos == 0)
        {
            img.setImageResource(R.drawable.features_1);
        }
        if (pos == 1)
        {
            img.setImageResource(R.drawable.features_2);
        }
        if (pos == 2)
        {
            img.setImageResource(R.drawable.features_3);
        }
        if (pos == 3)
        {
            img.setImageResource(R.drawable.features_4);
        }
        if (pos == 4)
        {
            img.setImageResource(R.drawable.features_5);
        }
        return v;
    }
}
