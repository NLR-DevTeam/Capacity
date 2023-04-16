package cn.carlsky.nlr.mcsm.System;

import cn.carlsky.nlr.lib.data;
import cn.carlsky.nlr.lib.io;
import cn.carlsky.nlr.lib.net;
import cn.carlsky.nlr.mcsm.Basics.ProcessFunctionLibrary;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.sun.tools.javac.Main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class GUI {
    public static String LOGINSTATUS;
    public static void MainGUI() {

        // 判断登录状态
        if (VariableLibrary.Storage.UserLoginStatus.equals(true)) {
            LOGINSTATUS = "已登录";
        } else {
            LOGINSTATUS = "未登录";
        }

        ThreadLogger.use.OutLine.NoHead();
        ThreadLogger.INFO.Output("============================= MCSManager ==============================");
        ThreadLogger.INFO.Output(" MCServerManager " + VariableLibrary.System.VERSION_STR);
        ThreadLogger.INFO.Output(" Github 开源地址：https://github.com/NLR-DevTeam/MinecraftServerManager");
        ThreadLogger.INFO.Output(" 使用代表您同意并遵守方块盒子服务条款：https://arkpowered.cn/tos");
        ThreadLogger.INFO.Output("=============================== 用户信息 ===============================");
        ThreadLogger.INFO.Output(" 登录状态：" + LOGINSTATUS);
        if (VariableLibrary.Storage.UserLoginStatus.equals(true)) {
            ThreadLogger.INFO.Output(" 用户名：" + VariableLibrary.Storage.UserName);
        }
        ThreadLogger.INFO.Output("=============================== 系统信息 ===============================");
        ThreadLogger.INFO.Output(" Java 运行环境：" + System.getProperty("java.version"));
        ThreadLogger.INFO.Output(" 当前时间：" + data.Time.getDate());
        ThreadLogger.INFO.Output(" 程序启动时间：" + data.Time.getStartDate());
        ThreadLogger.INFO.Output("=============================== 管理菜单 ===============================");
        ThreadLogger.INFO.Output(" 1.服务器实例管理");
        ThreadLogger.INFO.Output(" 2.同意 EULA 协议");
        ThreadLogger.INFO.Output(" 3.使用简易工具下载服务端");
        ThreadLogger.INFO.Output(" 4.查看自己的内网和公网IP");
        ThreadLogger.INFO.Output(" 5.查看mods");
        ThreadLogger.INFO.Output(" 6.查看plugins");
        ThreadLogger.INFO.Output(" 7.更改服务器设置");
        ThreadLogger.INFO.Output(" 8.进入开发者菜单");
        ThreadLogger.INFO.Output(" 9.管理服务器快捷命令");
        if (VariableLibrary.Storage.UserLoginStatus.equals(true)) {
            ThreadLogger.INFO.Output(" 97.管理方块盒子账户");
        } else {
            ThreadLogger.INFO.Output(" 97.登录方块盒子账户");
        }
        ThreadLogger.INFO.Output(" 98.反馈Bugs/提供建议");
        ThreadLogger.INFO.Output(" 99.退出程序");
        ThreadLogger.INFO.Output("=======================================================================");
        ThreadLogger.INFO.Output(" 输入 /help 可呼出帮助菜单");
        ThreadLogger.INFO.Output("=======================================================================");
        ThreadLogger.NoLine.INFO.Scanner(" 请输入命令序号或指令：");
    }

    public static void HelpGUI() {

        ThreadLogger.use.OutLine.NoHead();
        ThreadLogger.INFO.Output("=============================== 帮助菜单 ===============================");
        ThreadLogger.INFO.Output(" /manage 服务器实例管理");
        ThreadLogger.INFO.Output(" /eula 同意 EULA 协议");
        ThreadLogger.INFO.Output(" /download 使用简易工具下载服务端");
        ThreadLogger.INFO.Output(" /ip 查看自己的内网和公网IP");
        ThreadLogger.INFO.Output(" /checkmods 查看mods");
        ThreadLogger.INFO.Output(" /checkplugins 查看plugins");
        ThreadLogger.INFO.Output(" /setserver 更改服务器设置");
        ThreadLogger.INFO.Output(" /developermode 进入开发者菜单");
        ThreadLogger.INFO.Output(" /task 管理服务器快捷命令");
        ThreadLogger.INFO.Output(" /account 管理账户");
        ThreadLogger.INFO.Output(" /support 反馈Bugs or 提供建议");
        ThreadLogger.INFO.Output(" /exit /quit 退出程序");
        ThreadLogger.INFO.Output("=======================================================================");
    }

    public static void ServerListGUI() {
        ThreadLogger.use.OutLine.NoHead();
        ThreadLogger.INFO.Output("============================== 服务端实例 ==============================");

        // 遍历 HashMap
        int i;
        i = 1;
        for (Map.Entry<String, JSONObject> entry: VariableLibrary.Storage.HashMapServerJSONObject.entrySet()) {
            String OnlyID = entry.getKey();
            JSONObject VALUE = entry.getValue();

            String ServerName = VALUE.getString("ServerName");
            String ServerJarName = VALUE.getString("ServerJarName");
            String CreateTime = VALUE.getString("CreateTime");

            String STATUS_STR;
            if (VariableLibrary.Storage.HashMapServerProcess.isEmpty()){
                STATUS_STR = "启动中";
            } else {
                if(VariableLibrary.Storage.HashMapServerProcess.get(OnlyID).isAlive()) {
                    STATUS_STR = "运行中";
                } else {
                    STATUS_STR = "已关闭";
                }
            }

            ThreadLogger.INFO.Output(i + ". " + ServerName);
            ThreadLogger.INFO.Output("    唯一识别ID：" + OnlyID);
            ThreadLogger.INFO.Output("    服务器运行的Jar文件：" + ServerJarName);
            ThreadLogger.INFO.Output("    服务器创建时间：" + CreateTime);
            ThreadLogger.INFO.Output("    线程运行情况：" + STATUS_STR);
            ThreadLogger.INFO.Output("");
            i++;
        }
        // 遍历 HashMap 结束

        ThreadLogger.INFO.Output("=============================== 管理菜单 ===============================");
        ThreadLogger.INFO.Output(" 1.创建新服务器实例");
        ThreadLogger.INFO.Output(" 2.删除服务器实例（同时会强制结束服务器进程）");
        ThreadLogger.INFO.Output(" 3.查看某一实例运行情况");
        ThreadLogger.INFO.Output(" 4.输入服务器命令");
        ThreadLogger.INFO.Output(" 5.结束服务器实例");
        ThreadLogger.INFO.Output(" 99.返回主菜单");
        ThreadLogger.INFO.Output("=======================================================================");
        ThreadLogger.NoLine.INFO.Scanner(" 请输入命令序号：");
    }

    public static void Download() {
        ThreadLogger.use.OutLine.NoHead();
        ThreadLogger.INFO.Output("=============================== 下载菜单 ===============================");
        ThreadLogger.INFO.Output(" 1.原版服务端");
        ThreadLogger.INFO.Output(" 2.MohistMC");
        ThreadLogger.INFO.Output(" 9.退出程序");
        ThreadLogger.INFO.Output("=======================================================================");
        ThreadLogger.NoLine.INFO.Scanner(" 请输入下载服务端类型：");
    }

    public static void SetProperties() {
        ThreadLogger.use.OutLine.NoHead();
        ThreadLogger.INFO.Output("=============================== 管理菜单 ===============================");
        ThreadLogger.INFO.Output(" 1.设置种子");
        ThreadLogger.INFO.Output(" 2.设置端口");
        ThreadLogger.INFO.Output(" 3.设置MOTD");
        ThreadLogger.INFO.Output(" 4.设置最大人数");
        ThreadLogger.INFO.Output(" 5.设置最高高度");
        ThreadLogger.INFO.Output(" 6.开启/关闭PvP");
        ThreadLogger.INFO.Output(" 7.开启/关闭正版验证");
        ThreadLogger.INFO.Output(" 8.更改游戏难度");
        ThreadLogger.INFO.Output(" 9.开启/关闭白名单");
        ThreadLogger.INFO.Output(" 10.开启/关闭飞行");
        ThreadLogger.INFO.Output(" 11.返回");
        ThreadLogger.INFO.Output("=======================================================================");
        ThreadLogger.NoLine.INFO.Scanner(" 请按照执行菜单输入命令：");
    }

    public static void DeveloperGUI() {
        ThreadLogger.use.OutLine.NoHead();
        ThreadLogger.INFO.Output("============================== 开发者菜单 ===============================");
        ThreadLogger.INFO.Output(" 1.列出Only_ID和Process PID/exited");
        ThreadLogger.INFO.Output(" 99.回到主菜单");
        ThreadLogger.INFO.Output("=======================================================================");
        ThreadLogger.NoLine.INFO.Scanner(" 请按照执行菜单输入命令：");
    }

    public static void PresetTasksGUI() {
        ThreadLogger.use.OutLine.NoHead();
        ThreadLogger.INFO.Output("============================= 预设任务列表 ==============================");
        // 遍历 HashMap
        int i;
        i = 1;
        for (Map.Entry<String, JSONObject> entry: VariableLibrary.Storage.HashMapPresetTaskManager.entrySet()) {
            String CommandID = entry.getKey();
            JSONObject VALUE = entry.getValue();

            String COMMAND = VALUE.getString("command");
            String OnlyID = VALUE.getString("only_id");

            ThreadLogger.INFO.Output(" 快捷任务 " + i + " 命令ID：" + CommandID);
            ThreadLogger.INFO.Output("    唯一识别ID：" + OnlyID);
            ThreadLogger.INFO.Output("    命令内容：" + COMMAND);
            ThreadLogger.INFO.Output("");
            i++;
        }
        ThreadLogger.INFO.Output("============================= 预设任务菜单 ==============================");
        ThreadLogger.INFO.Output(" 1.新建一个预设任务");
        ThreadLogger.INFO.Output(" 2.运行任务");
        ThreadLogger.INFO.Output(" 99.回到主菜单");
        ThreadLogger.INFO.Output("=======================================================================");
        ThreadLogger.NoLine.INFO.Scanner(" 请按照执行菜单输入命令：");
    }

    public static void AccountGUI() {
        ThreadLogger.use.OutLine.NoHead();
        ThreadLogger.INFO.Output("============================= 管理您的账户 ==============================");
        ThreadLogger.INFO.Output("============================= 可选操作项目 ==============================");
        ThreadLogger.INFO.Output(" 1.查看云存储信息");
        ThreadLogger.INFO.Output(" 98.退出方块盒子账户");
        ThreadLogger.INFO.Output(" 99.回到主菜单");
        ThreadLogger.INFO.Output("=======================================================================");
        ThreadLogger.NoLine.INFO.Scanner(" 请按照执行菜单输入命令：");
    }

    public static void CloudServiceGUI() throws IOException {
        ThreadLogger.use.OutLine.NoHead();
        ThreadLogger.INFO.Output("============================= 管理您的本地 ==============================");

        String ServerList = VariableLibrary.Storage.ServerList();

        if (!Objects.equals(ServerList, "{}")) {

            ThreadLogger.INFO.Output(" 本地serverList信息：" + ServerList);

        } else {
            ThreadLogger.INFO.Output(" 本地存储为空");
        }

        ThreadLogger.INFO.Output("============================= 管理您的云存储 =============================");

        String CloudData = net.fetch("https://service.cloud.arkpowered.cn/api/mcsm/save/get.php?username=" + VariableLibrary.Storage.UserName + "&usertoken=" + VariableLibrary.Storage.UserLoginToken);

        JSONObject JSONCloudData = JSON.parseObject(CloudData);

        String CloudDataINFO;

        if (CloudData.equals("{}")) {
            CloudDataINFO = "云端没有数据/数据为空值";
        } else {
            if (Objects.equals(JSONCloudData.get("status"), "1")) {
                if (JSONCloudData.getString("cloudinfo").equals("{}")) {
                    CloudDataINFO = "云端没有数据/数据为空值";
                } else {
                    CloudDataINFO = (String) JSONCloudData.get("cloudinfo");
                }
            } else {
                CloudDataINFO = "云端没有数据/数据为空值";
            }
        }

        ThreadLogger.INFO.Output(" 云端保存信息：" + CloudDataINFO);

        ThreadLogger.INFO.Output("============================= 可选操作项目 ==============================");
        ThreadLogger.INFO.Output(" 1.同步到云端");
        ThreadLogger.INFO.Output(" 2.下载到本地");
        ThreadLogger.INFO.Output(" 99.回到上一级菜单");
        ThreadLogger.INFO.Output("=======================================================================");
        ThreadLogger.NoLine.INFO.Scanner(" 请按照执行菜单输入命令：");
    }

    public static void INFO() {
        ThreadLogger.INFO.Output("============================= 开发组织信息 ==============================");
        ThreadLogger.INFO.Output("  NLR DevTeam");
        ThreadLogger.INFO.Output("  目前维护和开发人员：CarlSky");
        ThreadLogger.INFO.Output("  感谢大家长期的支持和建议！");
        ThreadLogger.INFO.Output("");
        ThreadLogger.INFO.Output("  https://www.nlrdev.top");
        ThreadLogger.INFO.Output("=======================================================================");
    }
}
