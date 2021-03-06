package com.zaoqibu.jiegeflag;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zaoqibu.jiegeflag.domain.Continent;
import com.zaoqibu.jiegeflag.domain.Country;
import com.zaoqibu.jiegeflag.util.MediaPlayerSingleton;


public class FlagActivity extends ActionBarActivity {
    public static final String ARG_CONTINENT = "continent";
    public static final String ARG_POSITION = "position";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag_view);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Continent continent = (Continent)getIntent().getExtras().get(ARG_CONTINENT);
        final int position = getIntent().getExtras().getInt(ARG_POSITION);

        ViewPager flagPager = (ViewPager)findViewById(R.id.flagPager);
        flagPager.setAdapter(new FlagPagerAdapter(getSupportFragmentManager(), continent));

        flagPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                onPageChange(continent, position);
            }
        });

        flagPager.setCurrentItem(position);

        if (position == 0) {
            onPageChange(continent, position);
        }
    }

    private void onPageChange(Continent continent, int position) {
        Country country = continent.getCountryByIndex(position);
        getSupportActionBar().setTitle(country.getName());
        MediaPlayerSingleton.getInstance().play(getBaseContext(), country.getSoundResId());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    public class FlagPagerAdapter extends FragmentPagerAdapter
    {
        private Continent continent;

        public FlagPagerAdapter(FragmentManager fm, Continent continent) {
            super(fm);
            this.continent = continent;
        }

        @Override
        public Fragment getItem(int i) {
            Country country = continent.getCountryByIndex(i);

            Bundle bundle = new Bundle();
            bundle.putSerializable(FlagFragment.ARG_COUNTRY, country);

            Fragment fragment = new FlagFragment();
            fragment.setArguments(bundle);

            return fragment;
        }

        @Override
        public int getCount() {
            return continent.getCountryCount();
        }

    }

    public static class FlagFragment extends Fragment
    {
        public static final String ARG_COUNTRY = "country";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            final Country country = (Country)getArguments().getSerializable(ARG_COUNTRY);

            View rootView = inflater.inflate(R.layout.activity_flag, container, false);

            ImageView imageView = (ImageView)rootView.findViewById(R.id.ivFlag);
            imageView.setImageResource(country.getFlagResId());

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayerSingleton.getInstance().play(getActivity(), country.getSoundResId());
                }
            });

            if (isScreenOrientationPortrait(this.getActivity())) {
                TextView tvUseDate = (TextView) rootView.findViewById(R.id.tvUseDate);
                tvUseDate.setText(country.getUseDate());

                TextView tvAspectRatio = (TextView) rootView.findViewById(R.id.tvAspectRatio);
                tvAspectRatio.setText(country.getAspectRatio());

                TextView tvDesign = (TextView) rootView.findViewById(R.id.tvDesign);
                tvDesign.setText(country.getDesign());

                TextView tvMeaning = (TextView) rootView.findViewById(R.id.tvMeaning);
                tvMeaning.setText(country.getMeaning());
            }

            return rootView;
        }

        private boolean isScreenOrientationPortrait(Activity activity)
        {
            Configuration conf = activity.getResources().getConfiguration();
            if (conf.orientation == Configuration.ORIENTATION_PORTRAIT)
                return true;

            return false;
        }
    }

}
