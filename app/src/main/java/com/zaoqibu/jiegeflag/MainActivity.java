package com.zaoqibu.jiegeflag;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.zaoqibu.jiegeflag.adapter.GridViewContinentAdapter;
import com.zaoqibu.jiegeflag.domain.Continent;
import com.zaoqibu.jiegeflag.domain.World;
import com.zaoqibu.jiegeflag.util.Constant;
import com.zaoqibu.jiegeflag.util.Size;

public class MainActivity extends ActionBarActivity {
    private GridView gridView;
    Size gridSize = new Size();

    private int m_numOfColumns = Constant.NUM_OF_COLUMNS;
    private int m_numOfRows = Constant.NUM_OF_ROWS;

    private World world;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        world  = new World();
        gridView = (GridView) findViewById(R.id.grid_view_main);
        InitilizeGridLayout();

        gridView.setAdapter(new GridViewContinentAdapter(this, gridSize.width, world));
    }

    public static class CourseImageViewClickListener implements View.OnClickListener
    {
        private Activity activity;
        private Continent continent;

        public CourseImageViewClickListener(Activity activity, Continent continent)
        {
            this.activity = activity;
            this.continent = continent;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(activity, FullScreenViewActivity.class);
            intent.putExtra("continent", continent);
            activity.startActivity(intent);
        }
    }

    private void InitilizeGridLayout()
    {
        calcRowColumnNum();

        Resources r = getResources();
        float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Constant.GRID_PADDING, r.getDisplayMetrics());
        Log.i("test", "padding:"+padding);

        final Size screenSize = getScreenSize();
        gridSize.width = (int) ((screenSize.width - ((m_numOfColumns + 1) * padding)) / m_numOfColumns);
        gridSize.height = (int) ((screenSize.height - ((m_numOfRows + 1 + 3) * padding)) / m_numOfRows);
        Log.i("test", "width:"+gridSize.width);
        Log.i("test", "height:"+gridSize.height);
        gridSize.height = gridSize.width;

        gridView.setNumColumns(m_numOfColumns);
        gridView.setColumnWidth(gridSize.width);
        gridView.setPadding((int) padding, (int) padding, (int) padding, (int) padding);
        gridView.setHorizontalSpacing((int) padding);
        gridView.setVerticalSpacing((int) padding);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(MainActivity.this, FlagThumbnailDisplayActivity.class);
                intent.putExtra(FlagThumbnailDisplayActivity.ARG_CONTINENT, world.getContinentByIndex(position));
                startActivity(intent);
            }
        });
    }

    private void calcRowColumnNum()
    {
        boolean isScreenOrientationLandscape = isScreenOrientationLandscape();

        if (isScreenOrientationLandscape)
        {
            m_numOfColumns = Constant.NUM_OF_COLUMNS;
            m_numOfRows = Constant.NUM_OF_ROWS;
        }
        else
        {
            m_numOfColumns = Constant.NUM_OF_ROWS;
            m_numOfRows = Constant.NUM_OF_COLUMNS;
        }
    }

    private boolean isScreenOrientationLandscape()
    {
        Configuration conf = getResources().getConfiguration();
        if (conf.orientation == Configuration.ORIENTATION_LANDSCAPE)
            return true;

        return false;
    }

    public Size getScreenSize()
    {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        return new Size(metrics.widthPixels, metrics.heightPixels);
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
