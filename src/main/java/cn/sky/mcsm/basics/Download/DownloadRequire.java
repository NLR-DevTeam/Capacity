package cn.sky.mcsm.basics.Download;

import cn.sky.mcsm.basics.Download.Node.MohistServer;
import cn.sky.mcsm.basics.Download.Node.VanillaServer;
import cn.sky.mcsm.system.output.ThreadsOut;

import java.io.IOException;
import java.util.Scanner;

public class DownloadRequire {
    public static void DownloadMCServerVersion() throws IOException {
        System.out.println("");
        ThreadsOut.outNormal(" =================执行菜单=================", "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal(" 1.原版服务端", "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal(" 2.MohistMC", "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal(" 9.退出程序", "INFO", "Main Thread", "Output");
        ThreadsOut.outNormal(" ==========================================", "INFO", "Main Thread", "Output");
        ThreadsOut.outWithNoLine(" 请输入下载服务端类型：", "INFO", "Main Thread", "Output");

        Scanner code = new Scanner(System.in);
        String code_input = code.nextLine();
        switch (code_input) {
            case "1":
                VanillaServer.AskVersion();
                break;
            case "2":
                MohistServer.AskVersion();
                break;
            default:
                DownloadMCServerVersion();
                break;
        }
    }
}
