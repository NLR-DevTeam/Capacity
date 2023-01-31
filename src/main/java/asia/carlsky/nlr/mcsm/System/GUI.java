package asia.carlsky.nlr.mcsm.System;

import com.alibaba.fastjson2.JSONObject;

import javax.swing.text.StyledEditorKit;
import java.util.Map;

public class GUI {
    public static String LOGINSTATUS;
    public static void MainGUI() {

        if (VariableLibrary.Storage.UserLoginStatus.equals(true)) {
            LOGINSTATUS = "已登录";
        } else {
            LOGINSTATUS = "未登录";
        }

        ThreadsOut.INFO.Output("============================= MCSManager ==============================");
        ThreadsOut.INFO.Output(" MCServerManager " + VariableLibrary.System.VERSION_STR);
        ThreadsOut.INFO.Output(" Github 开源地址：https://github.com/NLR-DevTeam/MinecraftServerManager");
        ThreadsOut.INFO.Output(" 使用代表您同意并遵守方块盒子服务条款：https://arkpowered.cn/tos");
        ThreadsOut.INFO.Output("=============================== 用户信息 ===============================");
        ThreadsOut.INFO.Output("登录状态：" + LOGINSTATUS);
        if (VariableLibrary.Storage.UserLoginStatus.equals(true)) {
            ThreadsOut.INFO.Output("用户名：" + VariableLibrary.Storage.UserName);
        }
        ThreadsOut.INFO.Output("=============================== 系统信息 ===============================");
        ThreadsOut.INFO.Output(" Java 运行环境：" + System.getProperty("java.version"));
        ThreadsOut.INFO.Output(" 当前时间：" + VariableLibrary.System.DATE);
        ThreadsOut.INFO.Output("=============================== 管理菜单 ===============================");
        ThreadsOut.INFO.Output(" 1.服务器实例管理");
        ThreadsOut.INFO.Output(" 2.同意 EULA 协议");
        ThreadsOut.INFO.Output(" 3.使用简易工具下载服务端");
        ThreadsOut.INFO.Output(" 4.查看自己的内网和公网IP");
        ThreadsOut.INFO.Output(" 5.查看mods");
        ThreadsOut.INFO.Output(" 6.查看plugins");
        ThreadsOut.INFO.Output(" 7.更改服务器设置");
        if (VariableLibrary.Storage.UserLoginStatus.equals(true)) {
            ThreadsOut.INFO.Output(" 97.退出登录方块盒子账户");
        } else {
            ThreadsOut.INFO.Output(" 97.登录方块盒子账户");
        }
        ThreadsOut.INFO.Output(" 98.反馈Bugs/提供建议");
        ThreadsOut.INFO.Output(" 99.退出程序");
        ThreadsOut.INFO.Output("=======================================================================");
        ThreadsOut.NoLine.INFO.Scanner(" 请输入命令序号：");
    }

    public static void ServerListGUI() {
        ThreadsOut.INFO.Output("============================== 服务端实例 ==============================");

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
                STATUS_STR = "已挂载(运行中或已关闭)";
            }

            ThreadsOut.INFO.Output(i + ". " + ServerName);
            ThreadsOut.INFO.Output("    唯一识别ID：" + OnlyID);
            ThreadsOut.INFO.Output("    服务器运行的Jar文件：" + ServerJarName);
            ThreadsOut.INFO.Output("    服务器创建时间：" + CreateTime);
            ThreadsOut.INFO.Output("    线程运行情况：" + STATUS_STR);
            ThreadsOut.INFO.Output("");
            i++;
        }
        // 遍历 HashMap 结束

        ThreadsOut.INFO.Output("=============================== 管理菜单 ===============================");
        ThreadsOut.INFO.Output(" 1.创建新服务器实例");
        ThreadsOut.INFO.Output(" 2.删除服务器实例");
        ThreadsOut.INFO.Output(" 3.查看某一实例运行情况");
        ThreadsOut.INFO.Output(" 99.返回主菜单");
        ThreadsOut.INFO.Output("=======================================================================");
        ThreadsOut.NoLine.INFO.Scanner(" 请输入命令序号：");
    }

    public static void Download() {
        System.out.println("");
        ThreadsOut.INFO.Output("=============================== 下载菜单 ===============================");
        ThreadsOut.INFO.Output(" 1.原版服务端");
        ThreadsOut.INFO.Output(" 2.MohistMC");
        ThreadsOut.INFO.Output(" 9.退出程序");
        ThreadsOut.INFO.Output("=======================================================================");
        ThreadsOut.NoLine.INFO.Scanner(" 请输入下载服务端类型：");
    }

    public static void SetProperties() {
        ThreadsOut.INFO.Output("=============================== 管理菜单 ===============================");
        ThreadsOut.INFO.Output(" 1.设置种子");
        ThreadsOut.INFO.Output(" 2.设置端口");
        ThreadsOut.INFO.Output(" 3.设置MOTD");
        ThreadsOut.INFO.Output(" 4.设置最大人数");
        ThreadsOut.INFO.Output(" 5.设置最高高度");
        ThreadsOut.INFO.Output(" 6.开启/关闭PvP");
        ThreadsOut.INFO.Output(" 7.开启/关闭正版验证");
        ThreadsOut.INFO.Output(" 8.更改游戏难度");
        ThreadsOut.INFO.Output(" 9.开启/关闭白名单");
        ThreadsOut.INFO.Output(" 10.开启/关闭飞行");
        ThreadsOut.INFO.Output(" 11.返回");
        ThreadsOut.INFO.Output("=======================================================================");
        ThreadsOut.NoLine.INFO.Scanner(" 请按照执行菜单输入命令：");
    }
}
