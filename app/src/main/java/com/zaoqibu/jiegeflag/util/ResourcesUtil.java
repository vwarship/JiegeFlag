package com.zaoqibu.jiegeflag.util;

import com.zaoqibu.jiegeflag.R;

import java.lang.reflect.Field;

/**
 * Created by vwarship on 2015/2/3.
 */
public class ResourcesUtil {
    public static int getDrawableId(String name) {
        try {
            Field field = R.drawable.class.getField(name);
            return Integer.parseInt(field.get(null).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static int getRawId(String name) {
        try {
            Field field = R.raw.class.getField(name);
            return Integer.parseInt(field.get(null).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

}
