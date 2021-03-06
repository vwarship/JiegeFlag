package com.zaoqibu.jiegeflag;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.umeng.analytics.MobclickAgent;
import com.zaoqibu.jiegeflag.domain.Continent;
import com.zaoqibu.jiegeflag.domain.World;

import java.util.HashMap;
import java.util.Map;

public class GridViewContinentAdapter extends BaseAdapter
{
	private Context context;
    private int gridItemWidth;

	private World world;

    public GridViewContinentAdapter(Context context, int gridItemWidth, World world)
	{
		this.context = context;
        this.gridItemWidth = gridItemWidth;
		this.world = world;
	}

	@Override
	public int getCount() {
		return world.getContinentCount();
	}

	@Override
	public Object getItem(int position) {
		return world.getContinentByIndex(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
        View item = null;

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            item = layoutInflater.inflate(R.layout.gridview_item_continent, parent, false);
            item.setLayoutParams(new GridView.LayoutParams(gridItemWidth, gridItemWidth));
        }
        else {
            item = convertView;
        }

        final Continent continent = world.getContinentByIndex(position);

        ImageView ivContinent = (ImageView)item.findViewById(R.id.ivContinent);
        ivContinent.setImageResource(continent.getImageResId());

        TextView tvContinentName = (TextView)item.findViewById(R.id.tvContinentName);
        tvContinentName.setText(continent.getName());

        ImageView ivPlay = (ImageView)item.findViewById(R.id.ivPlay);
        ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,String> map = new HashMap<String,String>();
                map.put("continent", continent.getName());
                MobclickAgent.onEvent(context, "continent_play_sound");

                MediaPlayer player =  MediaPlayer.create(context, continent.getSoundResId());
                player.start();
            }
        });

        return item;
	}

}
