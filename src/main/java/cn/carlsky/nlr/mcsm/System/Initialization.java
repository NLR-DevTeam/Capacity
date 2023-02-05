package cn.carlsky.nlr.mcsm.System;

import cn.carlsky.nlr.lib.net;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

public class Initialization {
    public static void Start() {
        ThreadLogger.INFO.Output("=========================== Initialization ============================");
        ThreadLogger.INFO.Output(" 正在初始化程序...");
        FileExist.CheckFolder();

        // 更新检查
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