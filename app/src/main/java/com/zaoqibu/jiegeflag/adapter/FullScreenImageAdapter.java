package com.zaoqibu.jiegeflag.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.zaoqibu.jiegeflag.R;
import com.zaoqibu.jiegeflag.domain.Continent;
import com.zaoqibu.jiegeflag.domain.Country;
import com.zaoqibu.jiegeflag.util.BitmapUtil;

public class FullScreenImageAdapter extends PagerAdapter
{
	private Activity activity;
    private LayoutInflater inflater;
    
    private Continent continent;

    private Bitmap bitmap = null;
    public FullScreenImageAdapter(Activity activity, Continent continent)
    {
        this.activity = activity;
        this.continent = continent;
    }
 
	@Override
	public int getCount()
	{
		return continent.getCountryCount();
	}

	@Override
	public boolean isViewFromObject(View view, Object object)
	{
		return view == ((RelativeLayout) object);
	}

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imgDisplay;
  
        inflater = (LayoutInflater)(activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        View viewLayout = inflater.inflate(R.layout.layout_fullscreen_image, container, false);
  
        Country country = continent.getCountryByIndex(position);
        
        imgDisplay = (ImageView) viewLayout.findViewById(R.id.imgDisplay);
        bitmap = BitmapUtil.decodeSampledBitmapFromResource(activity.getBaseContext().getResources(), country.getFlagResId(), 300, 300);
        imgDisplay.setImageBitmap(bitmap);
//        imgDisplay.setImageResource(country.getFlagResId());
        imgDisplay.setOnClickListener(new OnImageClickListener(activity, country));
        
        ((ViewPager) container).addView(viewLayout);
  
        return viewLayout;
    }
    
    private static class OnImageClickListener implements OnClickListener
    {
    	private Activity activity;
    	private Country country;
    	
    	public OnImageClickListener(Activity activity, Country country)
    	{
    		this.activity = activity;
    		this.country = country;
    	}

		@Override
		public void onClick(View v)
		{
			MediaPlayer player =  MediaPlayer.create(activity, country.getSoundResId());
			player.start();
		}
    	
    }
     
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);
        if (bitmap != null && !bitmap.isRecycled())
        {
            bitmap.recycle();
            System.gc();
        }
    }

}
