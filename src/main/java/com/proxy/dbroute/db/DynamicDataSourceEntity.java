package com.proxy.dbroute.db;

/**
 * 动态切换数据源
 * author:曲终、人散
 * Date:2019/4/8 21:21
 */
public class DynamicDataSourceEntity {

    public static final String DEFAULE_SOURSE = null;

    private static final ThreadLocal<String> local = new ThreadLocal<String>();

    private DynamicDataSourceEntity() {
    }

    /**
     * 获取当前正在使用的数据源
     * @return
     */
    public static String get() {
        return local.get();
    }

    /**
     * 还原当前切面的数据源
     */
    public static void restore() {
        local.set(DEFAULE_SOURSE);
    }

    /**
     * 设置已知名称的数据源
     * @param souece
     */
    public static void set(String souece) {
        local.set(souece);
    }

    /**
     * 根据年份动态设置老数据源
     * @param year
     */
    public static void set(int year) {
        local.set("DB_" + year);
    }
}
