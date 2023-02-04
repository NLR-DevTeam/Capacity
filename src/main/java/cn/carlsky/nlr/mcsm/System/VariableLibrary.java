package cn.carlsky.nlr.mcsm.System;

import com.alibaba.fastjson2.JSONObject;

import java.io.BufferedWriter;
import java.util.Date;
import java.util.HashMap;

public class VariableLibrary {
    public class System {
        public static int VERSION = 7;
        public static String VERSION_STR = "Beta v2.0 SNAPSHOT";
        public static final Date DATE = new Date();
    }
    public class Storage {
        public static Boolean UserLoginStatus = false;
        public static String UserName = new String();
        public static String UserLoginToken = new String();
        public static HashMap<String, JSONObject> HashMapServerJSONObject = new HashMap<String, JSONObject>();
        public static HashMap<String, String> HashMapServerOutput = new HashMap<String, String>();
        public static HashMap<String, Process> HashMapServerProcess = new HashMap<String, Process>();
//        public static HashMap<String, String> HashMapServerBufferedWriterString = new HashMap<String, String>();
    }
}