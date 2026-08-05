package com.uedsonreis.ecommerce.util;

import com.google.gson.Gson;

public class JsonUtil {

    private static final Gson GSON = new Gson();

    public static String toJson(Object obj) {
        return GSON.toJson(obj);
    }

    public static <T> T toObject(String json, Class<T> classOf) {
        return GSON.fromJson(json, classOf);
    }

}