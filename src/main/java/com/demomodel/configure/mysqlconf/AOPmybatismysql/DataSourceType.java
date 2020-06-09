package com.demomodel.configure.mysqlconf.AOPmybatismysql;
/**
 * 创建一个切换数据源类型的类： ThreadLocal这个知识点可以参考我的博客：https://blog.csdn.net/tuesdayma/article/details/74841657 
 * 就是为了线程的安全性，每个线程之间不会相互影响。
 * @author wgz
 * @date 创建时间：2020年4月24日 下午9:01:43
 */
public class DataSourceType {

    public enum DataBaseType {
        TEST01, TEST02
    }

    // 使用ThreadLocal保证线程安全
    private static final ThreadLocal<DataBaseType> TYPE = new ThreadLocal<DataBaseType>();

    // 往当前线程里设置数据源类型
    public static void setDataBaseType(DataBaseType dataBaseType) {
        if (dataBaseType == null) {
            throw new NullPointerException();
        }
        System.err.println("com.demomodel.configure.mysqlconf.AOPmybatismysql.DataSourceType"+"[将当前数据源改为]：" + dataBaseType);
        TYPE.set(dataBaseType);
    }

    // 获取数据源类型
    public static DataBaseType getDataBaseType() {
        DataBaseType dataBaseType = TYPE.get() == null ? DataBaseType.TEST01 : TYPE.get();
        System.err.println("com.demomodel.configure.mysqlconf.AOPmybatismysql.DataSourceType"+"[获取当前数据源的类型为]：" + dataBaseType);
        return dataBaseType;
    }

    // 清空数据类型
    public static void clearDataBaseType() {
        TYPE.remove();
    }

}
//https://blog.csdn.net/tuesdayma/java/article/details/81081666