package cn.carlsky.nlr.mcsm.Basics.Download;



import cn.carlsky.nlr.mcsm.Basics.Download.Node.VanillaServer;
import cn.carlsky.nlr.mcsm.System.GUI;
import cn.carlsky.nlr.mcsm.Basics.Download.Node.MohistServer;
import cn.carlsky.nlr.mcsm.System.MainThread;

import java.io.IOException;
import java.util.Scanner;

public class DownloadRequire {
    public static void DownloadMCServerVersion() throws IOException {

        GUI.Download();

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
