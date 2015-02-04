package com.zaoqibu.jiegeflag.util;

import android.content.Context;
import android.media.MediaPlayer;

public class MediaPlayerSingleton
{
	private volatile static MediaPlayerSingleton uniqueInstance;
	
	private MediaPlayer player = null;
	
	private MediaPlayerSingleton() {
        player = new MediaPlayer();
	}

    public void play(Context context, int soundResId)
	{
        synchronized (MediaPlayer.class) {
            release();
            player = MediaPlayer.create(context, soundResId);
        }

        player.start();
	}
	
	public void release() {
    	if (player!=null) {
    		player.release();
    	}
	}
	
	public static MediaPlayerSingleton getInstance()
	{
		if (uniqueInstance == null)
		{
			synchronized (MediaPlayerSingleton.class) {
				if (uniqueInstance == null)
					uniqueInstance = new MediaPlayerSingleton();
			}
		}
		
		return uniqueInstance;
	}

}
