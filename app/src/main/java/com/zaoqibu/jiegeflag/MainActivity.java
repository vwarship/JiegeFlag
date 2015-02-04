package com.zaoqibu.jiegeflag;

import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.zaoqibu.jiegeflag.adapter.GridViewContinentAdapter;
import com.zaoqibu.jiegeflag.domain.World;
import com.zaoqibu.jiegeflag.util.FlagsXmlParser;
import com.zaoqibu.jiegeflag.util.GridViewUtil;

public class MainActivity extends ActionBarActivity {
    private World world;

    private GridView gridView;
    private GridViewContinentAdapter continentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        world  = new World();
        XmlResourceParser xmlResourceParser = getResources().getXml(R.xml.flags);
        FlagsXmlParser parser = new FlagsXmlParser();
        world = parser.parse(xmlResourceParser);
        Log.i("test", ">>"+world.getContinentCount());
        Log.i("test", ">>1"+world.getContinentByIndex(0).getImageResId());
        Log.i("test", ">>2"+world.getContinentByIndex(1).getImageResId());

        GridViewUtil gridViewUtil = new GridViewUtil(2, 3);

        continentAdapter = new GridViewContinentAdapter(this, gridViewUtil.calcItemWidth(this), world);

        gridView = (GridView) findViewById(R.id.grid_view_main);
        gridView.setNumColumns(gridViewUtil.getColumnNumber(this));
        gridView.setAdapter(continentAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(MainActivity.this, FlagThumbnailDisplayActivity.class);
                intent.putExtra(FlagThumbnailDisplayActivity.ARG_CONTINENT, world.getContinentByIndex(position));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        continentAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onStop() {
        super.onStop();
        continentAdapter.recycleBitmaps();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
