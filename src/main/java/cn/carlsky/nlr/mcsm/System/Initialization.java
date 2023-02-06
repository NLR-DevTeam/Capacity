package cn.carlsky.nlr.mcsm.System;

import cn.carlsky.nlr.lib.io;
import cn.carlsky.nlr.lib.net;
import cn.carlsky.nlr.mcsm.Basics.ProcessFunctionLibrary;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.sun.tools.javac.Main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class Initialization {
    public static void Start() throws IOException {
        ThreadLogger.INFO.Output("=========================== Initialization ============================");
        ThreadLogger.INFO.Output(" 正在初始化程序...");
        FileExist.CheckFolder();
        FileExist.CheckMCProperties();
        FileExist.CheckMCSMSetting();

        // 把已存在的 main.properties 读到 VariableLibrary 中
        Properties MainSetting = new Properties();
        InputStream PropertiesStream = io.Properties.GetStream("MCServerManager/Setting/main.properties");
        MainSetting.load(PropertiesStream);
        String ServerList = MainSetting.getProperty("serverList");
        JSONObject SettingJSON = JSON.parseObject(ServerList);

        if (SettingJSON.get("serverList") != "{}") {

            String entryScanString = ServerList;
            JSONObject entryScan = JSON.parseObject(entryScanString);

            for (Map.Entry<String, Object> entry : entryScan.entrySet()) {

                String Value = entryScan.getString(entry.getKey());
                JSONObject JSONValue = JSON.parseObject(Value);

                String SERVER_NAME = JSONValue.getString("ServerName");
                String SERVER_DIR = JSONValue.getString("ServerDir");
                String SERVER_JAR = JSONValue.getString("ServerJarName");
                Boolean SERVER_AUTOSTART = JSONValue.getBoolean("AutoStart");

                if (SERVER_AUTOSTART) {
                    ProcessFunctionLibrary.RegisterNewMCThread(SERVER_NAME, SERVER_DIR, SERVER_JAR, entry.getKey());
                    ThreadLogger.INFO.Output(" 已注册服务器：" + entry.getKey() + ":" + entry.getValue());
                }

            }

        }

        // 检查更新
        CheckUpdate();
    }



    private static void CheckUpdate() {
        ThreadLogger.INFO.Output(" 执行更新检查...");

        String CheckVersion = net.fetch("https://api.arkpowered.cn/library/public/mcsm/version.json");
        JSONObject CheckVersionJSON = JSON.parseObject(CheckVersion);

        int LatestVersion = Integer.parseInt(CheckVersionJSON.getString("LatestVersion"));
        int TestVersion = Integer.parseInt(CheckVersionJSON.getString("TestVersion"));
        int DeveloperVersion = Integer.parseInt(CheckVersionJSON.getString("DevelopingVersion"));

        if (LatestVersion == VariableLibrary.System.VERSION) {

            VariableLibrary.System.VERSION_STR = VariableLibrary.System.VERSION_STR + " 发行版";
            ThreadLogger.INFO.Output(" 您使用的是最新版本 MCSManager！ 版本：" + VariableLibrary.System.VERSION_STR);

        } else {

            if (LatestVersion > VariableLibrary.System.VERSION) {

                VariableLibrary.System.VERSION_STR = VariableLibrary.System.VERSION_STR + " 发行版（旧版本）";
                ThreadLogger.INFO.Output(" 您使用的是较为老旧的MCSM版本，您可以前往 https://github.com/NLR-DevTeam/MinecraftServerManager 更新");
                Ask.Continue();

            } else {
                if(TestVersion == VariableLibrary.System.VERSION) {

                    VariableLibrary.System.VERSION_STR = VariableLibrary.System.VERSION_STR + " 测试版";
                    ThreadLogger.INFO.Output(" 测试者版本！感谢使用~ 版本：" + VariableLibrary.System.VERSION_STR);

                } else {
                    if (DeveloperVersion == VariableLibrary.System.VERSION) {

                        VariableLibrary.System.VERSION_STR = VariableLibrary.System.VERSION_STR + " 开发中版本";
                        ThreadLogger.INFO.Output(" 开发中的版本！感谢使用~ 版本：" + VariableLibrary.System.VERSION_STR);

                    } else {

                        VariableLibrary.System.VERSION_STR = VariableLibrary.System.VERSION_STR + " ...不可理解的版本";
                        ThreadLogger.INFO.Output(" 无法理解您使用的版本...？？ 版本：" + VariableLibrary.System.VERSION_STR);
                        Ask.Continue();

                    }
                }
            }
        }
    }
}