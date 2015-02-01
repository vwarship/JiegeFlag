package com.zaoqibu.jiegeflag.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Continent implements Serializable
{
	private static final long serialVersionUID = -2226232452240725111L;
	
	private int imageResId;
	private String name;
	
	private List<Country> countries = new ArrayList<Country>();
	
	public Continent(int imageResId, String name)
	{
		this.imageResId = imageResId;
		this.name = name;
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

	public int getImageResId() {
		return imageResId;
	}

	public void setImageResId(int imageResId) {
		this.imageResId = imageResId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
