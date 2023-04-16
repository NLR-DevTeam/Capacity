package cn.carlsky.nlr.mcsm.System;

import cn.carlsky.nlr.lib.io;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class VariableLibrary {
    public static class System {
        public static int VERSION = 17;
        public static String VERSION_STR = "正式版 v3.0.4";
        public static final Date StartTime = new Date();
    }
    public static class Storage {
        public static Boolean UserLoginStatus = false;
        public static String UserName = new String();
        public static String UserLoginToken = new String();



        // Storage HashMap Part
        public static HashMap<String, JSONObject> HashMapServerJSONObject = new HashMap<String, JSONObject>();
        public static HashMap<String, String> HashMapServerOutput = new HashMap<String, String>();
        public static HashMap<String, Process> HashMapServerProcess = new HashMap<String, Process>();
        public static HashMap<String, List> HashMapServerStartCommand = new HashMap<String, List>();
//        public static HashMap<String, JSONObject> HashMapServerPlannedTasksManager = new HashMap<String, JSONObject>();
        public static HashMap<String, JSONObject> HashMapPresetTaskManager = new HashMap<String, JSONObject>();


        public static HashMap<Integer, String> randIDMap = new HashMap<Integer, String>();

        public static String ServerList() throws IOException {
            // 把已存在的 main.properties 读到 VariableLibrary 中
            Properties MainSetting = new Properties();
            InputStream PropertiesStream = io.Properties.GetStream("MCServerManager/Setting/main.properties");
            MainSetting.load(PropertiesStream);

            return MainSetting.getProperty("serverList");
        }
    }
}