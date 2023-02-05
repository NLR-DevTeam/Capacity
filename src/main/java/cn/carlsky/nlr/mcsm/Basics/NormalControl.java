package cn.carlsky.nlr.mcsm.Basics;

import cn.carlsky.nlr.lib.data;
import cn.carlsky.nlr.mcsm.System.Ask;
import cn.carlsky.nlr.mcsm.System.MainThread;
import cn.carlsky.nlr.mcsm.System.ThreadLogger;
import cn.carlsky.nlr.lib.io;
import cn.carlsky.nlr.lib.net;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

public class NormalControl {
    public static void SearchMods() throws IOException {
        ThreadLogger.NoLine.INFO.Scanner("您想浏览哪个文件夹mods（例如 Server/ 目录下的就输入Server，当前目录则留空）：");
        String dir = data.Scan();

        if(dir.isEmpty()) {
            NormalControl.CheckDirFiles.listDirFiles("mods");
        } else {
            NormalControl.CheckDirFiles.listDirFiles(dir + "/mods");
        }
    }
    public static void SearchPlugins() throws IOException {
        ThreadLogger.NoLine.INFO.Scanner("您想浏览哪个文件夹plugins（例如 Server/ 目录下的就输入Server，当前目录则留空）：");
        String dir = data.Scan();

        if(dir.isEmpty()) {
            NormalControl.CheckDirFiles.listDirFiles("plugins");
            System.out.println("e");
        } else {
            NormalControl.CheckDirFiles.listDirFiles(dir + "/plugins");
        }
    }
    public static void AgreeEULA() throws IOException {
        ThreadLogger.NoLine.INFO.Scanner("您想写哪个文件夹下的EULA（例如Server/1.8.9/目录下的就输入Server/1.8.9，当前目录则留空）：");
        String dir = data.Scan();
        File DIR_FOLDER = new File(dir);

        if(!DIR_FOLDER.exists()){
            DIR_FOLDER.mkdirs();
        }

        if(dir.isEmpty()) {
            io.FileWriter("eula.txt", "eula=true");
        } else {
            io.FileWriter(dir + "/eula.txt", "eula=true");
        }
        MainThread.Run();
    }

    public static void CheckIP() throws IOException {
        InetAddress address = InetAddress.getLocalHost();
        String PublicIP = net.fetch("https://api.arkpowered.cn/library/public/network/getip");

        ThreadLogger.INFO.Output("");
        ThreadLogger.INFO.Output("本地IP：" + address.getHostAddress());
        ThreadLogger.INFO.Output("公共IP：" + PublicIP);
        ThreadLogger.INFO.Output("");

        Ask.Continue();
    }

    public class CheckDirFiles {
        public static void listDirFiles(String path) throws IOException {
            File file = new File(path);
            showList(file);
            Ask.Continue();
        }

        private static void showList(File file) {
            if (file.isDirectory()) {
                System.out.println("文件夹:" + file.getPath());
                File[] listFiles = file.listFiles();
                for (File f : listFiles) {
                    showList(f);
                }
            } else if (file.isFile()) {
                System.out.println("文件:" + file.getPath());
            }else{
                System.out.println("目录目前不存在：可能未运行服务端/不是相应API的客户端");
            }
        }
    }
}
