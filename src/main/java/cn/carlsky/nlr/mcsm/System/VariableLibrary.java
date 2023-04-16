package cn.carlsky.nlr.mcsm.System;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
    }
}