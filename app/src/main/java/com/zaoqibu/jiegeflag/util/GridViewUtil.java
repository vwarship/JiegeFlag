package com.zaoqibu.jiegeflag.util;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.TypedValue;

public class GridViewUtil
{
	private int portraitColNum = 2;
	private int landscapeColNum = 3;

    public GridViewUtil(int portraitColNum, int landscapeColNum) {
        this.portraitColNum = portraitColNum;
        this.landscapeColNum = landscapeColNum;
    }

    public int calcItemWidth(Activity activity) {
        int colNum = getColumnNumber(activity);
        return calcItemWidth(activity, colNum);
    }

    private int calcItemWidth(Activity activity, int colNum)
	{
		Resources r = activity.getResources();
		float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				8*2 + (colNum-1)*8,
				r.getDisplayMetrics());

		final int screenWidth = SystemMetadata.getScreenWidth(activity);
		return (int) ( (screenWidth-padding) / colNum);
	}

	public int getColumnNumber(Activity activity)
	{
		int colNum = portraitColNum;
		boolean isLand = isScreenOrientationLandscape(activity);
		if (isLand)
			colNum = landscapeColNum;
		
		return colNum;
	}
	
	private boolean isScreenOrientationLandscape(Activity activity)
	{
		Configuration conf = activity.getResources().getConfiguration();
		if (conf.orientation == Configuration.ORIENTATION_LANDSCAPE)
			return true;
		
		return false;
	}
	
}
