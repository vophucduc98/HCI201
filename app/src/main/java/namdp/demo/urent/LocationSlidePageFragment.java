package namdp.demo.urent;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocationSlidePageFragment extends Fragment {


    int pos;
    public LocationSlidePageFragment(int position) {
        pos = position;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_location_slide_page, container, false);
        ImageView img = v.findViewById(R.id.content);
        TextView text = v.findViewById(R.id.myImageViewText);
        if (pos == 0)
        {
            text.setText("Hà Nội");
            img.setImageResource(R.drawable.hn);
        }
        if (pos == 1)
        {
            text.setText("Hồ Chí Minh");
            img.setImageResource(R.drawable.hcm);
        }
        if (pos == 2)
        {
            text.setText("Tây Ninh");
            img.setImageResource(R.drawable.tn);
        }
        if (pos == 3)
        {
            text.setText("Đà Nẵng");
            img.setImageResource(R.drawable.dn);
        }
        if (pos == 4)
        {
            text.setText("Huế");
            img.setImageResource(R.drawable.hue);
        }
        return v;
    }

}
