package com.zaoqibu.jiegeflag.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Continent implements Serializable
{
	private static final long serialVersionUID = -2226232452240725111L;
	
	private String name;
    private int imageResId;
    private int soundResId;

	private List<Country> countries = new ArrayList<Country>();
	
	public Continent(String name, int imageResId, int soundResId)
	{
		this.name = name;
        this.imageResId = imageResId;
        this.soundResId = soundResId;
	}

	public void AddCountry(Country country)
	{
		countries.add(country);
	}
	
	public int getCountryCount()
	{
		return countries.size();
	}
	
	public Country getCountryByIndex(int index)
	{
		return countries.get(index);
	}

	public String getName() {
		return name;
	}

    public int getImageResId() {
        return imageResId;
    }

    public int getSoundResId() {
        return soundResId;
    }

}
