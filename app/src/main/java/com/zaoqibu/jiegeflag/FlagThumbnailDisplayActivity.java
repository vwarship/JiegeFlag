package com.zaoqibu.jiegeflag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
        gvFlagThumbnail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FlagThumbnailDisplayActivity.this, FlagActivity.class);
                intent.putExtra(FlagActivity.ARG_CONTINENT, continent);
                intent.putExtra(FlagActivity.ARG_POSITION, position);
                startActivity(intent);
            }
        });
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
