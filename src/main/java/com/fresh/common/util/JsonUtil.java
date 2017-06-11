package com.fresh.common.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

public class JsonUtil {

    private JsonUtil() {
    }

    /**
     * 对象转换成json字符串
     */
    public static String toJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    /**
     * json字符串转成对象
     */
    public static Map<String, Object> fromJsonToMap(String str) {
        Gson gson = new Gson();
        return gson.fromJson(str, new TypeToken<Map<String, Object>>() {
        }.getType());
    }

    /**
     * json字符串转成map对象
     */
    public static <T> T fromJson(String str, Type type) {
        Gson gson = new Gson();
        return gson.fromJson(str, type);
    }

    /**
     * json字符串转成对象
     */
    public static <T> T fromJson(String str, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(str, type);
    }
}
