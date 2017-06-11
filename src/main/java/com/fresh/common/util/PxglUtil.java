package com.fresh.common.util;

/**
 * 工具类
 */
public class PxglUtil {
    public final static String PREFIX = "pxgl_";

    public final static String REDIS_KEY_DEPARTMENT_ID = PREFIX + "department_id_";
    public final static int TTL_DEPARTMENT_ID = 4 * 60 * 60;

    public final static String REDIS_KEY_SELECT_DEPARTMENT_ID = PREFIX + "select_department_id_";
    public final static int TTL_SELECT_DEPARTMENT_ID = 4 * 60 * 60;

    public final static String REDIS_KEY_ALL_DEPARTMENT = PREFIX + "all_department_";
    public final static int TTL_ALL_DEPARTMENT = 4 * 60 * 60;

}
