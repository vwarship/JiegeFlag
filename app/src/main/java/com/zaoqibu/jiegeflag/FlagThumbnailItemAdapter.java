package com.zaoqibu.jiegeflag;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.zaoqibu.jiegeflag.domain.Continent;
import com.zaoqibu.jiegeflag.util.BitmapUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vwarship on 2015/2/1.
 */
public class FlagThumbnailItemAdapter extends BaseAdapter {
    private Context context;
    private int gridItemWidth;
    private Continent continent;

    public FlagThumbnailItemAdapter(Context context, int gridItemWidth, Continent continent) {
        this.context = context;
        this.gridItemWidth = gridItemWidth;
        this.continent = continent;
    }

    @Override
    public int getCount() {
        return continent.getCountryCount();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.gridview_item_flag_thumbnail, parent, false);
            view.setLayoutParams(new GridView.LayoutParams(gridItemWidth, gridItemWidth));
        }
        else {
            view = convertView;
        }

        final int key = view.hashCode();

        if (bitmaps.containsKey(key)) {
            Bitmap bitmap = bitmaps.remove(key);
            bitmap.recycle();
            System.gc();
        }

        ImageView ivFlagThumbnail = (ImageView)view.findViewById(R.id.ivFlagThumbnail);
        Bitmap bitmap = BitmapUtil.decodeSampledBitmapFromResource(context.getResources(), continent.getCountryByIndex(position).getFlagResId(), 150, 150);
        ivFlagThumbnail.setImageBitmap(bitmap);

        bitmaps.put(key, bitmap);

//        TextView tvFlagName = (TextView)view.findViewById(R.id.tvFlagName);
//        tvFlagName.setText();

        return view;
    }

    private Map<Integer, Bitmap> bitmaps = new HashMap<Integer, Bitmap>();

    public void recycleBitmaps() {
        for (Map.Entry<Integer, Bitmap> entry : bitmaps.entrySet()) {
            entry.getValue().recycle();
            System.gc();
        }

        bitmaps.clear();
    }

}
