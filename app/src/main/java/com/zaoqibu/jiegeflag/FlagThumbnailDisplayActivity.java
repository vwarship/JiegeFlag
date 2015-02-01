package com.zaoqibu.jiegeflag;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.zaoqibu.jiegeflag.domain.Continent;
import com.zaoqibu.jiegeflag.util.GridViewUtil;


public class FlagThumbnailDisplayActivity extends ActionBarActivity {
    public static final String ARG_CONTINENT = "continent";

    private Continent continent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag_thumbnail_display);

        continent = (Continent)getIntent().getSerializableExtra(ARG_CONTINENT);

        GridViewUtil gridViewUtil = new GridViewUtil(3, 5);

        GridView gvFlagThumbnail = (GridView)findViewById(R.id.gvFlagThumbnail);
        gvFlagThumbnail.setNumColumns(gridViewUtil.getColumnNumber(this));
        gvFlagThumbnail.setAdapter(new FlagThumbnailItemAdapter(this, gridViewUtil.calcItemWidth(this), continent));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_flag_thumbnail_display, menu);
        return true;
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

        return super.onOptionsItemSelected(item);
    }
}
