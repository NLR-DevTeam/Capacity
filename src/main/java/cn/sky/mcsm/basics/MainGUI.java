package cn.sky.mcsm.basics;

import cn.sky.mcsm.system.BaseManager;
import cn.sky.mcsm.system.output.ThreadsOut;

public class MainGUI {
    public static void GUI() {

        String USERINFO = "用户尚未登录";
        if (BaseManager.getLoginStatus()) {
            USERINFO = "用户名称：" + BaseManager.getUsername();
        }

        System.out.println("\n");
        ThreadsOut.outNormal("==========================================", "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal(" 欢迎使用方块盒子MC服务器管理器！", "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal(" ", "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal(" 使用该工具代表您同意方块盒子服务条款和EULA协议", "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal(" 方块盒子Tos：https://arkpowered.cn/tos", "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal(" 当前版本：" + BaseManager.VERSION_STR, "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal("=================用户信息=================", "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal(" " + USERINFO, "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal("=================环境检查=================", "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal(" Java 运行环境：" + System.getProperty("java.version"), "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal(" 时间：" + BaseManager.DATE, "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal("=================执行菜单=================", "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal(" 1.运行 MCSM 下载的服务端", "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal(" 2.运行 自定义 服务端", "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal(" 3.下载服务端", "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal(" 4.查询 IP 地址", "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal(" 5.同意所有的 EULA 协议", "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal(" 6.列出已装配的 Mods", "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal(" 7.列出已装配的插件", "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal(" 8.更改服务器主要设置", "INFO", "Main Thread", "Output");

        Boolean userLoginStatus = BaseManager.getLoginStatus();
        if (!userLoginStatus) {
            ThreadsOut.outNormal(" 97.登录您的方块盒子账户", "INFO", "Main Thread", "Output");
        }else{
            ThreadsOut.outNormal(" 97.退出登录方块盒子账户", "INFO", "Main Thread", "Output");
        }

        ThreadsOut.outNormal(" 98.反馈 Bugs/提出建议", "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal(" 99.退出程序", "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal("==========================================", "INFO", "Main Thread", "Output");
        ThreadsOut.outWithNoLine(" 请输入命令序号：", "INFO", "Main Thread", "Scanner");
    }
}
