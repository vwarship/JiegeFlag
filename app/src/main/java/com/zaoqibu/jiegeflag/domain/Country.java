package com.zaoqibu.jiegeflag.domain;

import java.io.Serializable;

public class Country implements Serializable
{
	private static final long serialVersionUID = -1771527299362743994L;

    private String id;
    private String name;
    private String useDate;
    private String aspectRatio;
    private String design;
    private String meaning;

	private int flagResId;
	private int soundResId;

	public Country(String id, String name, String useDate, String aspectRatio, String design, String meaning,
                   int flagResId, int soundResId) {
        this.id = id;
        this.name = name;
        this.useDate = useDate;
        this.aspectRatio = aspectRatio;
        this.design = design;
        this.meaning = meaning;

		this.flagResId = flagResId;
		this.soundResId = soundResId;
	}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUseDate() {
        return useDate;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public String getDesign() {
        return design;
    }

    public String getMeaning() {
        return meaning;
    }

    public int getFlagResId() {
		return flagResId;
	}
	
	public int getSoundResId() {
		return soundResId;
	}
	
}
