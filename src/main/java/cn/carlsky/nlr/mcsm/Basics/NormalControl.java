package cn.carlsky.nlr.mcsm.Basics;

import cn.carlsky.nlr.mcsm.System.Ask;
import cn.carlsky.nlr.mcsm.System.MainThread;
import cn.carlsky.nlr.mcsm.System.ThreadsOut;
import cn.carlsky.nlr.lib.io;
import cn.carlsky.nlr.lib.net;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

public class NormalControl {
    public static void AgreeEULA() throws IOException {
        io.FileWriter("eula.txt", "eula=true");
        MainThread.Run();
    }

    public static void CheckIP() throws IOException {
        InetAddress address = InetAddress.getLocalHost();
        String PublicIP = net.fetch("https://api.arkpowered.cn/library/public/network/getip");

        ThreadsOut.INFO.Output("");
        ThreadsOut.INFO.Output("本地IP：" + address.getHostAddress());
        ThreadsOut.INFO.Output("公共IP：" + PublicIP);
        ThreadsOut.INFO.Output("");

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
