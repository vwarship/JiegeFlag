package com.zaoqibu.jiegeflag;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zaoqibu.jiegeflag.domain.Continent;
import com.zaoqibu.jiegeflag.domain.Country;
import com.zaoqibu.jiegeflag.util.BitmapUtil;


public class FlagActivity extends FragmentActivity {
    public static final String ARG_CONTINENT = "continent";
    public static final String ARG_POSITION = "position";

    private Continent continent;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag_view);

//		getActionBar().setDisplayHomeAsUpEnabled(true);

        continent = (Continent)getIntent().getExtras().get(ARG_CONTINENT);
        position = getIntent().getExtras().getInt(ARG_POSITION);

        ViewPager flagPager = (ViewPager)findViewById(R.id.flagPager);
        flagPager.setAdapter(new FlagPagerAdapter(getSupportFragmentManager(), continent));

        flagPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
//                getActionBar().setTitle(continent.get(position).getName());
            }
        });

//        getActionBar().setTitle(continent.get(position).getName());
        flagPager.setCurrentItem(position);
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
        private Bitmap bitmap;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            Country country = (Country)getArguments().getSerializable(ARG_COUNTRY);

            View rootView = inflater.inflate(R.layout.activity_flag, container, false);

            ImageView imageView = (ImageView)rootView.findViewById(R.id.ivFlag);
//            imageView.setImageResource(country.getFlagResId());
            bitmap = BitmapUtil.decodeSampledBitmapFromResource(this.getResources(), country.getFlagResId(), 400, 400);
            imageView.setImageBitmap(bitmap);

            return rootView;
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();

            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
                System.gc();
            }
        }
    }

}
