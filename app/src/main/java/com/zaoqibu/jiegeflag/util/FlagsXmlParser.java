package com.zaoqibu.jiegeflag.util;

import android.content.res.XmlResourceParser;

import com.zaoqibu.jiegeflag.domain.Continent;
import com.zaoqibu.jiegeflag.domain.Country;
import com.zaoqibu.jiegeflag.domain.World;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by vwarship on 2015/2/3.
 */
public class FlagsXmlParser {
    public World parse(XmlResourceParser parser) {
        World world = new World();

        Continent continent = null;

        try {
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    if (parser.getName().equals("continent")) {
                        String id = parser.getAttributeValue(null, "id");
                        String name = parser.getAttributeValue(null, "name");

                        continent = new Continent(name, ResourcesUtil.getDrawableId(id),
                                ResourcesUtil.getDrawableId(id), //ResourcesUtil.getRawId(id),
                                ResourcesUtil.getRawId(id));
                        world.addContinent(continent);
                    } else if (parser.getName().equals("country")) {
                        String id = parser.getAttributeValue(null, "id");
                        String name = parser.getAttributeValue(null, "name");
                        String useDate = parser.getAttributeValue(null, "useDate");
                        String aspectRatio = parser.getAttributeValue(null, "aspectRatio");
                        String design = parser.getAttributeValue(null, "design");
                        String meaning = parser.getAttributeValue(null, "meaning");

                        Country country = new Country(id, name, useDate, aspectRatio, design, meaning,
                                ResourcesUtil.getDrawableId(id),
                                ResourcesUtil.getRawId("t_"+id),
                                ResourcesUtil.getRawId(id));
                        continent.AddCountry(country);
                    }
                }

                eventType = parser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return world;
    }

}
