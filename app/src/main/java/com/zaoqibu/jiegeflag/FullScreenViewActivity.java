package com.zaoqibu.jiegeflag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.zaoqibu.jiegeflag.adapter.FullScreenImageAdapter;
import com.zaoqibu.jiegeflag.domain.Continent;

public class FullScreenViewActivity extends ActionBarActivity
{
	private FullScreenImageAdapter adapter;
    private ViewPager viewPager;
    
    private Continent continent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_view);

        viewPager = (ViewPager) findViewById(R.id.pager);

        Intent intent = getIntent();
        continent = (Continent)intent.getSerializableExtra("continent");

        adapter = new FullScreenImageAdapter(FullScreenViewActivity.this, continent);

        viewPager.setAdapter(adapter);

        // displaying selected image first
        viewPager.setCurrentItem(0);
    }
    
}
