package com.zaoqibu.jiegeflag.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.zaoqibu.jiegeflag.R;
import com.zaoqibu.jiegeflag.domain.Continent;
import com.zaoqibu.jiegeflag.domain.World;

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
	public View getView(int position, View convertView, ViewGroup parent) 
	{
        View item = null;

        if (convertView == null)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            item = layoutInflater.inflate(R.layout.gridview_item_continent, parent, false);
            item.setLayoutParams(new GridView.LayoutParams(gridItemWidth, gridItemWidth));
        }
        else
        {
            item = convertView;
        }

        Continent continent = world.getContinentByIndex(position);

        ImageView ivContinent = (ImageView)item.findViewById(R.id.ivContinent);
        ivContinent.setImageResource(continent.getImageResId());

//        TextView tvContinentName = (TextView)item.findViewById(R.id.tvContinentName);
//        tvContinentName.setText(continent.getName());

        return item;
	}

}
