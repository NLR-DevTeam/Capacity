package cn.sky.mcsm.system;

import java.util.Date;

public class BaseManager {
    public static final int VERSION = 5;
    public static final String VERSION_STR = "Beta v1.2";
    public static final Date DATE = new Date();
    public static boolean SERVER_RUN_STATUS = false;

    // 用户类
    public static boolean LOGIN_STATUS = false;
    public static String USERNAME = null;
    public static String USERTOKEN = null;








    
    // 返回函数
    public static int getVersion(){return VERSION;}
    public static String getVersion_str(){return VERSION_STR;}
    public static Date getDate(){return DATE;}
    public static boolean getServerStatus(){return SERVER_RUN_STATUS;}
    public static String getUsername(){return USERNAME;}
    public static String getUserToken(){return USERTOKEN;}
    public static boolean getLoginStatus(){return LOGIN_STATUS;}
}
