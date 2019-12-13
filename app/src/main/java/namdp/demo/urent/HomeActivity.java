package namdp.demo.urent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import namdp.demo.urent.fragments.NotificationFragment;

public class HomeActivity extends AppCompatActivity implements TopFragment.OnFragmentInteractionListener,NotificationFragment.OnFragmentInteractionListener{

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_container, new TopFragment());
        ft.addToBackStack(null);
        ft.commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        setFragment(new TopFragment());
                        return true;
                    case R.id.nav_notification:
                        setFragment(new NotificationFragment());
                        return true;
                    case R.id.nav_account:
                        setFragment(new AccountFragment());
                        return true;
                    default:return false;
                }


            }
        });
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        //fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    public void changeFragment()
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
        ft.replace(R.id.fragment_container, new RentFragment());
        ft.addToBackStack(null);
        ft.commit();
    }

    public void backFragment()
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
        ft.replace(R.id.fragment_container, new TopFragment());
        ft.addToBackStack(null);
        ft.commit();
    }

    public void toDetail()
    {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }

    public void showMap()
    {
        //generateText();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.map_container, new FragmentMaps());
        ft.addToBackStack(null);
        ft.commit();
        FrameLayout placeHolder = (FrameLayout) findViewById(R.id.car_container);
        getLayoutInflater().inflate(R.layout.screen_slide, placeHolder);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setClipToPadding(false);
        mPager.setPageMargin(40);
        pagerAdapter = new HomeActivity.ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
    }



    public void generateText()
    {
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl);
        TextView tv = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, // Width of TextView
                RelativeLayout.LayoutParams.WRAP_CONTENT); // Height of TextView
        lp.leftMargin = 40;
        lp.topMargin = 30;
        lp.addRule(RelativeLayout.BELOW, R.id.map_container);
        tv.setLayoutParams(lp);
        tv.setText("CAR NEAR YOU:");
        tv.setTextSize(30);
        tv.setTextColor(Color.parseColor("#313131"));
        rl.addView(tv);
    }

    private static final int NUM_PAGES = 3;
    private ViewPager mPager;
    private PagerAdapter pagerAdapter;


    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
                return new ScreenSlidePageFragment(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }


    public void showFeatured()
    {
        Log.println(Log.DEBUG,"Hello","Featured");
        FrameLayout placeHolder = (FrameLayout) findViewById(R.id.featuredcontainer);
        getLayoutInflater().inflate(R.layout.screen_slide, placeHolder);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setClipToPadding(false);
        mPager.setPageMargin(40);
        pagerAdapter = new HomeActivity.FeaturedSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
    }

    private class FeaturedSlidePagerAdapter extends FragmentStatePagerAdapter {
        @Override
        public float getPageWidth (int position) {
            return 0.93f;
        }

        public FeaturedSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return new FeaturedSlidePageFragment(position);
        }

        @Override
        public int getCount() {
            return 5;
        }
    }

    private ViewPager mPager2;
    private PagerAdapter pagerAdapter2;

    public void showLocation()
    {
        Log.println(Log.DEBUG,"Hello","Location");
        FrameLayout placeHolder = (FrameLayout) findViewById(R.id.locationcontainer);
        getLayoutInflater().inflate(R.layout.screen_slide_2, placeHolder);
        mPager2 = (ViewPager) findViewById(R.id.pager2);
        mPager2.setClipToPadding(false);
        mPager2.setPageMargin(40);
        pagerAdapter2 = new HomeActivity.LocationSlidePagerAdapter(getSupportFragmentManager());
        mPager2.setAdapter(pagerAdapter2);
    }

    private class LocationSlidePagerAdapter extends FragmentStatePagerAdapter {
        @Override
        public float getPageWidth (int position) {
            return 0.93f;
        }

        public LocationSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return new LocationSlidePageFragment(position);
        }

        @Override
        public int getCount() {
            return 5;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
