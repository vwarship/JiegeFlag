package com.zaoqibu.jiegeflag.domain;

import java.io.Serializable;

public class Country implements Serializable
{
	private static final long serialVersionUID = -1771527299362743994L;
	
	private int nameResId;
	private int flagResId;
	private int soundResId;
	
	public Country(int flagResId, int soundResId)
	{
		this.flagResId = flagResId;
		this.soundResId = soundResId;
	}
	
	public int getNameResId() {
		return nameResId;
	}
	
	public void setNameResId(int nameResId) {
		this.nameResId = nameResId;
	}
	
	public int getFlagResId() {
		return flagResId;
	}
	
	public void setFlagResId(int flagResId) {
		this.flagResId = flagResId;
	}
	
	public int getSoundResId() {
		return soundResId;
	}
	
	public void setSoundResId(int soundResId) {
		this.soundResId = soundResId;
	}
	
}
